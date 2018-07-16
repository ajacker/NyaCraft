package ajacker.nyacraft.client;

import ajacker.nyacraft.api.EventHANDRU;
import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.Vec3;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

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

    @SubscribeEvent
    public void onEntityAttacked(LivingAttackEvent event) {
        if(!event.entity.worldObj.isRemote) return;//服务器不添加特效
        Entity attacking = event.source.getSourceOfDamage(); //attacking为攻击者
        if (attacking == null || !attacking.worldObj.isRemote) //对于攻击者不是实体,或者该世界不为客户端世界的情况,直接返回
            return;
        EntityLivingBase attacked = event.entityLiving; //attacked为受害者
        for (int i = 0; i < 150; i++) {
            Minecraft.getMinecraft().effectRenderer.addEffect( // 添加一个待会制作的EntityBlood实体,它的参数是游戏世界,3个double表示的粒子位置,以及1个Vec3表示的方向矢量
                    new EntityNyaFX(attacked.worldObj, attacked.posX, attacked.posY + attacked.getEyeHeight(), attacked.posZ, Vec3.createVectorHelper(attacking.posX - attacked.posX, //根据攻击者和被攻击者的位置计算出血喷出的方向
                            attacking.posY - attacked.posY - attacked.getEyeHeight(), attacking.posZ - attacked.posZ).normalize())); //方向矢量最好是单位长度,因此做一次规格化
        }
    }
}
