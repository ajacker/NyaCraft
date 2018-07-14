package ajacker.nyacraft.common;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.config.Configuration;
import org.apache.logging.log4j.Logger;


public class ConfigLoader {
    private static Configuration config;
    private static Logger logger;

    public static String Title;
    public static int enchantmentVeinPick;//附魔,连续采集的附魔id

    public ConfigLoader(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        config = new Configuration(event.getSuggestedConfigurationFile());
        config.load();
        load();
        System.out.println("载入配置文件");
    }

    public static void load() {
        logger.info("开始读取配置文件. ");
        String comment;

        comment = "设置游戏标题(Unicode). ";
        Title = config.get(Configuration.CATEGORY_GENERAL, "Title", "\\u004d\\u0069\\u006e\\u0065\\u0063\\u0072\\u0061\\u0066\\u0074\\u0020\\u0031\\u002e\\u0037\\u002e\\u0031\\u0030", comment).getString();

        comment = "设置附魔(连续采集)的附魔id<如果冲突会导致游戏崩溃>. ";
        enchantmentVeinPick = config.get(Configuration.CATEGORY_GENERAL, "enchantmentVeinPick", 77, comment).getInt();

        config.save();
        logger.info("载入配置完毕. ");
    }

    public static Logger logger() {
        return logger;
    }
}
