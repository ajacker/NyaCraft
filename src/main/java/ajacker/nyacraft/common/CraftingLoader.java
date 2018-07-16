package ajacker.nyacraft.common;

import ajacker.nyacraft.blocks.BlockLoader;
import ajacker.nyacraft.items.ItemLoader;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class CraftingLoader {
    public CraftingLoader() {
        registerRecipe();
        registerSmelting();
        registerFuel();
    }

    private static void registerRecipe() {
        GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.nyaPickaxe, 1),
                "###",
                " * ",
                " * ",
                '#', ItemLoader.nyaIngot, '*', Items.stick);//彩虹稿的合成方式
        GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.nyaSword, 1),
                " # ",
                " # ",
                " * ",
                '#', ItemLoader.nyaIngot, '*', Items.stick);//彩虹剑的合成方式
        GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.nyaSword, 1),
                "#  ",
                "#  ",
                "*  ",
                '#', ItemLoader.nyaIngot, '*', Items.stick);//彩虹剑的合成方式
        GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.nyaSword, 1),
                "  #",
                "  #",
                "  *",
                '#', ItemLoader.nyaIngot, '*', Items.stick);//彩虹剑的合成方式
        GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.nyaShovel, 1),
                " # ",
                " * ",
                " * ",
                '#', ItemLoader.nyaIngot, '*', Items.stick);//彩虹铲的合成方式
        GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.nyaShovel, 1),
                "#  ",
                "*  ",
                "*  ",
                '#', ItemLoader.nyaIngot, '*', Items.stick);//彩虹铲的合成方式
        GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.nyaShovel, 1),
                "  #",
                "  *",
                "  *",
                '#', ItemLoader.nyaIngot, '*', Items.stick);//彩虹铲的合成方式
        GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.nyaAxe, 1),
                "## ",
                "#* ",
                " * ",
                '#', ItemLoader.nyaIngot, '*', Items.stick);//彩虹斧的合成方式
        GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.nyaAxe, 1),
                " ##",
                " *#",
                " * ",
                '#', ItemLoader.nyaIngot, '*', Items.stick);//彩虹斧的合成方式
        GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.nyaHoe, 1),
                "## ",
                        " * ",
                        " * ",
                '#', ItemLoader.nyaIngot, '*', Items.stick);//彩虹锄的合成方式
        GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.nyaHoe, 1),
                " ##",
                        " * ",
                        " * ",
                '#', ItemLoader.nyaIngot, '*', Items.stick);//彩虹锄的合成方式
        GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.nyaHelmet, 1),
                "###",
                        "# #",
                        "   ",
                '#', ItemLoader.nyaIngot);//彩虹头盔的合成方式
        GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.nyaHelmet, 1),
                "   ",
                        "###",
                        "# #",
                '#', ItemLoader.nyaIngot);//彩虹头盔的合成方式
        GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.nyaChestplate, 1),
                "# #",
                        "###",
                        "###",
                '#', ItemLoader.nyaIngot);//彩虹胸甲的合成方式
        GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.nyaLeggings, 1),
                "###",
                        "# #",
                        "# #",
                '#', ItemLoader.nyaIngot);//彩虹护腿的合成方式
        GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.nyaBoots, 1),
                "   ",
                        "# #",
                        "# #",
                '#', ItemLoader.nyaIngot);//彩虹靴子的合成方式
        GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.nyaBoots, 1),
                "# #",
                        "# #",
                        "   ",
                '#', ItemLoader.nyaIngot);//彩虹靴子的合成方式
        GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.nyaBlock, 1),
                "###",
                "###",
                "###",
                '#', ItemLoader.nyaIngot);//彩虹块的合成方式
        System.out.println("载入合成配方");
    }

    private static void registerSmelting() {
        GameRegistry.addSmelting(BlockLoader.nyaOre, new ItemStack(ItemLoader.nyaIngot), 1f);//彩虹矿->彩虹锭
        System.out.println("载入冶炼配方");
    }

    private static void registerFuel() {
        System.out.println("载入燃料");
    }
}
