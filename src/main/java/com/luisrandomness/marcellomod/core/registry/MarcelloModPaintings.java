package com.luisrandomness.marcellomod.core.registry;

import com.luisrandomness.marcellomod.MarcelloMod;
import net.minecraft.entity.item.PaintingType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = MarcelloMod.ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MarcelloModPaintings {
    public static final DeferredRegister<PaintingType> REGISTRY = DeferredRegister.create(ForgeRegistries.PAINTING_TYPES, MarcelloMod.ID);

    public static final RegistryObject<PaintingType> MARCELLO_16 = REGISTRY.register("marcello_16", () -> new PaintingType(16,16));
    public static final RegistryObject<PaintingType> MARCELLO_HALLOWEEN = REGISTRY.register("marcello_halloween", () -> new PaintingType(32,16));
    public static final RegistryObject<PaintingType> MARCELLO_MINECRAFT = REGISTRY.register("marcello_minecraft", () -> new PaintingType(32,16));
    public static final RegistryObject<PaintingType> MARCELLO_PFP = REGISTRY.register("marcello_pfp", () -> new PaintingType(48,48));
    public static final RegistryObject<PaintingType> MARCELLO_SWITCH = REGISTRY.register("marcello_switch", () -> new PaintingType(32,32));
    public static final RegistryObject<PaintingType> RACIST = REGISTRY.register("racist", () -> new PaintingType(32,32));
}
