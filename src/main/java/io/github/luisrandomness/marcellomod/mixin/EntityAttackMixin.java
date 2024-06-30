package io.github.luisrandomness.marcellomod.mixin;

import io.github.luisrandomness.marcellomod.init.MM_MobEffects;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public class EntityAttackMixin {
	@Inject(at = @At("HEAD"), method = "isInvulnerableTo", cancellable = true)
	private void marcellomod$isInvincible(DamageSource source, CallbackInfoReturnable<Boolean> cir) {
		Entity attacker = source.getEntity();

		// If the attacker is a living entity and has the blocked effect, return invulnerability flag as true.
		if (attacker instanceof LivingEntity attackerLiving && attackerLiving.hasEffect(MM_MobEffects.BLOCKED))
			cir.setReturnValue(true);
	}
}