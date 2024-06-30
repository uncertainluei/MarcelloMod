package io.github.luisrandomness.marcellomod.item;

import io.github.luisrandomness.marcellomod.init.MM_Tags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.Tool;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class MarcelloShovelItem extends ShovelItem implements MarcelloEffectiveWeapon {

    public MarcelloShovelItem(Tier tier, Properties properties) {
        super(tier, properties);
    }

    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        Tool tool = stack.get(DataComponents.TOOL);
        float speed = super.getDestroySpeed(stack,state);

        return speed * (tool != null && speed > tool.defaultMiningSpeed() && state.is(MM_Tags.BLOCK_MARCELLO_EFFICIENT) ? 3F : 1F);
    }

    @Override
    public boolean mineBlock(ItemStack stack, Level level, BlockState state, BlockPos pos, LivingEntity miningEntity) {
        if (!level.isClientSide && state.getDestroySpeed(level, pos) != 0.0F && !state.is(MM_Tags.BLOCK_MARCELLO_EFFICIENT)) {
            stack.hurtAndBreak(1, miningEntity, EquipmentSlot.MAINHAND);
        }
        return super.mineBlock(stack, level, state, pos, miningEntity);
    }

    @Override
    public float getMarcelloDamageBonus() {
        return 2F;
    }
}
