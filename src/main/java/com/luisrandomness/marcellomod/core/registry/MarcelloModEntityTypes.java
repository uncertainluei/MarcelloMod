package com.luisrandomness.marcellomod.core.registry;

import com.luisrandomness.marcellomod.MarcelloMod;
import com.luisrandomness.marcellomod.core.entities.MarcelloEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = MarcelloMod.ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MarcelloModEntityTypes {
    public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITIES, MarcelloMod.ID);
    private static final List<EntityType<?>> ALL = new ArrayList<>();

    public static final RegistryObject<EntityType<MarcelloEntity>> MARCELLO = REGISTRY.register("marcello", () -> EntityType.Builder.of(MarcelloEntity::new, EntityClassification.MONSTER)
            .sized(0.6F, 1.8F)
            .build(new ResourceLocation(MarcelloMod.ID,":marcello").toString()));
}
