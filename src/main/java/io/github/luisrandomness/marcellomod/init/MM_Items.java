package io.github.luisrandomness.marcellomod.init;

import io.github.luisrandomness.marcellomod.item.*;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.effect.*;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.stat.Stat;
import net.minecraft.text.Text;
import net.minecraft.util.Rarity;

import java.util.ArrayList;

import static io.github.luisrandomness.marcellomod.MarcelloMod.modIdentifier;

public class MM_Items {

    private static FoodComponent.Builder allStatusEffects(StatusEffectCategory cat, FoodComponent.Builder builder)
    {
        for (StatusEffect effect : Registries.STATUS_EFFECT)
            if (effect.getCategory() == cat)
                builder = builder.statusEffect(new StatusEffectInstance(effect, 1200, 5), 1F);
        return builder;
    }

    public static final FoodComponent FOOD_MARCELLO_FRUIT =  new FoodComponent.Builder().hunger(3).saturationModifier(0.2F)
            .statusEffect(new StatusEffectInstance(StatusEffects.HUNGER,480,0), 0.75F)
            .statusEffect(new StatusEffectInstance(StatusEffects.POISON,480,0),0.5F)
            .build();
    public static final FoodComponent FOOD_MOLDY_FRUIT = new FoodComponent.Builder().hunger(6).saturationModifier(0.4F)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION,120,0), 0.5F)
            .statusEffect(new StatusEffectInstance(StatusEffects.STRENGTH,480,0),0.25F)
            .build();

    public static final FoodComponent FOOD_MARCELLO_FRUIT_UNNERFED = allStatusEffects(StatusEffectCategory.HARMFUL, new FoodComponent.Builder().hunger(1).saturationModifier(0.3F)).build();
    public static final FoodComponent FOOD_MOLDY_FRUIT_UNNERFED = allStatusEffects(StatusEffectCategory.BENEFICIAL, new FoodComponent.Builder().hunger(1).saturationModifier(0.3F)).build();

    private static final ArrayList<Item> ALL_ITEMS = new ArrayList<>();
    private static final ArrayList<Item> AUTO_CREATIVE_ITEMS = new ArrayList<>();

    public static Item registerItem(String identifier, Item item, boolean includeInCreative)
    {
        Item result = Registry.register(Registries.ITEM, modIdentifier(identifier), item);
        ALL_ITEMS.add(result);
        if (includeInCreative)
            AUTO_CREATIVE_ITEMS.add(result);
        return result;
    }
    public static Item registerItem(String identifier, Item item)
    {
        return registerItem(identifier,item,true);
    }

    public static final Item MARCELLO_FRUIT =  registerItem("marcello_fruit", new Item(new FabricItemSettings().food(FOOD_MARCELLO_FRUIT)));
    public static final Item MOLDY_FRUIT =  registerItem("moldy_fruit", new Item(new FabricItemSettings().food(FOOD_MOLDY_FRUIT)));
    public static final Item JUMPMAN_BALL =  registerItem("jumpman_ball", new SnowballItem(new FabricItemSettings().maxCount(16)));
    public static final Item JUMPERITE_SHARD = registerItem("jumperite_shard", new Item(new FabricItemSettings().rarity(Rarity.EPIC)));
    public static final Item JUMPERITE_INGOT = registerItem("jumperite_ingot", new Item(new FabricItemSettings().rarity(Rarity.EPIC)));
    public static final Item JUMPERITE_ROD = registerItem("jumperite_rod", new Item(new FabricItemSettings().rarity(Rarity.EPIC)));

    public static final Item PHONE = registerItem ("phone", new PhoneItem(EntityType.CREEPER, new FabricItemSettings().maxCount(1).maxDamage(8)));
    public static final Item OTHERWORLDLY_PHONE = registerItem ("otherworldly_phone", new FlintAndSteelItem(new FabricItemSettings().maxCount(1).maxDamage(64).rarity(Rarity.RARE)));
    public static final Item BLOCK_BUTTON = registerItem ("block_button", new BlockButtonItem(new FabricItemSettings().maxCount(1).maxDamage(8)));

    public static final Item MARCELLO_SWORD = registerItem ("marcello_sword", new MarcelloSwordItem(MM_ToolTier.MARCELLO,3,-2.4F,new FabricItemSettings()));
    public static final Item MARCELLO_SHOVEL = registerItem ("marcello_shovel", new MarcelloShovelItem(MM_ToolTier.MARCELLO,1.5F,-3F,new FabricItemSettings()));
    public static final Item MARCELLO_PICKAXE = registerItem ("marcello_pickaxe", new MarcelloPickaxeItem(MM_ToolTier.MARCELLO,1,-2.8F,new FabricItemSettings()));
    public static final Item MARCELLO_AXE = registerItem ("marcello_axe", new MarcelloAxeItem(MM_ToolTier.MARCELLO,6,-3.1F,new FabricItemSettings()));
    public static final Item MARCELLO_HOE = registerItem ("marcello_hoe", new MarcelloHoeItem(MM_ToolTier.MARCELLO,-2,-1F,new FabricItemSettings()));

    public static final Item JUMPERITE_SWORD = registerItem ("jumperite_sword", new MarcelloSwordItem(MM_ToolTier.JUMPERITE,3,-2.4F,new FabricItemSettings().rarity(Rarity.EPIC)));
    public static final Item JUMPERITE_SHOVEL = registerItem ("jumperite_shovel", new MarcelloShovelItem(MM_ToolTier.JUMPERITE,1.5F,-3F,new FabricItemSettings().rarity(Rarity.EPIC)));
    public static final Item JUMPERITE_PICKAXE = registerItem ("jumperite_pickaxe", new MarcelloPickaxeItem(MM_ToolTier.JUMPERITE,1,-2.8F,new FabricItemSettings().rarity(Rarity.EPIC)));
    public static final Item JUMPERITE_AXE = registerItem ("jumperite_axe", new MarcelloAxeItem(MM_ToolTier.JUMPERITE,5,-3.1F,new FabricItemSettings().rarity(Rarity.EPIC)));
    public static final Item JUMPERITE_HOE = registerItem ("jumperite_hoe", new MarcelloHoeItem(MM_ToolTier.JUMPERITE,-5,0F,new FabricItemSettings().rarity(Rarity.EPIC)));

    public static final ArmorItem JUMPERITE_HELMET = (ArmorItem) registerItem("jumperite_helmet", new ArmorItem(MM_ArmorTier.JUMPERITE, ArmorItem.Type.HELMET, new FabricItemSettings().rarity(Rarity.EPIC)));
    public static final ArmorItem JUMPERITE_CHESTPLATE = (ArmorItem) registerItem("jumperite_chestplate", new ArmorItem(MM_ArmorTier.JUMPERITE, ArmorItem.Type.CHESTPLATE, new FabricItemSettings().rarity(Rarity.EPIC)));
    public static final ArmorItem JUMPERITE_LEGGINGS = (ArmorItem) registerItem("jumperite_leggings", new ArmorItem(MM_ArmorTier.JUMPERITE, ArmorItem.Type.LEGGINGS, new FabricItemSettings().rarity(Rarity.EPIC)));
    public static final ArmorItem JUMPERITE_BOOTS = (ArmorItem) registerItem("jumperite_boots", new ArmorItem(MM_ArmorTier.JUMPERITE, ArmorItem.Type.BOOTS, new FabricItemSettings().rarity(Rarity.EPIC)));

//    public static final SpawnEggItem MARCELLO_SPAWN_EGG = registerItem ("marcello_spawn_egg", new MM_SpawnEggItem(MM_EntityTypes.MARCELLO, -1037769, -12183001, new FabricItemSettings().tab(ItemGroup.TAB_MISC)));
//    public static final SpawnEggItem MOLDY_SPAWN_EGG = registerItem ("moldy_spawn_egg", new MM_SpawnEggItem(MM_EntityTypes.MOLDY, -16737793, -10079488, new FabricItemSettings().tab(ItemGroup.TAB_MISC)));

    // TODO: Replace with original, possibly commissioned music
//    public static final Item MUSIC_DISC_LR1999_RAP = registerItem("music_disc_lr1999_rap", new PlaceholderMusicDiscItem(1, MM_SoundEvents.MUSIC_DISC_LR1999_RAP, 234));
//    public static final Item MUSIC_DISC_CALL_COPS = registerItem("music_disc_call_cops", new PlaceholderMusicDiscItem(2, MM_SoundEvents.MUSIC_DISC_CALL_COPS, 117));
//    public static final Item MUSIC_DISC_STOP_CALL = registerItem("music_disc_stop_call", new PlaceholderMusicDiscItem(3, MM_SoundEvents.MUSIC_DISC_STOP_CALL, 64));
//    public static final Item MUSIC_DISC_T5_FACE = registerItem("music_disc_t5_face", new PlaceholderMusicDiscItem(4, MM_SoundEvents.MUSIC_DISC_T5_FACE, 145));
//    public static final Item MUSIC_DISC_LOKSY = registerItem("music_disc_loksy", new PlaceholderMusicDiscItem(5, MM_SoundEvents.MUSIC_DISC_LOKSY, 82));
//    public static final Item MUSIC_DISC_FOREST_FUNK = registerItem("music_disc_forest_funk", new PlaceholderMusicDiscItem(6, MM_SoundEvents.MUSIC_DISC_FOREST_FUNK, 120));

    public static final Item MARCELIUM_SIGN = registerItem("marcelium_sign", new SignItem(new FabricItemSettings().maxCount(16), MM_Blocks.MARCELIUM_SIGN, MM_Blocks.MARCELIUM_WALL_SIGN));
    public static final Item MARCELIUM_HANGING_SIGN = registerItem("marcelium_hanging_sign", new HangingSignItem(MM_Blocks.MARCELIUM_HANGING_SIGN, MM_Blocks.MARCELIUM_WALL_HANGING_SIGN, new FabricItemSettings().maxCount(16)));

    private static final ItemGroup TAB_BLOCKS = FabricItemGroup.builder()
            .icon(() -> new ItemStack(MM_Blocks.MARCELLO_BLOCK))
            .displayName(Text.translatable("itemGroup.marcellomod.blocks"))
            .entries((context, entries) -> {
                for (Item item : ALL_ITEMS)
                    if (item instanceof BlockItem)
                        entries.add(item);
            })
            .build();

    private static final ItemGroup TAB_ITEMS = FabricItemGroup.builder()
            .icon(() -> new ItemStack(PHONE))
            .displayName(Text.translatable("itemGroup.marcellomod.items"))
            .entries((context, entries) -> {
                for (Item item : AUTO_CREATIVE_ITEMS)
                    if (!(item instanceof BlockItem))
                        entries.add(item);
            })
            .build();

    public static void registerAll()
    {
        Registry.register(Registries.ITEM_GROUP, modIdentifier("blocks"), TAB_BLOCKS);
        Registry.register(Registries.ITEM_GROUP, modIdentifier("items"), TAB_ITEMS);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(content -> {
            content.addBefore(Items.STONE, MM_Blocks.MARCELIUM_LOG);
            content.addAfter(MM_Blocks.MARCELIUM_LOG, MM_Blocks.MARCELIUM_WOOD);
            content.addAfter(MM_Blocks.MARCELIUM_WOOD, MM_Blocks.STRIPPED_MARCELIUM_LOG);
            content.addAfter(MM_Blocks.STRIPPED_MARCELIUM_LOG, MM_Blocks.STRIPPED_MARCELIUM_WOOD);
            content.addAfter(MM_Blocks.STRIPPED_MARCELIUM_WOOD, MM_Blocks.MARCELIUM_PLANKS);
            content.addAfter(MM_Blocks.MARCELIUM_PLANKS, MM_Blocks.MARCELIUM_STAIRS);
            content.addAfter(MM_Blocks.MARCELIUM_STAIRS, MM_Blocks.MARCELIUM_SLAB);
            content.addAfter(MM_Blocks.MARCELIUM_SLAB, MM_Blocks.MARCELIUM_FENCE);
            content.addAfter(MM_Blocks.MARCELIUM_FENCE, MM_Blocks.MARCELIUM_FENCE_GATE);
            content.addAfter(MM_Blocks.MARCELIUM_FENCE_GATE, MM_Blocks.MARCELIUM_DOOR);
            content.addAfter(MM_Blocks.MARCELIUM_DOOR, MM_Blocks.MARCELIUM_TRAPDOOR);
            content.addAfter(MM_Blocks.MARCELIUM_TRAPDOOR, MM_Blocks.MARCELIUM_PRESSURE_PLATE);
            content.addAfter(MM_Blocks.MARCELIUM_PRESSURE_PLATE, MM_Blocks.MARCELIUM_BUTTON);
            content.addBefore(Items.COAL_BLOCK, MM_Blocks.MARCELLO_BLOCK);
            content.addAfter(MM_Blocks.MARCELLO_BLOCK, MM_Blocks.MARK_BLOCK);
            content.addAfter(Items.NETHERITE_BLOCK, MM_Blocks.JUMPERITE_BLOCK);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(content -> {
            content.addBefore(Items.CHEST, MARCELIUM_SIGN);
            content.addAfter(MARCELIUM_SIGN, MARCELIUM_HANGING_SIGN);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(content -> {
            content.addBefore(Items.COAL_ORE, MM_Blocks.MARCELLO_BLOCK);
            content.addAfter(MM_Blocks.MARCELLO_BLOCK, MM_Blocks.MARK_BLOCK);
            content.addAfter(Items.DEEPSLATE_GOLD_ORE, MM_Blocks.MARCELLO_ORE);
            content.addAfter(MM_Blocks.MARCELLO_ORE, MM_Blocks.DEEPSLATE_MARCELLO_ORE);
            content.addAfter(Items.NETHER_GOLD_ORE, MM_Blocks.NETHER_MARCELLO_ORE);
            content.addAfter(Items.ANCIENT_DEBRIS, MM_Blocks.JUMPERITE_ORE);
            content.addBefore(Items.OAK_LEAVES, MM_Blocks.MARCELIUM_LOG);
            content.addBefore(Items.OAK_SAPLING, MM_Blocks.RED_MARCELIUM_LEAVES);
            content.addAfter(MM_Blocks.RED_MARCELIUM_LEAVES, MM_Blocks.GREEN_MARCELIUM_LEAVES);
            content.addAfter(MM_Blocks.GREEN_MARCELIUM_LEAVES, MM_Blocks.YELLOW_MARCELIUM_LEAVES);
            content.addBefore(Items.SHORT_GRASS, MM_Blocks.RED_MARCELIUM_SAPLING);
            content.addAfter(MM_Blocks.RED_MARCELIUM_SAPLING, MM_Blocks.GREEN_MARCELIUM_SAPLING);
            content.addAfter(MM_Blocks.GREEN_MARCELIUM_SAPLING, MM_Blocks.YELLOW_MARCELIUM_SAPLING);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(content -> {
            content.addAfter(Items.CHORUS_FRUIT, MARCELLO_FRUIT);
            content.addAfter(MARCELLO_FRUIT, MOLDY_FRUIT);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(content -> {
            content.addAfter(Items.RAW_GOLD, MARCELLO_FRUIT);
            content.addAfter(MARCELLO_FRUIT, PHONE);
            content.addAfter(Items.ANCIENT_DEBRIS, JUMPERITE_SHARD);
            content.addAfter(Items.NETHERITE_INGOT, JUMPERITE_INGOT);
            content.addAfter(JUMPERITE_INGOT, JUMPERITE_ROD);

            content.addAfter(Items.EGG, JUMPMAN_BALL);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(content -> {
            content.addAfter(Items.GOLDEN_HOE, MARCELLO_SHOVEL);
            content.addAfter(MARCELLO_SHOVEL, MARCELLO_PICKAXE);
            content.addAfter(MARCELLO_PICKAXE, MARCELLO_AXE);
            content.addAfter(MARCELLO_AXE, MARCELLO_HOE);

            content.addAfter(Items.NETHERITE_HOE, JUMPERITE_SHOVEL);
            content.addAfter(JUMPERITE_SHOVEL, JUMPERITE_PICKAXE);
            content.addAfter(JUMPERITE_PICKAXE, JUMPERITE_AXE);
            content.addAfter(JUMPERITE_AXE, JUMPERITE_HOE);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> {
            content.addAfter(Items.GOLDEN_SWORD, MARCELLO_SWORD);
            content.addAfter(Items.GOLDEN_AXE, MARCELLO_AXE);
            content.addAfter(Items.NETHERITE_SWORD, JUMPERITE_SWORD);
            content.addAfter(Items.NETHERITE_AXE, JUMPERITE_AXE);

            content.addAfter(Items.NETHERITE_BOOTS, JUMPERITE_HELMET);
            content.addAfter(JUMPERITE_HELMET, JUMPERITE_CHESTPLATE);
            content.addAfter(JUMPERITE_CHESTPLATE, JUMPERITE_LEGGINGS);
            content.addAfter(JUMPERITE_LEGGINGS, JUMPERITE_BOOTS);

            content.addAfter(Items.EGG, JUMPMAN_BALL);
        });


    }
}