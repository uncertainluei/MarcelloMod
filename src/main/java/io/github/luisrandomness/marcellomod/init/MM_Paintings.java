package io.github.luisrandomness.marcellomod.init;

import io.github.luisrandomness.marcellomod.MarcelloMod;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.*;
import net.minecraft.world.entity.decoration.PaintingVariant;

import java.util.ArrayList;

import static io.github.luisrandomness.marcellomod.MarcelloMod.modIdentifier;


public class MM_Paintings {

    public static final ArrayList<PaintingVariant> ALL_PAINTINGS = new ArrayList<>();

    public static PaintingVariant registerPainting(String identifier, int wid, int hei)
    {
        PaintingVariant result = Registry.register(BuiltInRegistries.PAINTING_VARIANT, MarcelloMod.modIdentifier(identifier), new PaintingVariant(wid*16,hei*16));
        ALL_PAINTINGS.add(result);
        return result;
    }

    public static final PaintingVariant MARSELO = registerPainting("marselo", 1,1);
    public static final PaintingVariant LETS_PLAY_MINECRAFT = registerPainting("lets_play_minecraft", 2,1);
    public static final PaintingVariant SPOOKY_MONTH = registerPainting("spooky_month", 2,1);
    public static final PaintingVariant XMAS = registerPainting("xmas", 2,2);
    public static final PaintingVariant PFP = registerPainting("pfp", 2,2);
    public static final PaintingVariant RACIST = registerPainting("racist", 2,2);
    public static final PaintingVariant THE_WHAT = registerPainting("the_what", 2,2);
    public static final PaintingVariant MICHAEL_SONIC = registerPainting("michael_sonic", 1,2);
    public static final PaintingVariant RUN = registerPainting("run", 4,2);

    public static void registerAll() {}
}