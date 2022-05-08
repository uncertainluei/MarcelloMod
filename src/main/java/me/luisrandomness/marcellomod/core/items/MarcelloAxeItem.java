package me.luisrandomness.marcellomod.core.items;

import me.luisrandomness.marcellomod.core.blocks.MarcelloTypeBlock;
import net.minecraft.block.BlockState;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.AxeItem;

public class MarcelloAxeItem extends AxeItem {
    public MarcelloAxeItem(IItemTier tier, float attackDamage, float attackSpeed, Properties properties) {
        super(tier, attackDamage, attackSpeed, properties);
    }

    @Override
    public float getDestroySpeed(ItemStack p_150893_1_, BlockState p_150893_2_) {
        float multiplier = p_150893_2_.getBlock() instanceof MarcelloTypeBlock ? 3F : 1F;
        return super.getDestroySpeed(p_150893_1_, p_150893_2_) * multiplier;
    }
}
