package io.github.luisrandomness.marcellomod.item;

import io.github.luisrandomness.marcellomod.init.MM_Tags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.block.state.BlockState;

import io.github.luisrandomness.marcellomod.init.MM_Tags;

public class MarcelloAxeItem extends AxeItem {
    public MarcelloAxeItem(Tier material, int attackDamage, float attackSpeed, Properties settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        float speed = super.getDestroySpeed(stack,state);
        return speed * (state.is(MM_Tags.BLOCK_MARCELLO_EFFICIENT) && speed >= this.speed ? 3F : 1F);
    }
}
