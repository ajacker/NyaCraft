package ajacker.nyacraft.blocks;

import ajacker.nyacraft.creativetab.CreativeTabsLoader;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;

import static ajacker.nyacraft.NyaCraft.MODID;

public class BlockNyaOre extends Block {
    public static final String BlockId = "BlockNyaOre";

    public BlockNyaOre(Material material) {
        super(material);
        this.setCreativeTab(CreativeTabsLoader.tabFMLTutor);//创造模式标签页
        this.setBlockName(MODID + "." + BlockId);//设置名字(tile.nyacraft.BlockNyaOre.name)
        this.setLightLevel(1.0f);//设置光亮度最大
        this.setHarvestLevel("pickaxe", 2);//开采等级：铁镐
        this.setHardness(2.5f);//硬度:石头1.5，矿石3.0

    }

    public void init() {
        GameRegistry.registerBlock(this, BlockId);//注册方块
    }
    @Override
    public int onBlockPlaced(World world, int x, int y, int z, int p_149660_5_, float p_149660_6_, float p_149660_7_, float p_149660_8_, int p_149660_9_) {
        world.playSound(x,y,z,"nyacraft:nyacraft.nya",1,1,false);
        return super.onBlockPlaced(world, x, y, z, p_149660_5_, p_149660_6_, p_149660_7_, p_149660_8_, p_149660_9_);
    }

    @Override
    public void onBlockDestroyedByPlayer(World world, int x, int y, int z, int p_149664_5_) {
        world.playSound(x,y,z,"nyacraft:nyacraft.nya",1,1,false);
        super.onBlockDestroyedByPlayer(world, x, y, z, p_149664_5_);
    }
}
