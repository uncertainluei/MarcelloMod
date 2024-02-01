package io.github.luisrandomness.marcellomod.init;


import net.minecraft.block.Block;
import net.minecraft.entity.decoration.painting.PaintingVariant;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import static io.github.luisrandomness.marcellomod.MarcelloMod.modIdentifier;

public class MM_Tags {

    public static final TagKey<PaintingVariant> PAINTINGS = TagKey.of(RegistryKeys.PAINTING_VARIANT, modIdentifier("paintings"));
    public static final TagKey<Block> BLOCK_MARCELLO_EFFICIENT = blockTag("marcello_tool_efficient");

    public static final TagKey<Block> BLOCK_MARCELLO_ORES = blockTag("marcello_ores");
    public static final TagKey<Block> BLOCK_JUMPERITE_ORES = blockTag("jumperite_ores");

    public static final TagKey<Item> ITEM_MARCELLO_ORES = itemTag("marcello_ores");
    public static final TagKey<Item> ITEM_JUMPERITE_ORES = itemTag("jumperite_ores");
    public static final TagKey<Item> ITEM_JUMPERITE_ARMOR = itemTag("jumperite_armor");


    private static TagKey<Block> blockTag(String identifier) {
        return TagKey.of(RegistryKeys.BLOCK, modIdentifier(identifier));
    }
    private static TagKey<Item> itemTag(String identifier) {
        return TagKey.of(RegistryKeys.ITEM, modIdentifier(identifier));
    }
}