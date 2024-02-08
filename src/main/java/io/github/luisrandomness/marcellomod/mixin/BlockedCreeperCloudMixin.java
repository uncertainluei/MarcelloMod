package io.github.luisrandomness.marcellomod.mixin;

import io.github.luisrandomness.marcellomod.init.MM_MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Creeper.class)
public abstract class BlockedCreeperCloudMixin extends Monster {
	protected BlockedCreeperCloudMixin(EntityType<? extends Monster> entityType, Level world) {
		super(entityType, world);
	}

	@Inject(at = @At("HEAD"), method = "spawnLingeringCloud")
	private void init(CallbackInfo ci) {
		LivingEntity living = (LivingEntity)this;

		// Remove block effect from creeper before exploding
		if (living.hasEffect(MM_MobEffects.BLOCKED))
			living.removeEffect(MM_MobEffects.BLOCKED);
	}
}