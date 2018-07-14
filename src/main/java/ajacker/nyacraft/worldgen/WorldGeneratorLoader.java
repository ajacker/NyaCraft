package ajacker.nyacraft.worldgen;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.OreGenEvent;

public class WorldGeneratorLoader {
    private int x, y, z;
    private static WorldGenerator generatorNyaOre = new WorldGeneratorNyaOre();
    public WorldGeneratorLoader() {
        MinecraftForge.ORE_GEN_BUS.register(this);
    }

    @SubscribeEvent
    public void onOreGenPost(OreGenEvent.Post event) {
        if (event.worldX != this.x || event.worldZ != this.z) {
            this.x = event.worldX;
            this.z = event.worldZ;
            generatorNyaOre.generate(event.world, event.rand, event.worldX, 0, event.worldZ);
        }
    }

}