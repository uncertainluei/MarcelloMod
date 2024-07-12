package io.github.luisrandomness.marcellomod.core.blocks;

import io.github.luisrandomness.marcellomod.core.registry.MM_Blocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.OreBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;

import java.util.Random;

public class MM_OreBlock extends OreBlock {
    public MM_OreBlock(Properties p_i48357_1_) {
        super(p_i48357_1_);
    }

    protected int xpOnDrop(Random rand) {
        if (MM_Blocks.RUISIUM_ORE.get().equals(this)) {
            return MathHelper.nextInt(rand, 4, 7);
        }
        return this == MM_Blocks.NETHER_MARCELLO_ORE.get() || this == MM_Blocks.MARCELLO_ORE.get() ? MathHelper.nextInt(rand, 0, 3) : 0;
    }

    @Override
    public int getExpDrop(BlockState state, net.minecraft.world.IWorldReader reader, BlockPos pos, int fortune, int silktouch) {
        return silktouch == 0 ? this.xpOnDrop(RANDOM) : 0;
    }
}
