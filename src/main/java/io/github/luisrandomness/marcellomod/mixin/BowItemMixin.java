package io.github.luisrandomness.marcellomod.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import com.mojang.authlib.minecraft.client.MinecraftClient;
import io.github.luisrandomness.marcellomod.item.JumperiteBowItem;
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

@Mixin(BowItem.class)
public abstract class BowItemMixin extends ProjectileWeaponItem {
    private static boolean begun = false;
    private BowItemMixin(Properties properties) {
        super(properties);
    }

    @Inject(method = "releaseUsing", at = @At("HEAD"))
    private void marcellomod$resetModificationBool(ItemStack stack, Level level, LivingEntity livingEntity, int timeCharged, CallbackInfo ci)
    {
        begun = false;
    }

    @ModifyVariable(method = "releaseUsing", at = @At("STORE"), name = "f")
    private float marcellomod$getJumperiteBowPower(float original, @Local(name = "i") int i) {
        if (begun) return original;
        begun = true;

        return ((ProjectileWeaponItem)this instanceof JumperiteBowItem) ? JumperiteBowItem.getPowerForTime(i) : original;
    }

    // TODO :: Write 1.21 equivalent
//    @Inject(method = "releaseUsing", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/BowItem;shoot(Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/world/entity/LivingEntity;Lnet/minecraft/world/InteractionHand;Lnet/minecraft/world/item/ItemStack;Ljava/util/List;FFZLnet/minecraft/world/entity/LivingEntity;)V", shift = At.Shift.BEFORE, ordinal = 0))
//    private void marcellomod$handleArrowCrit(ItemStack stack, Level level, LivingEntity livingEntity, int timeCharged, CallbackInfo ci, @Local(name = "f") float power, @Local(name = "abstractArrow")AbstractArrow arrow) {
//        if (power >= 1F)
//            arrow.setCritArrow(!((ProjectileWeaponItem)this instanceof JumperiteBowItem) || power >= 1.5F);
//    }
}
