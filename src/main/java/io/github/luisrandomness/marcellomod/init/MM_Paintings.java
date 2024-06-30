package io.github.luisrandomness.marcellomod.init;

import io.github.luisrandomness.marcellomod.MarcelloMod;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.*;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraft.world.entity.decoration.PaintingVariants;

import java.util.ArrayList;

import static io.github.luisrandomness.marcellomod.MarcelloMod.modIdentifier;


public class MM_Paintings {

    public static ArrayList<ResourceKey<PaintingVariant>> ALL_PAINTINGS = new ArrayList<ResourceKey<PaintingVariant>>();

    private static ResourceKey<PaintingVariant> create(String name) {
        return ResourceKey.create(Registries.PAINTING_VARIANT, MarcelloMod.modIdentifier(name));
    }

    private static void register(BootstrapContext<PaintingVariant> context, ResourceKey<PaintingVariant> key, int width, int height) {
        context.register(key, new PaintingVariant(width, height, key.location()));
        ALL_PAINTINGS.add(key);
    }

    public static final ResourceKey<PaintingVariant> MARSELO = create("marselo");
    public static final ResourceKey<PaintingVariant> LETS_PLAY_MINECRAFT = create("lets_play_minecraft");
    public static final ResourceKey<PaintingVariant> SPOOKY_MONTH = create("spooky_month");
    public static final ResourceKey<PaintingVariant> XMAS = create("xmas");
    public static final ResourceKey<PaintingVariant> PFP = create("pfp");
    public static final ResourceKey<PaintingVariant> RACIST = create("racist");
    public static final ResourceKey<PaintingVariant> THE_WHAT = create("the_what");
    public static final ResourceKey<PaintingVariant> MICHAEL_SONIC = create("michael_sonic");
    public static final ResourceKey<PaintingVariant> RUN = create("run");

    public static void createKeys() {}

    public static void bootstrap(BootstrapContext<PaintingVariant> context) {
        register(context, MARSELO, 1, 1);
        register(context, LETS_PLAY_MINECRAFT, 2, 1);
        register(context, SPOOKY_MONTH, 2, 1);
        register(context, XMAS, 2, 2);
        register(context, PFP, 2, 2);
        register(context, RACIST, 2, 2);
        register(context, THE_WHAT, 2, 2);
        register(context, MICHAEL_SONIC, 1, 2);
        register(context, RUN, 4, 2);
    }
}