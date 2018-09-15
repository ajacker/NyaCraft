package ajacker.nyacraft;

import ajacker.nyacraft.common.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = NyaCraft.MODID, version = NyaCraft.VERSION)
public class NyaCraft {
    @SidedProxy(clientSide = "ajacker.nyacraft.client.ClientProxy",
            serverSide = "ajacker.nyacraft.common.CommonProxy")
    public static CommonProxy proxy;
    public static final String MODID = "nyacraft";
    public static final String VERSION = "1.1";

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }
}
