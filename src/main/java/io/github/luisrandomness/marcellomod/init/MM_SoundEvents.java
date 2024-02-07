package io.github.luisrandomness.marcellomod.init;

import io.github.luisrandomness.marcellomod.MarcelloMod;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class MM_SoundEvents {

    public static final SoundEvent ITEM_BLOCK_BUTTON_PRESS = register("item.block_button.press");
    public static final SoundEvent ITEM_BLOCK_BUTTON_BLOCK = register("item.block_button.block");

    public static final SoundEvent ENTITY_GOTTA_SWEEP_INTRO = register("entity.gotta_sweep.intro");
    public static final SoundEvent ENTITY_GOTTA_SWEEP_SWEEP = register("entity.gotta_sweep.sweep");

    public static final SoundEvent ENTITY_MARCELLO_AMBIENT = register("entity.marcello.ambient");
    public static final SoundEvent ENTITY_MARCELLO_HURT = register("entity.marcello.hurt");
    public static final SoundEvent ENTITY_MARCELLO_DEATH = register("entity.marcello.death");

    public static final SoundEvent ENTITY_MARK_AMBIENT = register("entity.mark.ambient");
    public static final SoundEvent ENTITY_MARK_BLOCK = register("entity.mark.block");
    public static final SoundEvent ENTITY_MARK_HURT = register("entity.mark.hurt");
    public static final SoundEvent ENTITY_MARK_DEATH = register("entity.mark.death");

    private static SoundEvent register(String identifier) {
        Identifier id = MarcelloMod.modIdentifier(identifier);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerAll()
    {

    }
}