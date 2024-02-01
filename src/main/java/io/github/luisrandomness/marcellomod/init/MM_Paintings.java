package io.github.luisrandomness.marcellomod.init;

import io.github.luisrandomness.marcellomod.MarcelloMod;
import net.minecraft.entity.decoration.painting.PaintingVariant;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

import java.util.ArrayList;

import static io.github.luisrandomness.marcellomod.MarcelloMod.modIdentifier;


public class MM_Paintings {

    public static final ArrayList<PaintingVariant> ALL_PAINTINGS = new ArrayList<>();

    public static PaintingVariant registerPainting(String identifier, int wid, int hei)
    {
        PaintingVariant result = Registry.register(Registries.PAINTING_VARIANT, MarcelloMod.modIdentifier(identifier), new PaintingVariant(wid*16,hei*16));
        ALL_PAINTINGS.add(result);
        return result;
    }

    public static final PaintingVariant MARSELO = registerPainting("marselo", 1,1);
    public static final PaintingVariant LETS_PLAY_MINECRAFT = registerPainting("lets_play_minecraft", 2,1);
    public static final PaintingVariant MARCELLO_PFP = registerPainting("marcello_pfp", 2,2);
    public static final PaintingVariant RACIST = registerPainting("racist", 2,2);
    public static final PaintingVariant THE_WHAT = registerPainting("the_what", 2,2);
    public static final PaintingVariant MICHAEL_SONIC = registerPainting("michael_sonic", 1,2);
    public static final PaintingVariant RUN = registerPainting("run", 4,2);

    public static void registerAll() {}
}