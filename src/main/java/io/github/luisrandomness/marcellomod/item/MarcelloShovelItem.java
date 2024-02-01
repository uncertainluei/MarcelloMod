package io.github.luisrandomness.marcellomod.item;

import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ToolMaterial;

import io.github.luisrandomness.marcellomod.init.MM_Tags;

public class MarcelloShovelItem extends ShovelItem {
    public MarcelloShovelItem(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public float getMiningSpeedMultiplier(ItemStack stack, BlockState state) {
        float speed = super.getMiningSpeedMultiplier(stack,state);
        return speed * (state.isIn(MM_Tags.BLOCK_MARCELLO_EFFICIENT) && speed >= miningSpeed ? 3F : 1F);
    }
}
