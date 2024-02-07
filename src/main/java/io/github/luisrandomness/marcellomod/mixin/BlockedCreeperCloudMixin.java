package io.github.luisrandomness.marcellomod.mixin;

import io.github.luisrandomness.marcellomod.init.MM_StatusEffects;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(CreeperEntity.class)
public abstract class BlockedCreeperCloudMixin extends HostileEntity {
	protected BlockedCreeperCloudMixin(EntityType<? extends HostileEntity> entityType, World world) {
		super(entityType, world);
	}

	@Inject(at = @At("HEAD"), method = "spawnEffectsCloud()V")
	private void init(CallbackInfo ci) {
		LivingEntity living = (LivingEntity)this;

		// Remove block effect from creeper before exploding
		if (living.hasStatusEffect(MM_StatusEffects.BLOCKED))
			living.removeStatusEffect(MM_StatusEffects.BLOCKED);
	}
}