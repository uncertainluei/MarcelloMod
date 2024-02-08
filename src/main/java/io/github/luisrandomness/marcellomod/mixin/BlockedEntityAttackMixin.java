package io.github.luisrandomness.marcellomod.mixin;

import io.github.luisrandomness.marcellomod.init.MM_MobEffects;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public class BlockedEntityAttackMixin {
	@Inject(at = @At("HEAD"), method = "isInvulnerableTo", cancellable = true)
	private void init(DamageSource source, CallbackInfoReturnable<Boolean> cir) {
		Entity attacker = source.getEntity();
		if (!(attacker instanceof LivingEntity))
			return;

		// If the attacker is blocked, return invulnerability flag as true.
		if (((LivingEntity) attacker).hasEffect(MM_MobEffects.BLOCKED))
			cir.setReturnValue(true);
	}
}