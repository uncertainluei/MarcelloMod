package io.github.luisrandomness.marcellomod.core.types;

import io.github.luisrandomness.marcellomod.MarcelloMod;
import io.github.luisrandomness.marcellomod.core.registry.MM_Items;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.function.Supplier;

public enum MM_ArmorTier implements IArmorMaterial {
   RUISIUM("ruisium", 37, new int[]{3, 7, 9, 4}, 12, SoundEvents.ARMOR_EQUIP_DIAMOND, 2.5F, 0.1F, () -> {
      return Ingredient.of(MM_Items.RUISIUM_INGOT.get());
   });

   private static final int[] HEALTH_PER_SLOT = new int[]{13, 15, 16, 11};
   private final String name;
   private final int durabilityMultiplier;
   private final int[] slotProtections;
   private final int enchantmentValue;
   private final SoundEvent sound;
   private final float toughness;
   private final float knockbackResistance;
   private final LazyValue<Ingredient> repairIngredient;

   private MM_ArmorTier(String p_i231593_3_, int p_i231593_4_, int[] p_i231593_5_, int p_i231593_6_, SoundEvent p_i231593_7_, float p_i231593_8_, float p_i231593_9_, Supplier<Ingredient> p_i231593_10_) {
      this.name = MarcelloMod.MOD_ID + ":" + p_i231593_3_;
      this.durabilityMultiplier = p_i231593_4_;
      this.slotProtections = p_i231593_5_;
      this.enchantmentValue = p_i231593_6_;
      this.sound = p_i231593_7_;
      this.toughness = p_i231593_8_;
      this.knockbackResistance = p_i231593_9_;
      this.repairIngredient = new LazyValue<>(p_i231593_10_);
   }

   public int getDurabilityForSlot(EquipmentSlotType p_200896_1_) {
      return HEALTH_PER_SLOT[p_200896_1_.getIndex()] * this.durabilityMultiplier;
   }

   public int getDefenseForSlot(EquipmentSlotType p_200902_1_) {
      return this.slotProtections[p_200902_1_.getIndex()];
   }

   public int getEnchantmentValue() {
      return this.enchantmentValue;
   }

   public SoundEvent getEquipSound() {
      return this.sound;
   }

   public Ingredient getRepairIngredient() {
      return this.repairIngredient.get();
   }

   @OnlyIn(Dist.CLIENT)
   public String getName() {
      return this.name;
   }

   public float getToughness() {
      return this.toughness;
   }

   public float getKnockbackResistance() {
      return this.knockbackResistance;
   }
}