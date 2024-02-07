package io.github.luisrandomness.marcellomod.init;

import io.github.luisrandomness.marcellomod.MarcelloMod;
import io.github.luisrandomness.marcellomod.effects.BlockedEffect;
import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.decoration.painting.PaintingVariant;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.ActionResult;

import java.util.ArrayList;

public class MM_StatusEffects {
    public static final ArrayList<StatusEffect> ALL_EFFECTS = new ArrayList<>();

    public static StatusEffect registerEffect(String identifier, StatusEffect statusEffect)
    {
        StatusEffect result = Registry.register(Registries.STATUS_EFFECT, MarcelloMod.modIdentifier(identifier), statusEffect);
        ALL_EFFECTS.add(result);
        return result;
    }

    public static final StatusEffect BLOCKED = registerEffect("blocked", new BlockedEffect(StatusEffectCategory.HARMFUL, 12060447));
    public static final StatusEffect WHOOSH = registerEffect("whoosh", new BlockedEffect(StatusEffectCategory.HARMFUL, 15093895));

    public static void registerAll()
    {
        // TODO - Make these configurable!

        AttackBlockCallback.EVENT.register((player, world, hand, pos, direction) -> {
            if (!player.isSpectator() && player.hasStatusEffect(BLOCKED))
                return ActionResult.FAIL;
            return ActionResult.PASS;
        });

        UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {
            if (!player.isSpectator() && player.hasStatusEffect(BLOCKED))
                return ActionResult.FAIL;
            return ActionResult.PASS;
        });
    }
}