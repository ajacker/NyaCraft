package ajacker.nyacraft.network;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

import static ajacker.nyacraft.NyaCraft.MODID;

public class NetWorkLoader extends SimpleNetworkWrapper {
    public static SimpleNetworkWrapper instance = NetworkRegistry.INSTANCE.newSimpleChannel(MODID);
    private static int nextID = 0;
    public NetWorkLoader(FMLPreInitializationEvent event) {
        super(MODID);
        registerMessage(MessageVeinBlockCount.Handler.class,MessageVeinBlockCount.class,nextID++,Side.CLIENT);
    }
    private static <REQ extends IMessage, REPLY extends IMessage> void registerMessage(
            Class<? extends IMessageHandler<REQ, REPLY>> messageHandler, Class<REQ> requestMessageType, Side side)
    {
        instance.registerMessage(messageHandler, requestMessageType, nextID++, side);
    }
}
