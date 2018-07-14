package ajacker.nyacraft.enchantment;

import ajacker.nyacraft.common.ConfigLoader;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;

public class EnchantmentVeinPick extends Enchantment {
    protected EnchantmentVeinPick() {
        super(ConfigLoader.enchantmentVeinPick, 1, EnumEnchantmentType.digger);//id,权重,类型
        this.setName("veinPick");
    }

    @Override
    public int getMinEnchantability(int enchantmentLevel) {
        return 15 + 5 * enchantmentLevel;
    }

    @Override
    public int getMaxEnchantability(int enchantmentLevel) {
        return super.getMaxEnchantability(enchantmentLevel) + 50;
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    public boolean canApplyTogether(Enchantment ench) {
        return super.canApplyTogether(ench)/* && ench.effectId != silkTouch.effectId && ench.effectId != fortune.effectId*/;
    }

    @Override
    public boolean canApply(ItemStack stack) {
        if (stack.getItem() instanceof ItemPickaxe || stack.getItem() instanceof ItemAxe)
            return true;
        return false;
    }
}
