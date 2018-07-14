package ajacker.nyacraft.client;

import ajacker.nyacraft.api.EventHANDRU;
import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ServerChatEvent;

import java.util.Iterator;
import java.util.List;

public class EventLoader {
    public EventLoader() {
        MinecraftForge.EVENT_BUS.register(this);
        System.out.println("注册客户端事件");
    }

    @SubscribeEvent
    public void letsrock(ServerChatEvent event) {
        if (event.player.worldObj.isRemote) return;
        if (event.message.equals("KARBOOM")) {
            event.setCanceled(true);//截获玩家的指令并不让它显示在屏幕上,用来模拟游戏指令(Command)
            EntityPlayer player = event.player;
            EventHANDRU eventHANDRU = new EventHANDRU(player);//初始化一个事件
            MinecraftForge.EVENT_BUS.post(eventHANDRU);//发布它
            if (eventHANDRU.getResult() == Event.Result.ALLOW) {
                //这个长的让人发指的东西是获取玩家附近的生物
                List list = player.worldObj.getEntitiesWithinAABB(EntityLiving.class, AxisAlignedBB.getBoundingBox(player.posX - 30D, player.posY - 20D, player.posZ - 30D, player.posX + 30D, player.posY + 20D, player.posZ + 30D));
                //值得一提的是我这里使用的是遍历器,传统的下标遍历因为无法锁定资源可能导致ConcurrentModificationException...
                for (Iterator iterator = list.iterator(); iterator.hasNext(); ) {
                    EntityLiving entity = (EntityLiving) iterator.next();
                    if (entity.equals(player)) //别把自己也给炸了...
                    {
                        continue;
                    }
                    player.worldObj.createExplosion(player, entity.posX, entity.posY, entity.posZ, 4f, false);
                }
            }
        }
    }

    @SubscribeEvent
    public void goodbyeRenko(EventHANDRU event) {
        event.entityPlayer.addChatMessage(new ChatComponentText("爆炸吧！现充！."));//欢迎来到冥界.
        event.setResult(Event.Result.ALLOW);
    }
}
