package ajacker.nyacraft.items;

import ajacker.nyacraft.creativetab.CreativeTabsLoader;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemHoe;
import net.minecraftforge.common.util.EnumHelper;

import static ajacker.nyacraft.NyaCraft.MODID;

public class ItemNyaHoe extends ItemHoe {
    public static final String ItemId = "ItemNyaHoe";
    public static final Item.ToolMaterial NYAINGOT = EnumHelper.addToolMaterial("NYAINGOT",
            1, 800, 20.0F, 0.0F, 25);
    public ItemNyaHoe() {
        super(NYAINGOT);
        this.setCreativeTab(CreativeTabsLoader.tabFMLTutor);//创造模式标签页
        this.setUnlocalizedName(MODID + "." + ItemId);//设置名字(item.nyacraft.ItemNyaHoe.name)
    }
    public void init() {
        GameRegistry.registerItem(this, ItemId);//注册物品
    }
}
