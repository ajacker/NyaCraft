package ajacker.nyacraft.items;

import ajacker.nyacraft.creativetab.CreativeTabsLoader;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;

import static ajacker.nyacraft.NyaCraft.MODID;

public class ItemNyaSword extends ItemSword {
    public static final String ItemId = "ItemNyaSword";
    public static final Item.ToolMaterial NYAINGOT = EnumHelper.addToolMaterial("NYAINGOT",
            0, 800, 0.0F, 6.0F, 25);

    public ItemNyaSword() {
        super(NYAINGOT);
        this.setCreativeTab(CreativeTabsLoader.tabFMLTutor);//创造模式标签页
        this.setUnlocalizedName(MODID + "." + ItemId);//设置名字(item.nyacraft.ItemNyaSword.name)
    }

    public void init() {
        GameRegistry.registerItem(this, ItemId);//注册物品
    }

}
