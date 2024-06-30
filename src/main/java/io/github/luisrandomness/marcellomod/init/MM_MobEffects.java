package io.github.luisrandomness.marcellomod.init;

import io.github.luisrandomness.marcellomod.MarcelloMod;
import io.github.luisrandomness.marcellomod.effects.BlockedEffect;
import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.*;

import java.util.ArrayList;

public class MM_MobEffects {
    public static final ArrayList<MobEffect> ALL_EFFECTS = new ArrayList<>();

    public static MobEffect registerEffect(String identifier, MobEffect statusEffect)
    {
        MobEffect result = Registry.register(BuiltInRegistries.MOB_EFFECT, MarcelloMod.modIdentifier(identifier), statusEffect);
        ALL_EFFECTS.add(result);
        return result;
    }

    public static final MobEffect BLOCKED = registerEffect("blocked", new BlockedEffect(MobEffectCategory.HARMFUL, 12060447));
    public static final MobEffect WHOOSH = registerEffect("whoosh", new BlockedEffect(MobEffectCategory.HARMFUL, 15093895));

    public static void registerAll()
    {
        // TODO - Make these configurable!
        AttackBlockCallback.EVENT.register((player, world, hand, pos, direction) -> {
            if (!player.isSpectator() && player.hasEffect(BLOCKED))
                return InteractionResult.FAIL;
            return InteractionResult.PASS;
        });

        UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {
            if (!player.isSpectator() && player.hasEffect(BLOCKED))
                return InteractionResult.FAIL;
            return InteractionResult.PASS;
        });
    }
}