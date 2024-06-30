package io.github.luisrandomness.marcellomod.item;

import io.github.luisrandomness.marcellomod.init.MM_Items;
import net.minecraft.Util;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;

import java.util.EnumMap;
import java.util.function.Supplier;

import static io.github.luisrandomness.marcellomod.MarcelloMod.MOD_NAMESPACE;

public enum MM_ArmorTier implements StringRepresentable, ArmorMaterial {
    JUMPERITE("jumperite", 35, armorToEnum(4,9,7,3), 10, SoundEvents.ARMOR_EQUIP_DIAMOND, 1F, 0F, () -> Ingredient.of(MM_Items.JUMPERITE_INGOT));

    private final String name;
    private final int durabilityMultiplier;
    private final EnumMap<ArmorItem.Type, Integer> protectionAmounts;
    private static final EnumMap<ArmorItem.Type, Integer> BASE_DURABILITY = armorToEnum(11,16,15,13);
    private final int enchantmentValue;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final LazyLoadedValue<Ingredient> repairIngredientSupplier;

    private static EnumMap armorToEnum(int head, int chest, int legs, int feet)
    {
        return Util.make(new EnumMap(ArmorItem.Type.class), (map) -> {
            map.put(ArmorItem.Type.BOOTS, feet);
            map.put(ArmorItem.Type.LEGGINGS, legs);
            map.put(ArmorItem.Type.CHESTPLATE, chest);
            map.put(ArmorItem.Type.HELMET, head);
        });
    }

    private MM_ArmorTier(String name, int durabilityMultiplier, EnumMap protectionAmounts, int enchantmentValue, SoundEvent equipSound, float toughness, float knockbackResistance, Supplier repairIngredientSupplier) {
        this.name = MOD_NAMESPACE + ":" + name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionAmounts = protectionAmounts;
        this.enchantmentValue = enchantmentValue;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredientSupplier = new LazyLoadedValue(repairIngredientSupplier);
    }

    public int getDurabilityForType(ArmorItem.Type type) {
        return BASE_DURABILITY.get(type) * this.durabilityMultiplier;
    }

    public int getDefenseForType(ArmorItem.Type type) { return this.protectionAmounts.get(type); }

    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    public @NotNull SoundEvent getEquipSound() {
        return this.equipSound;
    }

    public @NotNull Ingredient getRepairIngredient() {
        return (Ingredient)this.repairIngredientSupplier.get();
    }

    public @NotNull String getName() {
        return this.name;
    }

    public float getToughness() {
        return this.toughness;
    }

    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }

    public @NotNull String getSerializedName() {
        return this.name;
    }
}
