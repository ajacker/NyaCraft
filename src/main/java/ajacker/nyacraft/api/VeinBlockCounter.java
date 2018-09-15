package ajacker.nyacraft.api;

import ajacker.nyacraft.blocks.BlockPos;
import ajacker.nyacraft.network.MessageVeinBlockCount;
import ajacker.nyacraft.network.NetWorkLoader;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class VeinBlockCounter {
    public static List<BlockPos> blocks;
    public static int limit=1024;
    public static int count;
    public static List<BlockPos> count(World world, int X, int Y, int Z, EntityPlayer player, Block aim) {
        List<BlockPos> blocks = new ArrayList<BlockPos>();
        List<BlockPos> done = new ArrayList<BlockPos>();
        Block block = world.getBlock(X, Y, Z);
        if (block.equals(aim) ) {//是不是指定类型方块
            blocks.add(new BlockPos(X, Y, Z, world));
            while (blocks.size() != 0) {
                int x, y, z;
                BlockPos pos = blocks.get(0);
                x = pos.x;
                y = pos.y;
                z = pos.z;
                List<BlockPos> addlist=new ArrayList<BlockPos>();
                int x1=x+1,x2=x-1,y1=y+1,y2=y-1,z1=z+1,z2=z-1;
                addlist.add(new BlockPos(x1, y, z, world));
                addlist.add(new BlockPos(x2, y, z, world));
                addlist.add(new BlockPos(x, y1,z, world));
                addlist.add(new BlockPos(x, y2, z, world));
                addlist.add(new BlockPos(x, y, z1, world));
                addlist.add(new BlockPos(x, y, z2, world));
                addlist.add(new BlockPos(x1, y1, z, world));
                addlist.add(new BlockPos(x1, y2, z, world));
                addlist.add(new BlockPos(x2, y1, z, world));
                addlist.add(new BlockPos(x2, y2, z, world));
                addlist.add(new BlockPos(x1, y, z1, world));
                addlist.add(new BlockPos(x1, y, z2, world));
                addlist.add(new BlockPos(x2, y, z1, world));
                addlist.add(new BlockPos(x2, y, z2, world));
                addlist.add(new BlockPos(x, y1, z1, world));
                addlist.add(new BlockPos(x, y1, z2, world));
                addlist.add(new BlockPos(x, y2, z1, world));
                addlist.add(new BlockPos(x, y2, z2, world));
                addlist.add(new BlockPos(x1, y1, z1, world));
                addlist.add(new BlockPos(x1, y1, z2, world));
                addlist.add(new BlockPos(x1, y2, z1, world));
                addlist.add(new BlockPos(x1, y2, z2, world));
                addlist.add(new BlockPos(x2, y1, z1, world));
                addlist.add(new BlockPos(x2, y1, z2, world));
                addlist.add(new BlockPos(x2, y2, z1, world));
                addlist.add(new BlockPos(x2, y2, z2, world));
                String name = pos.getBlockDropName();
                //添加周围方块(如果数过了就不添加了)
                for (BlockPos addpos:addlist) {
                    addPos(name, blocks, addpos, done);
                }
                done.add(blocks.get(0));//数过的添加进去
                blocks.remove(0);
            }
        }
        count=done.size();//count=连锁的方块数
        //MessageVeinBlockCount message=new MessageVeinBlockCount();
        //message.VeinBlockCount= count;
        //NetWorkLoader.instance.sendTo(message,player);//发送消息同步客户端和服务端的count数量
        return done;
    }

    private static void addPos(String name, List<BlockPos> blocks, BlockPos pos, List<BlockPos> donelist) {
        if (donelist.size() >= limit) return;//最多数多少个
        boolean isDone = false;
        Iterator it = donelist.iterator();
        while (it.hasNext()) if (it.next().equals(pos)) isDone = true;//处理过的不再添加
        it = blocks.iterator();
        while (it.hasNext()) if (it.next().equals(pos)) isDone = true;//添加过的不再添加
        if (isDone) return;
        String blockDropName=pos.getBlockDropName();
        if (blockDropName.equals(name)) {
            blocks.add(pos);
        }
    }


}
