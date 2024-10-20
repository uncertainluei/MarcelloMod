package io.github.luisrandomness.marcellomod.mixin;

import io.github.luisrandomness.marcellomod.item.RuisiumBowItem;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ProjectileWeaponItem;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
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
}
