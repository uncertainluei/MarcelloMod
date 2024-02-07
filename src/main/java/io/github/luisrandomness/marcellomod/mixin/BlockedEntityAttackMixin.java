package io.github.luisrandomness.marcellomod.mixin;

import io.github.luisrandomness.marcellomod.init.MM_StatusEffects;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public class BlockedEntityAttackMixin {
	@Inject(at = @At("HEAD"), method = "isInvulnerableTo(Lnet/minecraft/entity/damage/DamageSource;)Z", cancellable = true)
	private void init(DamageSource damageSource, CallbackInfoReturnable<Boolean> cir) {
		Entity attacker = damageSource.getAttacker();
		if (!(attacker instanceof LivingEntity))
			return;

		// If the attacker is blocked, return invulnerability flag as true.
		if (((LivingEntity) attacker).hasStatusEffect(MM_StatusEffects.BLOCKED))
			cir.setReturnValue(true);
	}
}