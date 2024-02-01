package io.github.luisrandomness.marcellomod.item;

import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

import io.github.luisrandomness.marcellomod.init.MM_Tags;

public class MarcelloSwordItem extends SwordItem {
    public MarcelloSwordItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public float getMiningSpeedMultiplier(ItemStack stack, BlockState state) {
        float speed = super.getMiningSpeedMultiplier(stack,state);
        return speed * (state.isIn(MM_Tags.BLOCK_MARCELLO_EFFICIENT) && speed >= 1.5F ? 3F : 1F);
    }
}
