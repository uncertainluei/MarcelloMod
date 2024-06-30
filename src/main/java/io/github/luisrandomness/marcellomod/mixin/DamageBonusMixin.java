package io.github.luisrandomness.marcellomod.mixin;

import io.github.luisrandomness.marcellomod.init.MM_EntityTypes;
import io.github.luisrandomness.marcellomod.item.MarcelloEffectiveWeapon;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EnchantmentHelper.class)
public abstract class DamageBonusMixin {
	@Inject(at = @At("RETURN"), method = "getDamageBonus(Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/entity/MobType;)F", cancellable = true)
	private static void marcellomod$getDamageBonus(ItemStack stack, MobType mobType, CallbackInfoReturnable<Float> cir) {
		Item item = stack.getItem();
		float bonus = mobType == MM_EntityTypes.MARCELLO_TYPE && item instanceof MarcelloEffectiveWeapon ? ((MarcelloEffectiveWeapon) item).getMarcelloDamageBonus() : 0F;
		cir.setReturnValue(cir.getReturnValue() + bonus);
	}
}