package ajacker.nyacraft.api;

import ajacker.nyacraft.blocks.BlockPos;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.BlockEvent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BlocksBreaker {
    public static void breakBlocks(List<BlockPos> blocks, World world, EntityPlayerMP player) {
        int fortune=EnchantmentHelper.getEnchantmentLevel(Enchantment.fortune.effectId,player.getHeldItem());//时运等级
        int silktouch=EnchantmentHelper.getEnchantmentLevel(Enchantment.silkTouch.effectId,player.getHeldItem());//精准采集等级
        int firstmeta = world.getBlockMetadata(blocks.get(0).x, blocks.get(0).y, blocks.get(0).z);//获取第一个的方块数据
        Block firstblock = world.getBlock(blocks.get(0).x, blocks.get(0).y, blocks.get(0).z);//获取第一个的方块
        boolean canSilkHarvest=firstblock.canSilkHarvest(world,player,blocks.get(0).x,blocks.get(0).y,blocks.get(0).z,firstmeta);//能不能精准采集
        Iterator it = blocks.iterator();
        while (it.hasNext()) {
            BlockPos pos = (BlockPos) it.next();
            int meta = world.getBlockMetadata(pos.x, pos.y, pos.z);//获取当前处理的方块数据
            Block nowblock = world.getBlock(pos.x, pos.y, pos.z);//获取当前处理的方块
            BlockEvent.BreakEvent breakEvent = new BlockEvent.BreakEvent(pos.x, pos.y, pos.z, world, nowblock, meta, player);
            MinecraftForge.EVENT_BUS.post(breakEvent);//发送事件-破坏方块
            if (breakEvent.isCanceled()) return;//如果事件被取消了就啥都不做
            world.setBlockToAir(pos.x, pos.y, pos.z);//删除方块
            System.out.println("破坏方块:x=" + pos.x + ",y=" + pos.y + ",z=" + pos.z);
            //nowblock.dropBlockAsItem(world,pos.x, pos.y, pos.z,meta,0);//掉地上
            if (silktouch==0 || !canSilkHarvest){//不能精准采集或者没有精准采集附魔就掉物品
                ArrayList<ItemStack> itemlist = nowblock.getDrops(world, pos.x, pos.y, pos.z, meta, fortune);//获取挖掘所掉落的物品
                int i = 0;
                for (ItemStack item : itemlist) {//遍历掉落的物品
                    i++;//记录一共掉落了多少物品
                    System.out.print(i);
                    System.out.println(item.getDisplayName());
                    world.spawnEntityInWorld(new EntityItem(world, pos.x, pos.y, pos.z, item));///掉落物品
                    //player.entityDropItem(item,1);//掉在玩家身上
                    //if(!player.inventory.addItemStackToInventory(item))//如果放不进背包

                }
            }else{//能精准采集就掉方块
                ItemStack item=new ItemStack(nowblock.getItem(world,pos.x,pos.y,pos.z));
                world.spawnEntityInWorld(new EntityItem(world, pos.x, pos.y, pos.z, item));///掉落物品
            }

        }
    }
}
