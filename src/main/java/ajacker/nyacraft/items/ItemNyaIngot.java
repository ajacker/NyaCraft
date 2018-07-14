package ajacker.nyacraft.items;

import ajacker.nyacraft.creativetab.CreativeTabsLoader;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

import static ajacker.nyacraft.NyaCraft.MODID;

public class ItemNyaIngot extends Item {
    public static final String ItemId = "ItemNyaIngot";

    public ItemNyaIngot() {
        this.setCreativeTab(CreativeTabsLoader.tabFMLTutor);//创造模式标签页
        this.setUnlocalizedName(MODID + "." + ItemId);//设置名字(item.nyacraft.ItemNyaIngot.name)
    }

    public void init() {
        GameRegistry.registerItem(this, ItemId);//注册物品
    }
}
