package ajacker.nyacraft.common;

import ajacker.nyacraft.blocks.BlockLoader;
import ajacker.nyacraft.creativetab.CreativeTabsLoader;
import ajacker.nyacraft.enchantment.EnchantmentLoader;
import ajacker.nyacraft.items.ItemLoader;
import ajacker.nyacraft.worldgen.WorldGeneratorLoader;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {
    public void preInit(FMLPreInitializationEvent event) {
        new ConfigLoader(event);//读取配置文件
        new CreativeTabsLoader(event);//载入创造模式栏
        new BlockLoader(event);//载入方块
        new ItemLoader(event);//载入物品
        new WorldGeneratorLoader();//生成矿物
    }

    public void init(FMLInitializationEvent event) {
        new CraftingLoader();//载入合成表，冶炼，燃料
        new EnchantmentLoader();//载入附魔
        new EventLoader();//注册事件
    }

    public void postInit(FMLPostInitializationEvent event) {
    }
}
