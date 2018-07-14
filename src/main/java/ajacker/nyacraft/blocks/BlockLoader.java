package ajacker.nyacraft.blocks;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.block.material.Material;

public class BlockLoader {
    public static BlockNyaOre nyaOre = new BlockNyaOre(Material.rock);
    public static BlockNyaBlock nyaBlock = new BlockNyaBlock(Material.rock);

    public BlockLoader(FMLPreInitializationEvent event) {
        nyaOre.init();
        nyaBlock.init();
        System.out.println("载入方块");
    }

    public static void LoadBlockRender() {
        nyaOre.setBlockTextureName("nyacraft:nya_ore");//设置材质
        nyaBlock.setBlockTextureName("nyacraft:nya_block_high");
        System.out.println("载入方块材质");
    }
}
