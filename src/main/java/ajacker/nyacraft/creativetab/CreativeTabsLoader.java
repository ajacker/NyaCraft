package ajacker.nyacraft.creativetab;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.creativetab.CreativeTabs;

public class CreativeTabsLoader {
    public static CreativeTabs tabFMLTutor;

    public CreativeTabsLoader(FMLPreInitializationEvent event) {
        tabFMLTutor = new CreativeTabsFMLTutor();
        //载入创造栏
    }
}