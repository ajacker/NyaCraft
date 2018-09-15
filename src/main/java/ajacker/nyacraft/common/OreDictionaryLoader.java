package ajacker.nyacraft.common;

import ajacker.nyacraft.blocks.BlockLoader;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import java.util.ArrayList;
import java.util.List;

public class OreDictionaryLoader {
    public OreDictionaryLoader(){
        OreDictionary.registerOre("oreRedstone", Blocks.lit_redstone_ore);
        OreDictionary.registerOre("oreRedstone", new ItemStack(Blocks.lit_redstone_ore));
        OreDictionary.registerOre("oreNya",BlockLoader.nyaOre);
        OreDictionary.registerOre("blockNya",BlockLoader.nyaBlock);
    }
    public static boolean contains(String[] list, ItemStack itemStack) {
        for (String dictName : list) {
            //System.out.println(item.getDisplayName() + "-" + itemStack.getDisplayName());
            int id[]=OreDictionary.getOreIDs(itemStack);
            for (int i:id) {
                String name=OreDictionary.getOreName(i);
                if (name.equals(dictName))
                    return true;
            }
        }
        return false;
    }
}
    /*public static List<ItemStack> logWood;
    public static List<ItemStack> woodRubber;
    public static List<ItemStack> oreQuartz;
    public static List<ItemStack> oreCoal;
    public static List<ItemStack> oreEmerald;
    public static List<ItemStack> oreRedstone;
    public static List<ItemStack> oreDiamond;
    public static List<ItemStack> oreLapis;
    public static List<ItemStack> oreIron;
    public static List<ItemStack> oreGold;
    public static List<ItemStack> oreCopper;
    public static List<ItemStack> oreSilver;
    public static List<ItemStack> oreTin;
    public static List<ItemStack> oreLead;
    public static List<ItemStack> oreNickel;
    public static List<ItemStack> oreIridium;
    public static List<ItemStack> orePlatinum;
    public static List<ItemStack> oreUranium;
    public static List<ItemStack> oreAmber;
    public static List<ItemStack> oreCinnabar;
    public static List<ItemStack> oreMithril;
    public static List<ItemStack> oreInfusedAir;
    public static List<ItemStack> oreInfusedFire;
    public static List<ItemStack> oreInfusedWater;
    public static List<ItemStack> oreInfusedEarth;
    public static List<ItemStack> oreInfusedOrder;
    public static List<ItemStack> oreInfusedEntropy;
    public static List<ItemStack> oreConstraintMetal;
    public static List<ItemStack> oreImagCrystal;
    public static List<ItemStack> oreResonantCrystal;
    public static List<ItemStack> oreImagSilicon;
    public static List<ItemStack> Ores = new ArrayList<ItemStack>();
    public static List<ItemStack> Woods = new ArrayList<ItemStack>();
    private static OreDictionaryLoader instance;

    private OreDictionaryLoader() {
        logWood = OreDictionary.getOres("logWood");//木头
        woodRubber = OreDictionary.getOres("woodRubber");//橡胶树
        oreQuartz = OreDictionary.getOres("oreQuartz");//石英
        oreCoal = OreDictionary.getOres("oreCoal");//煤炭
        oreEmerald = OreDictionary.getOres("oreEmerald");//绿宝石
        oreRedstone = OreDictionary.getOres("oreRedstone");//红石
        oreDiamond = OreDictionary.getOres("oreDiamond");//钻石
        oreLapis = OreDictionary.getOres("oreLapis");//青金石
        oreIron = OreDictionary.getOres("oreIron");//铁矿
        oreGold = OreDictionary.getOres("oreGold");//金矿
        oreCopper = OreDictionary.getOres("oreCopper");//铜矿
        oreSilver = OreDictionary.getOres("oreSilver");//银矿
        oreTin = OreDictionary.getOres("oreTin");//锡矿
        oreLead = OreDictionary.getOres("oreLead");//铅矿
        oreNickel = OreDictionary.getOres("oreNickel");//镍矿
        oreIridium = OreDictionary.getOres("oreIridium");//铱矿
        orePlatinum = OreDictionary.getOres("orePlatinum");//铂矿
        oreUranium = OreDictionary.getOres("oreUranium");//铀矿
        oreAmber = OreDictionary.getOres("oreAmber");//琥珀矿
        oreCinnabar = OreDictionary.getOres("oreCinnabar");//朱砂矿
        oreMithril = OreDictionary.getOres("oreMithril");//秘银矿
        oreInfusedAir = OreDictionary.getOres("oreInfusedAir");//风蕴魔石
        oreInfusedFire = OreDictionary.getOres("oreInfusedFire");//火蕴魔石
        oreInfusedWater = OreDictionary.getOres("oreInfusedWater");//水蕴魔石
        oreInfusedEarth = OreDictionary.getOres("oreInfusedEarth");//地蕴魔石
        oreInfusedOrder = OreDictionary.getOres("oreInfusedOrder");//秩序蕴魔石
        oreInfusedEntropy = OreDictionary.getOres("oreInfusedEntropy");//混沌蕴魔石
        oreConstraintMetal = OreDictionary.getOres("oreConstraintMetal");//束能金属矿
        oreImagCrystal = OreDictionary.getOres("oreImagCrystal");//虚能水晶矿
        oreResonantCrystal = OreDictionary.getOres("oreResonantCrystal");//谐振水晶矿
        oreImagSilicon = OreDictionary.getOres("oreImagSilicon");//虚像硅矿
        Ores.addAll(oreQuartz);
        Ores.addAll(oreCoal);
        Ores.addAll(oreEmerald);
        Ores.addAll(oreRedstone);
        Ores.addAll(oreDiamond);
        Ores.addAll(oreLapis);
        Ores.addAll(oreIron);
        Ores.addAll(oreGold);
        Ores.addAll(oreCopper);
        Ores.addAll(oreSilver);
        Ores.addAll(oreTin);
        Ores.addAll(oreLead);
        Ores.addAll(oreNickel);
        Ores.addAll(oreIridium);
        Ores.addAll(orePlatinum);
        Ores.addAll(oreUranium);
        Ores.addAll(oreAmber);
        Ores.addAll(oreCinnabar);
        Ores.addAll(oreMithril);
        Ores.addAll(oreInfusedAir);
        Ores.addAll(oreInfusedFire);
        Ores.addAll(oreInfusedWater);
        Ores.addAll(oreInfusedEarth);
        Ores.addAll(oreInfusedOrder);
        Ores.addAll(oreInfusedEntropy);
        Ores.addAll(oreConstraintMetal);
        Ores.addAll(oreImagCrystal);
        Ores.addAll(oreResonantCrystal);
        Ores.addAll(oreImagSilicon);
        Woods.addAll(logWood);
        Woods.addAll(woodRubber);//橡胶树不支持..它很特别
        for (ItemStack Ore : Ores) {
            System.out.println(Ore.getDisplayName());
        }
        System.out.println("载入矿物字典完毕" + Block.getBlockById(74).getLocalizedName());
    }

    public static boolean contains(List<ItemStack> list, ItemStack itemStack) {
        for (ItemStack item : list) {
            //System.out.println(item.getDisplayName() + "-" + itemStack.getDisplayName());
            if (item.getDisplayName().equals(itemStack.getDisplayName())) return true;
        }
        return false;
    }

    public static OreDictionaryLoader getInstance() {
        if (instance == null) instance = new OreDictionaryLoader();
        return instance;
    }
}*/
