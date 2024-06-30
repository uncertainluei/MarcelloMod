package io.github.luisrandomness.marcellomod.item;

import io.github.luisrandomness.marcellomod.init.MM_MobEffects;
import io.github.luisrandomness.marcellomod.init.MM_SoundEvents;
import io.github.luisrandomness.marcellomod.init.MM_Tags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemCooldowns;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class BlockButtonItem extends Item {

    public BlockButtonItem(Properties settings) {
        super(settings);
    }

    @Override
    public @NotNull InteractionResult interactLivingEntity(ItemStack stack, Player player, LivingEntity interactionTarget, InteractionHand usedHand) {
        ItemCooldowns cooldown = player.getCooldowns();
        Level world = player.level();
        if (world.isClientSide() || cooldown.isOnCooldown(this))
            return super.interactLivingEntity(stack, player, interactionTarget, usedHand);

        player.swing(usedHand, true);
        cooldown.addCooldown(this, 30);

        EntityType<?> type = interactionTarget.getType();

        world.playSound(null, player.getX(),player.getY(),player.getZ(), MM_SoundEvents.ITEM_BLOCK_BUTTON_PRESS, SoundSource.NEUTRAL, 0.8F,1F);
        if (interactionTarget.hasEffect(MM_MobEffects.BLOCKED)) {
            interactionTarget.removeEffect(MM_MobEffects.BLOCKED);
        } else {
            if (type.is(MM_Tags.ENTITY_BLOCK_BUTTON_IMMUNE)) {
                world.playSound(null, player.getX(),player.getY(),player.getZ(), MM_SoundEvents.ITEM_BLOCK_BUTTON_FAILURE, SoundSource.NEUTRAL, 0.8F,1F);
                return InteractionResult.FAIL;
            }
            interactionTarget.addEffect(new MobEffectInstance(MM_MobEffects.BLOCKED, interactionTarget instanceof Player ? 200 : 400));
            world.playSound(null, player.getX(),player.getY(),player.getZ(), MM_SoundEvents.ITEM_BLOCK_BUTTON_BLOCK, SoundSource.NEUTRAL, 0.65F,1F);
        }

        stack.hurtAndBreak(1, player, usedHand == InteractionHand.MAIN_HAND ? EquipmentSlot.MAINHAND : EquipmentSlot.OFFHAND);
        return InteractionResult.PASS;
    }
}
