package io.github.luisrandomness.marcellomod.mixin;

import io.github.luisrandomness.marcellomod.init.MM_Tags;
import io.github.luisrandomness.marcellomod.item.MarcelloEffectiveWeapon;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EnchantmentHelper.class)
public abstract class EnchantmentHelperMixin {
	@Inject(at = @At("RETURN"), method = "modifyDamage(Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/entity/Entity;Lnet/minecraft/world/damagesource/DamageSource;F)F", cancellable = true)
	private static void marcellomod$modifyDamage(ServerLevel level, ItemStack tool, Entity entity, DamageSource damageSource, float damage, CallbackInfoReturnable<Float> cir) {
		Item item = tool.getItem();

		float bonus = entity.getType().is(MM_Tags.ENTITY_SENSITIVE_TO_MARCELLO_WEAPON) && item instanceof MarcelloEffectiveWeapon ? ((MarcelloEffectiveWeapon) item).getMarcelloDamageBonus() : 0F;
		cir.setReturnValue(cir.getReturnValue() + bonus);
	}


}