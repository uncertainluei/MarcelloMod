package me.luisrandomness.marcellomod.core.blocks;

import me.luisrandomness.marcellomod.core.registry.MarcelloModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.OreBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;

import java.util.Random;

public class MarcelloModOreBlock extends OreBlock {
    public MarcelloModOreBlock(Properties p_i48357_1_) {
        super(p_i48357_1_);
    }

    protected int xpOnDrop(Random rand) {
        if (MarcelloModBlocks.JUMPERITE_ORE.get().equals(this)) {
            return MathHelper.nextInt(rand, 4, 7);
        }
        return this == MarcelloModBlocks.NETHER_MARCELLO_ORE.get() || this == MarcelloModBlocks.MARCELLO_ORE.get() ? MathHelper.nextInt(rand, 0, 3) : 0;
    }

    @Override
    public int getExpDrop(BlockState state, net.minecraft.world.IWorldReader reader, BlockPos pos, int fortune, int silktouch) {
        return silktouch == 0 ? this.xpOnDrop(RANDOM) : 0;
    }
}
