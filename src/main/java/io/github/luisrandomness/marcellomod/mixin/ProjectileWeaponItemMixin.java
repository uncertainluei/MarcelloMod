package io.github.luisrandomness.marcellomod.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import io.github.luisrandomness.marcellomod.item.RuisiumBowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ProjectileWeaponItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(ProjectileWeaponItem.class)
public class ProjectileWeaponItemMixin {
    @ModifyVariable(method = "shoot", at = @At(value = "HEAD"), ordinal = 0, argsOnly = true)
    private boolean marcellomod$modifyJumperiteBowCrit(boolean value, @Local(argsOnly = true, ordinal = 0) float velocity, @Local(argsOnly = true, ordinal = 0) ItemStack weapon)
    {
        System.out.println(velocity);
        return (weapon.getItem() instanceof RuisiumBowItem) ? velocity >= 5F : value;
    }
}
