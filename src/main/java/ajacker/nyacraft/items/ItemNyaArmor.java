package ajacker.nyacraft.items;

import ajacker.nyacraft.creativetab.CreativeTabsLoader;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;

import static ajacker.nyacraft.NyaCraft.MODID;

public class ItemNyaArmor extends ItemArmor {
    public static final ItemArmor.ArmorMaterial NYAINGOT =
            EnumHelper.addArmorMaterial("nya",60,new int[]{3,10,5,2},30);//金甲25
    public ItemNyaArmor(int type) {
        super(NYAINGOT, 4, type);
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {//返回材质路径
        String s1=String.format("nyacraft:textures/models/armor/%s_layer_%d%s.png",
                "nya", (slot == 2 ? 2 : 1), type == null ? "" : String.format("_%s", type));
        return s1;
    }

    public static class Helmet extends ItemNyaArmor
    {
        public static final String ItemId="ItemNyaHelmet";
        public Helmet()
        {
            super(0);
            this.setUnlocalizedName(MODID+"."+ItemId);
            this.setCreativeTab(CreativeTabsLoader.tabFMLTutor);
        }
        public void init() {
            GameRegistry.registerItem(this, ItemId);//注册物品
        }
    }

    public static class Chestplate extends ItemNyaArmor
    {
        public static final String ItemId="ItemNyaChestplate";
        public Chestplate()
        {
            super(1);
            this.setUnlocalizedName(MODID+"."+ItemId);
            this.setCreativeTab(CreativeTabsLoader.tabFMLTutor);
        }
        public void init() {
            GameRegistry.registerItem(this, ItemId);//注册物品
        }
    }

    public static class Leggings extends ItemNyaArmor
    {
        public static final String ItemId="ItemNyaLeggings";
        public Leggings()
        {
            super(2);
            this.setUnlocalizedName(MODID+"."+ItemId);
            this.setCreativeTab(CreativeTabsLoader.tabFMLTutor);
        }
        public void init() {
            GameRegistry.registerItem(this, ItemId);//注册物品
        }
    }

    public static class Boots extends ItemNyaArmor
    {
        public static final String ItemId="ItemNyaBoots";
        public Boots()
        {
            super(3);
            this.setUnlocalizedName(MODID+"."+ItemId);
            this.setCreativeTab(CreativeTabsLoader.tabFMLTutor);
        }
        public void init() {
            GameRegistry.registerItem(this, ItemId);//注册物品
        }
    }
}
