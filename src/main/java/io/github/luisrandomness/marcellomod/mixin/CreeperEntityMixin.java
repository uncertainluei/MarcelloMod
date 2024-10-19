package io.github.luisrandomness.marcellomod.mixin;

import io.github.luisrandomness.marcellomod.init.MM_MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Creeper.class)
public abstract class CreeperEntityMixin extends Monster {
	private CreeperEntityMixin(EntityType<? extends Monster> entityType, Level world) {
		super(entityType, world);
	}

	@Shadow
	private int explosionRadius;

	@Inject(at = @At("HEAD"), method = "spawnLingeringCloud")
	private void marcellomod$onCloudSpawn(CallbackInfo ci) {
		LivingEntity living = this;

		// Remove block effect from creeper before exploding
		if (living.hasEffect(MM_MobEffects.BLOCKED))
			living.removeEffect(MM_MobEffects.BLOCKED);
	}

	@Inject(at = @At("HEAD"), method = "explodeCreeper")
	private void marcellmod$onCreeperExplode(CallbackInfo ci)
	{
		if (!this.level().isClientSide && this.hasEffect(MM_MobEffects.BLOCKED)) {
			explosionRadius = 0;
		}
	}
}