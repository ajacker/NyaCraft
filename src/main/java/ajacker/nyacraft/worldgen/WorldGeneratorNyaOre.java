package ajacker.nyacraft.worldgen;

import ajacker.nyacraft.blocks.BlockLoader;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.event.terraingen.OreGenEvent;
import net.minecraftforge.event.terraingen.TerrainGen;

import java.util.Random;

public class WorldGeneratorNyaOre extends WorldGenerator {
    private final WorldGenerator nyaoreGenerator = new WorldGenMinable(BlockLoader.nyaOre, 1);//1-2的随机整数

    @Override
    public boolean generate(World world, Random rand, int x, int y, int z) {
        if (TerrainGen.generateOre(world, rand, this, x, z, OreGenEvent.GenerateMinable.EventType.CUSTOM)) {
            for (int i = 0; i < 4; ++i) {
                int posX = x + rand.nextInt(16);
                int posY = 4+ rand.nextInt(20);
                int posZ = z + rand.nextInt(16);
                System.out.println("生成矿物"+posX+","+posY+","+posZ);
                BiomeGenBase biomeGenBase = world.getBiomeGenForCoords(posX, posZ);
                if (biomeGenBase.getIntRainfall() < rand.nextInt(65536)) {
                    nyaoreGenerator.generate(world, rand, posX, posY, posZ);
                }
            }
        }
        return true;
    }
}
