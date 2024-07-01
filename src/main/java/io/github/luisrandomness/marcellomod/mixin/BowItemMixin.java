package io.github.luisrandomness.marcellomod.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import io.github.luisrandomness.marcellomod.item.JumperiteBowItem;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ProjectileWeaponItem;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BowItem.class)
public abstract class BowItemMixin extends ProjectileWeaponItem {
    private static boolean processJumperiteLogic = false;
    private BowItemMixin(Properties properties) {
        super(properties);
    }

    @Inject(method = "releaseUsing", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/BowItem;getPowerForTime(I)F", shift = At.Shift.BEFORE))
    private void marcellomod$overridePowerLogicPre(ItemStack stack, Level level, LivingEntity livingEntity, int timeCharged, CallbackInfo ci)
    {
        processJumperiteLogic = stack.getItem() instanceof JumperiteBowItem;
    }

    @Inject(method = "getPowerForTime", at = @At("HEAD"), cancellable = true)
    private static void marcellomod$overrideGetPowerForTime(int charge, CallbackInfoReturnable<Float> cir) {
        if (processJumperiteLogic)
        {
            processJumperiteLogic = false;
            cir.setReturnValue(JumperiteBowItem.getPowerForTime(charge));
        }
    }
}
