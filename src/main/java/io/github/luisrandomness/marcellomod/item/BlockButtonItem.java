package io.github.luisrandomness.marcellomod.item;

import io.github.luisrandomness.marcellomod.init.MM_SoundEvents;
import io.github.luisrandomness.marcellomod.init.MM_StatusEffects;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.ItemCooldownManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.EnderPearlItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class BlockButtonItem extends Item {

    public BlockButtonItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        ItemCooldownManager cooldownManager = user.getItemCooldownManager();
        World world = user.getWorld();
        if (world.isClient() || cooldownManager.isCoolingDown(this))
            return super.useOnEntity(stack, user, entity, hand);

        world.playSound(null, user.getX(),user.getY(),user.getZ(), MM_SoundEvents.ITEM_BLOCK_BUTTON_PRESS, SoundCategory.NEUTRAL, 0.8F,1F);
        if (entity.hasStatusEffect(MM_StatusEffects.BLOCKED)) {
            entity.removeStatusEffect(MM_StatusEffects.BLOCKED);
        } else {
            entity.addStatusEffect(new StatusEffectInstance(MM_StatusEffects.BLOCKED, 600));
            world.playSound(null, user.getX(),user.getY(),user.getZ(), MM_SoundEvents.ITEM_BLOCK_BUTTON_BLOCK, SoundCategory.NEUTRAL, 0.65F,1F);
        }

        user.swingHand(hand, true);
        cooldownManager.set(this, 30);
        stack.damage(1, user, (e) -> {
            // Mojang why isn't there a helper function to convert from hand type -> equipment slot?!?!
            e.sendEquipmentBreakStatus(hand == Hand.MAIN_HAND ? EquipmentSlot.MAINHAND : EquipmentSlot.OFFHAND);
        });
        return ActionResult.PASS;
    }
}
