package io.github.luisrandomness.marcellomod.core.registry;

import io.github.luisrandomness.marcellomod.MarcelloMod;
import net.minecraft.entity.item.PaintingType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = MarcelloMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MM_Paintings {
    public static final DeferredRegister<PaintingType> REGISTRY = DeferredRegister.create(ForgeRegistries.PAINTING_TYPES, MarcelloMod.MOD_ID);

    public static final RegistryObject<PaintingType> MARSELO = REGISTRY.register("marselo", () -> new PaintingType(16,16));
    public static final RegistryObject<PaintingType> LETS_PLAY_MINECRAFT = REGISTRY.register("lets_play_minecraft", () -> new PaintingType(32,16));
    public static final RegistryObject<PaintingType> MARCELLO_PFP = REGISTRY.register("marcello_pfp", () -> new PaintingType(32,32));
    public static final RegistryObject<PaintingType> RACIST = REGISTRY.register("racist", () -> new PaintingType(32,32));
    public static final RegistryObject<PaintingType> THE_WHAT = REGISTRY.register("the_what", () -> new PaintingType(32,32));
    public static final RegistryObject<PaintingType> MICHAEL_SONIC = REGISTRY.register("michael_sonic", () -> new PaintingType(16,32));
    public static final RegistryObject<PaintingType> RUN = REGISTRY.register("run", () -> new PaintingType(64,32));
}
