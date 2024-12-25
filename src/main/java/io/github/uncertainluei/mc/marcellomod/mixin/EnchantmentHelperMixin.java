package io.github.uncertainluei.mc.marcellomod.mixin;

import io.github.uncertainluei.mc.marcellomod.init.MM_Tags;
import io.github.uncertainluei.mc.marcellomod.item.MarcelloEffectiveWeapon;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EnchantmentHelper.class)
public abstract class EnchantmentHelperMixin
{
	@Inject(at = @At("RETURN"), method = "modifyDamage", cancellable = true)
	private static void marcellomod$modifyDamage(ServerLevel level, ItemStack tool, Entity entity, DamageSource damageSource, float damage, CallbackInfoReturnable<Float> cir)
	{
		Item item = tool.getItem();

		float bonus = 0F;
		if (entity.getType().is(MM_Tags.ENTITY_SENSITIVE_TO_MARCELLO_WEAPON) && item instanceof MarcelloEffectiveWeapon wpn)
			bonus = wpn.getMarcelloDamageBonus();

		cir.setReturnValue(cir.getReturnValue() + bonus);
	}

	@Inject(at = @At("RETURN"), method = "modifyArmorEffectiveness", cancellable = true)
	private static void marcellomod$modifyArmorEffectiveness(ServerLevel level, ItemStack tool, Entity entity, DamageSource damageSource, float armorEffectiveness, CallbackInfoReturnable<Float> cir)
	{
		if (tool.is(MM_Tags.ITEM_ARMOR_BREACH_WEAPONS))
			cir.setReturnValue(cir.getReturnValue() - 0.5F);
	}
}