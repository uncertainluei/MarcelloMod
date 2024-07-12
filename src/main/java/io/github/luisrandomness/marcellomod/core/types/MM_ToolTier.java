package io.github.luisrandomness.marcellomod.core.types;

import io.github.luisrandomness.marcellomod.core.registry.MM_Items;
import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;

import java.util.function.Supplier;

public enum MM_ToolTier implements IItemTier {
   MARCELLO(2, 384, 6.0F, 2.0F, 8, () -> {
      return Ingredient.of(MM_Items.MARCELLO_BLOCK.get());
   }),
   RUISIUM(4, 1999, 9.5F, 5.0F, 12, () -> {
      return Ingredient.of(MM_Items.RUISIUM_INGOT.get());
   });

   private final int level;
   private final int uses;
   private final float speed;
   private final float damage;
   private final int enchantmentValue;
   private final LazyValue<Ingredient> repairIngredient;

   private MM_ToolTier(int p_i48458_3_, int p_i48458_4_, float p_i48458_5_, float p_i48458_6_, int p_i48458_7_, Supplier<Ingredient> p_i48458_8_) {
      this.level = p_i48458_3_;
      this.uses = p_i48458_4_;
      this.speed = p_i48458_5_;
      this.damage = p_i48458_6_;
      this.enchantmentValue = p_i48458_7_;
      this.repairIngredient = new LazyValue<>(p_i48458_8_);
   }

   public int getUses() {
      return this.uses;
   }

   public float getSpeed() {
      return this.speed;
   }

   public float getAttackDamageBonus() {
      return this.damage;
   }

   public int getLevel() {
      return this.level;
   }

   public int getEnchantmentValue() {
      return this.enchantmentValue;
   }

   public Ingredient getRepairIngredient() {
      return this.repairIngredient.get();
   }
}