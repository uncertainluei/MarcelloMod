package io.github.luisrandomness.marcellomod.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import com.mojang.authlib.minecraft.client.MinecraftClient;
import io.github.luisrandomness.marcellomod.item.RuisiumBowItem;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ProjectileWeaponItem;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Debug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BowItem.class)
public abstract class BowItemMixin extends ProjectileWeaponItem {
    private static boolean processRuisiumLogic = false;

    private BowItemMixin(Properties properties) {
        super(properties);
    }

    @Inject(method = "releaseUsing", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/BowItem;getPowerForTime(I)F", shift = At.Shift.BEFORE))
    private void marcellomod$overridePowerLogicPre(ItemStack stack, Level level, LivingEntity livingEntity, int timeCharged, CallbackInfo ci)
    {
        processRuisiumLogic = stack.getItem() instanceof RuisiumBowItem;
    }

    @Inject(method = "getPowerForTime", at = @At("HEAD"), cancellable = true)
    private static void marcellomod$overrideGetPowerForTime(int charge, CallbackInfoReturnable<Float> cir) {
        if (processRuisiumLogic)
        {
            processRuisiumLogic = false;
            cir.setReturnValue(RuisiumBowItem.getPowerForTime(charge));
        }
    }

    @Inject(method = "releaseUsing", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/Level;addFreshEntity(Lnet/minecraft/world/entity/Entity;)Z", shift = At.Shift.BEFORE))
    private void marcellomod$setCrit(ItemStack stack, Level level, LivingEntity livingEntity, int timeCharged, CallbackInfo ci, @Local AbstractArrow abstractArrow, @Local float f)
    {
        if (stack.getItem() instanceof RuisiumBowItem)
            abstractArrow.setCritArrow(f >= 1.7F);
    }
}
