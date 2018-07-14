package ajacker.nyacraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.ArrayList;

public class BlockPos {
    public int x, y, z;
    public World world;

    public BlockPos(int x, int y, int z, World world) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.world = world;
    }

    public Block getBlock() {
        return world.getBlock(x, y, z);
    }

    public int getBlockMetadata() {
        return world.getBlockMetadata(x, y, z);
    }

    public String getBlockDropName() {
        String name = "";//当前处理方块的名字
        ArrayList<ItemStack> list = getBlock().getDrops(world, x, y, z, getBlockMetadata(), 1);
        for (ItemStack item : list) {
            name = item.getDisplayName();
        }
        return name;
    }

    public String getBlockName() {
        return getBlock().getLocalizedName();
    }

    @Override
    public boolean equals(Object object) {
        BlockPos pos = (BlockPos) object;
        if (this.x == pos.x && this.y == pos.y && this.z == pos.z) return true;
        return false;
    }
}
