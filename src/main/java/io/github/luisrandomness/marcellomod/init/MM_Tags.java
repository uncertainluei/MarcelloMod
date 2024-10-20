package io.github.luisrandomness.marcellomod.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import static io.github.luisrandomness.marcellomod.MarcelloMod.modIdentifier;

public class MM_Tags {

    public static final TagKey<PaintingVariant> PAINTINGS = TagKey.create(Registries.PAINTING_VARIANT, modIdentifier("paintings"));
    public static final TagKey<Block> BLOCK_MARCELLO_EFFICIENT = blockTag("marcello_tool_efficient");

    public static final TagKey<Block> NEEDS_MARCELLO_TOOL = blockTag("needs_marcello_tool");
    public static final TagKey<Block> INCORRECT_FOR_MARCELLO_TOOL = blockTag("incorrect_for_marcello_tool");

    public static final TagKey<Block> NEEDS_RUISIUM_TOOL = blockTag("needs_ruisium_tool");
    public static final TagKey<Block> INCORRECT_FOR_RUISIUM_TOOL = blockTag("incorrect_for_ruisium_tool");

    public static final TagKey<Block> BLOCK_MARCELLO_ORES = blockTag("marcello_ores");
    public static final TagKey<Block> BLOCK_RUISIUM_ORES = blockTag("ruisium_ores");
    public static final TagKey<Block> BLOCK_MARCELIUM_LOGS = blockTag("marcelium_logs");
    public static final TagKey<Block> BLOCK_MARCELIUM_LEAVES = blockTag("marcelium_leaves");
    public static final TagKey<Block> BLOCK_MARCELIUM_SAPLINGS = blockTag("marcelium_saplings");

    public static final TagKey<Item> ITEM_MARCELLO_TOOLS = itemTag("marcello_effective_tools");
    public static final TagKey<Item> ITEM_MARCELLO_WEAPONS = itemTag("marcello_effective_weapons");

    public static final TagKey<Item> ITEM_MARCELLO_ORES = itemTag("marcello_ores");
    public static final TagKey<Item> ITEM_MARCELLO_BLOCK_SMELTABLES = itemTag("marcello_block_smeltables");
    public static final TagKey<Item> ITEM_RUISIUM_ORES = itemTag("ruisium_ores");
    public static final TagKey<Item> ITEM_RUISIUM_ARMOR = itemTag("ruisium_armor");
    public static final TagKey<Item> ITEM_MARCELIUM_LOGS = itemTag("marcelium_logs");
    public static final TagKey<Item> ITEM_MARCELIUM_LEAVES = itemTag("marcelium_leaves");
    public static final TagKey<Item> ITEM_MARCELIUM_SAPLINGS = itemTag("marcelium_saplings");

    public static final TagKey<EntityType<?>> ENTITY_BLOCK_BUTTON_IMMUNE = entityTag("block_button_immune");
    public static final TagKey<EntityType<?>> ENTITY_MARCELLO_TYPE = entityTag("marcello_type");
    public static final TagKey<EntityType<?>> ENTITY_SENSITIVE_TO_MARCELLO_WEAPON = entityTag("sensitive_to_marcello_weapon");


    private static TagKey<Block> blockTag(String identifier) {
        return TagKey.create(Registries.BLOCK, modIdentifier(identifier));
    }
    private static TagKey<Item> itemTag(String identifier) {
        return TagKey.create(Registries.ITEM, modIdentifier(identifier));
    }

    private static TagKey<EntityType<?>> entityTag(String identifier) {
        return TagKey.create(Registries.ENTITY_TYPE, modIdentifier(identifier));
    }
}