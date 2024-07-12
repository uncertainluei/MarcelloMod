package io.github.luisrandomness.marcellomod.core.registry;

import io.github.luisrandomness.marcellomod.MarcelloMod;
import io.github.luisrandomness.marcellomod.core.entities.MarcelloEntity;
import io.github.luisrandomness.marcellomod.core.entities.MoldyEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber(modid = MarcelloMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MM_EntityTypes {
    public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITIES, MarcelloMod.MOD_ID);
    private static final List<EntityType<?>> ALL = new ArrayList<>();

    public static final RegistryObject<EntityType<MarcelloEntity>> MARCELLO = REGISTRY.register("marcello", () -> EntityType.Builder.of(MarcelloEntity::new, EntityClassification.MONSTER)
            .sized(0.6F, 1.8F)
            .build(new ResourceLocation(MarcelloMod.MOD_ID,"marcello").toString()));
    public static final RegistryObject<EntityType<MoldyEntity>> MOLDY = REGISTRY.register("moldy", () -> EntityType.Builder.of(MoldyEntity::new, EntityClassification.CREATURE)
            .sized(0.6F, 1.8F)
            .build(new ResourceLocation(MarcelloMod.MOD_ID,"moldy").toString()));
}
