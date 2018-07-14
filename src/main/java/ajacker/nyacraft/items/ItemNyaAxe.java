package ajacker.nyacraft.items;

import ajacker.nyacraft.creativetab.CreativeTabsLoader;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraftforge.common.util.EnumHelper;

import static ajacker.nyacraft.NyaCraft.MODID;

public class ItemNyaAxe extends ItemAxe {
    public static final String ItemId = "ItemNyaAxe";
    public static final Item.ToolMaterial NYAINGOT = EnumHelper.addToolMaterial("NYAINGOT",
            1, 800, 24.0F, 0.0F, 16);

    public ItemNyaAxe() {
        super(NYAINGOT);
        this.setCreativeTab(CreativeTabsLoader.tabFMLTutor);//创造模式标签页
        this.setUnlocalizedName(MODID + "." + ItemId);//设置名字(item.nyacraft.ItemNyaAxe.name)
    }

    public void init() {
        GameRegistry.registerItem(this, ItemId);//注册物品
    }

    /*@Override
    public boolean onBlockStartBreak(ItemStack itemstack, int X, int Y, int Z, EntityPlayer living) {
        List<BlockPos> woods=new ArrayList<BlockPos>();
        World world=living.worldObj;
        Block block=world.getBlock(X,Y,Z);
        if (living instanceof EntityPlayerMP && block.isWood(world,X,Y,Z)){
            EntityPlayerMP player=(EntityPlayerMP) living;
            float hardness=block.getBlockHardness(world,X,Y,Z);
            System.out.println("硬度:"+hardness);
            woods.add(new BlockPos(X,Y,Z,world));
            int i=0;
            while(woods.size()!=0){
                int x,y,z;
                BlockPos pos=woods.get(0);
                x=pos.x;
                y=pos.y;
                z=pos.z;
                BlockPos pos1=new BlockPos(x+1,y,z,world);
                BlockPos pos2=new BlockPos(x-1,y,z,world);
                BlockPos pos3=new BlockPos(x,y+1,z,world);
                BlockPos pos4=new BlockPos(x,y-1,z,world);
                BlockPos pos5=new BlockPos(x,y,z+1,world);
                BlockPos pos6=new BlockPos(x,y,z-1,world);
                System.out.print(x+","+y+","+z);
                int meta=world.getBlockMetadata(x,y,z);//获取当前处理的方块数据
                Block nowblock=world.getBlock(x,y,z);//获取当前处理的方块
                ArrayList<ItemStack> list=nowblock.getDrops(world,x,y,z,meta,1);//获取挖掘所掉落的木头
                String name=pos.getBlockDropName();//当前处理方块的掉落物名字
                System.out.print("第一个:"+name);
                if(pos1.getBlock().equals(block) && pos1.getBlockDropName().equals(name)){//掉落物相同的方块才会添加
                    woods.add(pos1);
                }
                if(pos2.getBlock().equals(block) && pos2.getBlockDropName().equals(name)){
                    woods.add(pos2);
                }
                if(pos3.getBlock().equals(block) && pos3.getBlockDropName().equals(name)){
                    woods.add(pos3);
                }
                if(pos4.getBlock().equals(block) && pos4.getBlockDropName().equals(name)){
                    woods.add(pos4);
                }
                if(pos5.getBlock().equals(block) && pos5.getBlockDropName().equals(name)){
                    woods.add(pos5);
                }
                if(pos6.getBlock().equals(block) && pos6.getBlockDropName().equals(name)){
                    woods.add(pos6);
                }
                world.setBlockToAir(x,y,z);//删除方块
                ArrayList<ItemStack> itemlist=nowblock.getDrops(world,x,y,z,meta,1);//获取挖掘所掉落的木头
                for (ItemStack item:itemlist) {
                    i++;//记录一共掉落了多少木头
                    System.out.print(item.getDisplayName());
                    if(!player.inventory.addItemStackToInventory(item))//如果放不进背包
                        nowblock.dropBlockAsItem(world,x,y,z,meta,0);//就掉地上
                }
                //player.inventory.addItemStackToInventory(item);
                woods.remove(0);
            }
            player.addChatMessage(new ChatComponentText("玩家 "+
                    player.getDisplayName()+
                    " 玩家挖掘了 "+i+"个"+block.getLocalizedName()));
        }
        return true;

    }

    @Override
    public boolean onBlockDestroyed(ItemStack itemstack, World world, Block block, int X, int Y, int Z, EntityLivingBase living) {
        List<BlockPos> woods=new ArrayList<BlockPos>();
        if (living instanceof EntityPlayerMP && block.isWood(world,X,Y,Z)){
            EntityPlayerMP player=(EntityPlayerMP) living;
            woods.add(new BlockPos(X,Y,Z));
            int i=0;
            while(woods.size()!=0){
                int x,y,z;
                BlockPos blockpos=woods.get(0);
                x=(int)blockpos.x;
                y=(int)blockpos.y;
                z=(int)blockpos.z;
                System.out.println(x+","+y+","+z);
                if(world.getBlock(x+1,y,z).isWood(world,x+1,y,z)){
                    woods.add(new BlockPos(x+1,y,z));
                }
                if(world.getBlock(x-1,y,z).isWood(world,x-1,y,z)){
                    woods.add(new BlockPos(x-1,y,z));
                }
                if(world.getBlock(x,y+1,z).isWood(world,x,y+1,z)){
                    woods.add(new BlockPos(x,y+1,z));
                }
                if(world.getBlock(x,y-1,z).isWood(world,x,y-1,z)){
                    woods.add(new BlockPos(x,y-1,z));
                }
                if(world.getBlock(x,y,z+1).isWood(world,x,y,z+1)){
                    woods.add(new BlockPos(x,y,z+1));
                }
                if(world.getBlock(x,y,z-1).isWood(world,x,y,z-1)){
                    woods.add(new BlockPos(x,y,z-1));
                }
                int meta=world.getBlockMetadata(x,y,z);
                Block nowblock=world.getBlock(x,y,z);
                world.setBlockToAir(x,y,z);
                ArrayList<ItemStack> itemlist=nowblock.getDrops(world,x,y,z,meta,1);//获取挖掘所掉落的木头
                for (ItemStack item:itemlist) {
                    i++;//记录一共掉落了多少木头
                    System.out.print(item.getDisplayName());
                    if(!player.inventory.addItemStackToInventory(item))//如果放不进背包
                        nowblock.dropBlockAsItem(world,x,y,z,meta,0);//就掉地上
                }
                //player.inventory.addItemStackToInventory(item);
                woods.remove(0);
            }
            player.addChatMessage(new ChatComponentText("玩家 "+
                    player.getDisplayName()+
                    " 玩家挖掘了 "+i+"个"+block.getLocalizedName()));
        }
        return true;
    }*/
}
