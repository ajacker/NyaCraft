package ajacker.nyacraft.items;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class ItemLoader {
    public static ItemNyaIngot nyaIngot = new ItemNyaIngot();
    public static ItemNyaPickaxe nyaPickaxe = new ItemNyaPickaxe();
    public static ItemNyaSword nyaSword = new ItemNyaSword();
    public static ItemNyaShovel nyaShovel = new ItemNyaShovel();
    public static ItemNyaAxe nyaAxe = new ItemNyaAxe();
    public static ItemNyaHoe nyaHoe = new ItemNyaHoe();

    public ItemLoader(FMLPreInitializationEvent event) {
        nyaIngot.init();
        nyaPickaxe.init();
        nyaSword.init();
        nyaShovel.init();
        nyaAxe.init();
        nyaHoe.init();
        System.out.println("载入物品");
    }

    public static void LoadItemRender() {
        nyaIngot.setTextureName("nyacraft:nya_ingot");//设置材质
        nyaPickaxe.setTextureName("nyacraft:nya_pickaxe");
        nyaSword.setTextureName("nyacraft:nya_sword");
        nyaShovel.setTextureName("nyacraft:nya_shovel");
        nyaAxe.setTextureName("nyacraft:nya_axe");
        nyaHoe.setTextureName("nyacraft:nya_hoe");
        System.out.println("载入物品材质");

    }

}
