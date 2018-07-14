package ajacker.nyacraft.enchantment;

import ajacker.nyacraft.common.ConfigLoader;
import net.minecraft.enchantment.Enchantment;

public class EnchantmentLoader {
    public static EnchantmentVeinPick veinPick;

    public EnchantmentLoader() {
        try {
            veinPick = new EnchantmentVeinPick();
            Enchantment.addToBookList(veinPick);
        } catch (Exception e) {
            ConfigLoader.logger().error(
                    "重复或非法的附魔Id: {}, 附魔: '{}' 的注册将会被跳过. ",
                    ConfigLoader.enchantmentVeinPick, EnchantmentVeinPick.class.getName());
        }
    }
}
