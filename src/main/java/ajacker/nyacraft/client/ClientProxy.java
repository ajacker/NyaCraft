package ajacker.nyacraft.client;

import ajacker.nyacraft.blocks.BlockLoader;
import ajacker.nyacraft.common.CommonProxy;
import ajacker.nyacraft.common.ConfigLoader;
import ajacker.nyacraft.items.ItemLoader;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import org.lwjgl.opengl.Display;

public class ClientProxy extends CommonProxy {
    @Override
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);
        Display.setTitle(unicode2String(ConfigLoader.Title));//设置游戏标题
        BlockLoader.LoadBlockRender();//加载方块纹理
        ItemLoader.LoadItemRender();//加载物品纹理
    }

    public static String unicode2String(String unicode) {
        StringBuffer string = new StringBuffer();
        String[] hex = unicode.split("\\\\u");
        for (int i = 1; i < hex.length; i++) {
            // 转换出每一个代码点
            int data = Integer.parseInt(hex[i], 16);
            // 追加成string
            string.append((char) data);
        }
        return string.toString();
    }

    @Override
    public void init(FMLInitializationEvent event) {
        super.init(event);
        new EventLoader();//加载客户端事件
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {
        super.postInit(event);
    }
}