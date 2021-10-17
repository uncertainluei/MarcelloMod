package me.luisrandomness.marcellomod.core.registry;

import me.luisrandomness.marcellomod.MarcelloMod;
import me.luisrandomness.marcellomod.core.entities.*;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber(modid = MarcelloMod.ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MarcelloModEntityTypes {
    public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITIES, MarcelloMod.ID);
    private static final List<EntityType<?>> ALL = new ArrayList<>();

    public static final RegistryObject<EntityType<MarcelloEntity>> MARCELLO = REGISTRY.register("marcello", () -> EntityType.Builder.of(MarcelloEntity::new, EntityClassification.MONSTER)
            .sized(0.6F, 1.8F)
            .build(new ResourceLocation(MarcelloMod.ID,"marcello").toString()));
    public static final RegistryObject<EntityType<MoldyEntity>> MOLDY = REGISTRY.register("moldy", () -> EntityType.Builder.of(MoldyEntity::new, EntityClassification.CREATURE)
            .sized(0.6F, 1.8F)
            .build(new ResourceLocation(MarcelloMod.ID,"moldy").toString()));
}
