package io.github.luisrandomness.marcellomod.item;

import io.github.luisrandomness.marcellomod.init.MM_Tags;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MarcelloHoeItem extends HoeItem implements MarcelloEffectiveWeapon {
    public MarcelloHoeItem(Tier material, int attackDamage, float attackSpeed, Item.Properties settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        float speed = super.getDestroySpeed(stack,state);
        return speed * (state.is(MM_Tags.BLOCK_MARCELLO_EFFICIENT) && speed >= this.speed ? 3F : 1F);
    }

    @Override
    public float getMarcelloDamageBonus() {
        return 3F;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltipComponents, TooltipFlag isAdvanced) {
        super.appendHoverText(stack, level, tooltipComponents, isAdvanced);
    }
}
