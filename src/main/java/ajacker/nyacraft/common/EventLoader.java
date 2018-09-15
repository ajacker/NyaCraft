package ajacker.nyacraft.common;

import ajacker.nyacraft.api.BlocksBreaker;
import ajacker.nyacraft.api.VeinBlockCounter;
import ajacker.nyacraft.enchantment.EnchantmentLoader;
import cpw.mods.fml.common.eventhandler.EventBus;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.Block;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.BlockEvent;


public class EventLoader {
    public static final EventBus EVENT_BUS = new EventBus();

    public EventLoader() {
        MinecraftForge.EVENT_BUS.register(this);
        System.out.println("注册服务器事件");
    }

    @SubscribeEvent
    public void onBlockBreaked(BlockEvent.BreakEvent event) {
        if (VeinBlockCounter.count != 0) return;
        EntityPlayer player = event.getPlayer();
        if (player.worldObj.isRemote) return;
        int veinPickLevel = EnchantmentHelper.getEnchantmentLevel(EnchantmentLoader.veinPick.effectId, player.getHeldItem());//获得附魔等级
        if (veinPickLevel == 0) return;//没附魔就返回
        Item held = player.getHeldItem().getItem();//获得手中拿的物品
        Block block = event.block;
        int meta = event.blockMetadata;
        ItemStack stackBlock = new ItemStack(block, 1, meta);
        if (held instanceof ItemPickaxe) {//拿的是稿子
            if (block.getLocalizedName().equals("红石矿石") || block.getLocalizedName().equals("Redstone Ore") ||//这是判断是不是发光的红石矿的
                    block.getLocalizedName().equals("盐矿") || block.getLocalizedName().equals("Salt Ore") ||
                    OreDictionaryLoader.contains(ConfigLoader.ores, stackBlock)
                    ) {//如果是矿
                int uselimit = player.getHeldItem().getMaxDamage() - player.getHeldItem().getItemDamage();
                VeinBlockCounter.limit = uselimit < (veinPickLevel * veinPickLevel * 3) ? uselimit : (veinPickLevel * veinPickLevel * 3);//3,12,27
                VeinBlockCounter.blocks = VeinBlockCounter.count(event.world, event.x, event.y, event.z, player, block);//获取连起来的方块
                //System.out.println(VeinBlockCounter.count);
            }
        } else if (held instanceof ItemAxe) {//拿的是斧子
            if (OreDictionaryLoader.contains(ConfigLoader.woods, stackBlock)) {//如果是木头
                int uselimit = player.getHeldItem().getMaxDamage() - player.getHeldItem().getItemDamage();
                VeinBlockCounter.limit = uselimit < (veinPickLevel * veinPickLevel * 10) ? uselimit : (veinPickLevel * veinPickLevel * 10);//10,40,90
                VeinBlockCounter.blocks = VeinBlockCounter.count(event.world, event.x, event.y, event.z, player, block);//获取连起来的方块
            }
        }
    }

    /*@SubscribeEvent
    public void setBlockBreakSpeed(PlayerEvent.BreakSpeed event) {//连锁多少个就减慢挖掘速度多少倍
        //System.out.println(event.entityPlayer);
        if (VeinBlockCounter.count==0) return;//没有连锁就返回
        int count = VeinBlockCounter.count;
        if (count >= 20) count = 20;//最多三十不然太慢了
        if(count > 1)
            event.newSpeed = event.originalSpeed / (float) (count * 0.9);//新的挖掘速度等于原速度减少0.8*count倍
        System.out.println("原速度："+event.originalSpeed+",新速度:"+event.newSpeed);
    }*/

    @SubscribeEvent
    public void onBlockDroped(BlockEvent.HarvestDropsEvent event) {
        //if (event.harvester.worldObj.isRemote) return;
        if (event.harvester == null) return;
        if (VeinBlockCounter.count != 0) {//连锁列表不为空且是多人玩家
            EntityPlayer player = event.harvester;
            int veinPickLevel = EnchantmentHelper.getEnchantmentLevel(EnchantmentLoader.veinPick.effectId, player.getHeldItem());//获得附魔等级
            if (veinPickLevel == 0) return;//没附魔就返回
            //int durabilityLevel=EnchantmentHelper.getEnchantmentLevel(Enchantment.unbreaking.effectId,player.getHeldItem());//获得耐久等级
            VeinBlockCounter.blocks.remove(0);//这个已经被挖掉了
            if (VeinBlockCounter.blocks.isEmpty()) return;//除去挖了的那个没了就返回
            //System.out.println("准备破坏");
            BlocksBreaker.breakBlocks(VeinBlockCounter.blocks, event.world, player);//破坏方块列表
            //player.getHeldItem().damageItem(VeinBlockCounter.blocks.size() - 1, player);//掉耐久度
            VeinBlockCounter.blocks.clear();
        }
    }


}
