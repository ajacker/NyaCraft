package ajacker.nyacraft.items;


import ajacker.nyacraft.creativetab.CreativeTabsLoader;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraftforge.common.util.EnumHelper;

import static ajacker.nyacraft.NyaCraft.MODID;

public class ItemNyaPickaxe extends ItemPickaxe {
    public static final String ItemId = "ItemNyaPickaxe";
    public static final Item.ToolMaterial NYAINGOT = EnumHelper.addToolMaterial("NYAINGOT",
            3, 800, 24.0F, 0.0F, 16);

    public ItemNyaPickaxe() {
        super(NYAINGOT);
        this.setCreativeTab(CreativeTabsLoader.tabFMLTutor);//创造模式标签页
        this.setUnlocalizedName(MODID + "." + ItemId);//设置名字(item.nyacraft.ItemNyaPickaxe.name)


    }

    public void init() {
        GameRegistry.registerItem(this, ItemId);//注册物品
    }
}
