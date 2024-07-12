package io.github.luisrandomness.marcellomod.core.items;

import io.github.luisrandomness.marcellomod.core.blocks.MarcelloTypeBlock;
import net.minecraft.block.BlockState;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;

public class MarcelloPickaxeItem extends PickaxeItem {
    public MarcelloPickaxeItem(IItemTier tier, int attackDamage, float attackSpeed, Properties properties) {
        super(tier, attackDamage, attackSpeed, properties);
    }

    @Override
    public float getDestroySpeed(ItemStack p_150893_1_, BlockState p_150893_2_) {
        float multiplier = p_150893_2_.getBlock() instanceof MarcelloTypeBlock ? 3F : 1F;
        return super.getDestroySpeed(p_150893_1_, p_150893_2_) * multiplier;
    }
}
