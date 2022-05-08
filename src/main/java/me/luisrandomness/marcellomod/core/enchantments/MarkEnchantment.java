package me.luisrandomness.marcellomod.core.enchantments;

import me.luisrandomness.marcellomod.core.types.MM_CreatureTypes;
import net.minecraft.enchantment.DamageEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.inventory.EquipmentSlotType;

public class MarkEnchantment extends Enchantment {
    public MarkEnchantment(Rarity rarityIn, EnchantmentType typeIn, EquipmentSlotType[] slots) {
        super(rarityIn, typeIn, slots);
    }

    @Override
    public float getDamageBonus(int p_152376_1_, CreatureAttribute p_152376_2_) {
        return p_152376_2_ == MM_CreatureTypes.MARCELLO ? (float)p_152376_1_ * 2.5F : 0.0F;
    }

    public int getMinCost(int p_77321_1_) {
        return 20;
    }

    public int getMaxCost(int p_223551_1_) {
        return 50;
    }

    @Override
    public boolean isTreasureOnly() {
        return true;
    }

    @Override
    public boolean isTradeable() {
        return false;
    }

    public boolean checkCompatibility(Enchantment p_77326_1_) {
        return !(p_77326_1_ instanceof DamageEnchantment);
    }

    public int getMaxLevel() {
        return 3;
    }
}

