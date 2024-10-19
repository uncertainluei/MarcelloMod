package io.github.luisrandomness.marcellomod.item;

import io.github.luisrandomness.marcellomod.init.MM_Blocks;
import io.github.luisrandomness.marcellomod.init.MM_Items;
import io.github.luisrandomness.marcellomod.init.MM_Tags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

public enum MM_ToolTier implements Tier {
   MARCELLO(MM_Tags.INCORRECT_FOR_MARCELLO_TOOL, 226, 5F, 2F, 11, Ingredient.of(MM_Blocks.MARCELLO_BLOCK)),
   RUISIUM(MM_Tags.INCORRECT_FOR_RUISIUM_TOOL, 1923, 9.5F, 5F, 9, Ingredient.of(MM_Items.RUISIUM_SHARD));

   private final TagKey<Block> incompatibleBlockTag;
   private final int uses;
   private final float speed;
   private final float damage;
   private final int enchantmentValue;
   private final Ingredient repairIngredient;

   MM_ToolTier(final TagKey<Block> incorrectBlockForDrops, int durability, float efficiency, float attackDamage, int enchantmentValue, Ingredient repairMaterial) {
      this.incompatibleBlockTag = incorrectBlockForDrops;
      this.uses = durability;
      this.speed = efficiency;
      this.damage = attackDamage;
      this.enchantmentValue = enchantmentValue;
      this.repairIngredient = repairMaterial;
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

   public int getEnchantmentValue() {
      return this.enchantmentValue;
   }

   public @NotNull Ingredient getRepairIngredient() {
      return this.repairIngredient;
   }

   public @NotNull TagKey<Block> getIncorrectBlocksForDrops() { return incompatibleBlockTag; }
}