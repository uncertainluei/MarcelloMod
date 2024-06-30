package io.github.luisrandomness.marcellomod.init;

import io.github.luisrandomness.marcellomod.MarcelloMod;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public class MM_ArmorTiers {
    public static final Holder<ArmorMaterial> JUMPERITE = register("jumperite", armorToEnum(4,9,7,3), 10, SoundEvents.ARMOR_EQUIP_DIAMOND, 1F, 0F, () -> Ingredient.of(MM_Items.JUMPERITE_INGOT));

    private static Holder<ArmorMaterial> register(String name, EnumMap<ArmorItem.Type, Integer> defense, int enchantmentValue, Holder<SoundEvent> equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
        EnumMap<ArmorItem.Type, Integer> enumMap = new EnumMap(ArmorItem.Type.class);
        ArmorItem.Type[] values = ArmorItem.Type.values();
        int valueCount = values.length;

        for(int var11 = 0; var11 < valueCount; ++var11) {
            ArmorItem.Type type = values[var11];
            enumMap.put(type, defense.get(type));
        }

        ResourceLocation location = MarcelloMod.modIdentifier(name);
        return Registry.registerForHolder(BuiltInRegistries.ARMOR_MATERIAL, location, new ArmorMaterial(enumMap, enchantmentValue, equipSound, repairIngredient, List.of(new ArmorMaterial.Layer(location)), toughness, knockbackResistance));
    }

    private static EnumMap armorToEnum(int head, int chest, int legs, int feet)
    {
        return Util.make(new EnumMap(ArmorItem.Type.class), (map) -> {
            map.put(ArmorItem.Type.BOOTS, feet);
            map.put(ArmorItem.Type.LEGGINGS, legs);
            map.put(ArmorItem.Type.CHESTPLATE, chest);
            map.put(ArmorItem.Type.HELMET, head);
        });
    }

    public static void registerArmorTiers() {}
}
