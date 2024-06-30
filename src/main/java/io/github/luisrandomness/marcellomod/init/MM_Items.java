package io.github.luisrandomness.marcellomod.init;

import com.terraformersmc.terraform.boat.api.TerraformBoatType;
import com.terraformersmc.terraform.boat.api.TerraformBoatTypeRegistry;
import com.terraformersmc.terraform.boat.api.item.TerraformBoatItemHelper;
import io.github.luisrandomness.marcellomod.item.*;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.*;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.effect.*;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import java.util.ArrayList;

import static io.github.luisrandomness.marcellomod.MarcelloMod.modIdentifier;

public class MM_Items {

    private static FoodProperties.Builder allMobEffects(MobEffectCategory cat, FoodProperties.Builder builder)
    {
        for (MobEffect effect : BuiltInRegistries.MOB_EFFECT)
            if (effect.getCategory() == cat)
                builder = builder.effect(new MobEffectInstance(effect, 1200, 5), 1F);
        return builder;
    }

    public static final FoodProperties FOOD_MARCELLO_FRUIT =  new FoodProperties.Builder().nutrition(3).saturationMod(0.2F)
            .effect(new MobEffectInstance(MobEffects.HUNGER,480,0), 0.75F)
            .effect(new MobEffectInstance(MobEffects.POISON,480,0),0.5F)
            .build();
    public static final FoodProperties FOOD_MOLDY_FRUIT = new FoodProperties.Builder().nutrition(6).saturationMod(0.4F)
            .effect(new MobEffectInstance(MobEffects.REGENERATION,120,0), 0.5F)
            .effect(new MobEffectInstance(MobEffects.DAMAGE_BOOST,480,0),0.25F)
            .build();

    public static final FoodProperties FOOD_MARCELLO_FRUIT_UNNERFED = allMobEffects(MobEffectCategory.HARMFUL, new FoodProperties.Builder().nutrition(1).saturationMod(0.3F)).build();
    public static final FoodProperties FOOD_MOLDY_FRUIT_UNNERFED = allMobEffects(MobEffectCategory.BENEFICIAL, new FoodProperties.Builder().nutrition(1).saturationMod(0.3F)).build();

    public static final ArrayList<Item> ALL_ITEMS = new ArrayList<>();
    private static final ArrayList<Item> AUTO_CREATIVE_ITEMS = new ArrayList<>();

    public static Item registerItem(String identifier, Item item, boolean includeInCreative)
    {
        Item result = Registry.register(BuiltInRegistries.ITEM, modIdentifier(identifier), item);
        return addToItemList(item, includeInCreative);
    }

    public static Item addToItemList(Item registeredItem, boolean includeInCreative)
    {
        ALL_ITEMS.add(registeredItem);
        if (includeInCreative)
            AUTO_CREATIVE_ITEMS.add(registeredItem);
        return registeredItem;
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
    public static final Item JUMPERITE_UPGRADE_SMITHING_TEMPLATE = registerItem("jumperite_upgrade_smithing_template", new JumperiteUpgradeTemplateItem());

    public static final Item PHONE = registerItem ("phone", new PhoneItem(MM_EntityTypes.MARCELLO, new FabricItemSettings().maxCount(1).maxDamage(8)));
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

    public static final Item JUMPERITE_BOW = registerItem("jumperite_bow", new JumperiteBowItem(MM_ToolTier.JUMPERITE, new FabricItemSettings().rarity(Rarity.EPIC)));

    public static final Item HAMMER_PENCIL = registerItem ("hammer_pencil", new Item(new FabricItemSettings().maxCount(1).maxDamage(64)));

    public static final ArmorItem JUMPERITE_HELMET = (ArmorItem) registerItem("jumperite_helmet", new ArmorItem(MM_ArmorTier.JUMPERITE, ArmorItem.Type.HELMET, new FabricItemSettings().rarity(Rarity.EPIC)));
    public static final ArmorItem JUMPERITE_CHESTPLATE = (ArmorItem) registerItem("jumperite_chestplate", new ArmorItem(MM_ArmorTier.JUMPERITE, ArmorItem.Type.CHESTPLATE, new FabricItemSettings().rarity(Rarity.EPIC)));
    public static final ArmorItem JUMPERITE_LEGGINGS = (ArmorItem) registerItem("jumperite_leggings", new ArmorItem(MM_ArmorTier.JUMPERITE, ArmorItem.Type.LEGGINGS, new FabricItemSettings().rarity(Rarity.EPIC)));
    public static final ArmorItem JUMPERITE_BOOTS = (ArmorItem) registerItem("jumperite_boots", new ArmorItem(MM_ArmorTier.JUMPERITE, ArmorItem.Type.BOOTS, new FabricItemSettings().rarity(Rarity.EPIC)));

    public static final Item MARCELLO_SPAWN_EGG = registerItem ("marcello_spawn_egg", new SpawnEggItem(MM_EntityTypes.MARCELLO, -1037769, -12183001, new FabricItemSettings()));
    public static final Item MARK_SPAWN_EGG = registerItem ("mark_spawn_egg", new SpawnEggItem(MM_EntityTypes.MARK, -6286, -9625286, new FabricItemSettings()));
    public static final Item MOLDY_SPAWN_EGG = registerItem ("moldy_spawn_egg", new SpawnEggItem(MM_EntityTypes.MOLDY, -16737793, -10079488, new FabricItemSettings()));

    // TODO: Replace with original, possibly commissioned music
//    public static final Item MUSIC_DISC_LR1999_RAP = registerItem("music_disc_lr1999_rap", new PlaceholderMusicDiscItem(1, MM_SoundEvents.MUSIC_DISC_LR1999_RAP, 234));
//    public static final Item MUSIC_DISC_CALL_COPS = registerItem("music_disc_call_cops", new PlaceholderMusicDiscItem(2, MM_SoundEvents.MUSIC_DISC_CALL_COPS, 117));
//    public static final Item MUSIC_DISC_STOP_CALL = registerItem("music_disc_stop_call", new PlaceholderMusicDiscItem(3, MM_SoundEvents.MUSIC_DISC_STOP_CALL, 64));
//    public static final Item MUSIC_DISC_T5_FACE = registerItem("music_disc_t5_face", new PlaceholderMusicDiscItem(4, MM_SoundEvents.MUSIC_DISC_T5_FACE, 145));
//    public static final Item MUSIC_DISC_LOKSY = registerItem("music_disc_loksy", new PlaceholderMusicDiscItem(5, MM_SoundEvents.MUSIC_DISC_LOKSY, 82));
//    public static final Item MUSIC_DISC_FOREST_FUNK = registerItem("music_disc_forest_funk", new PlaceholderMusicDiscItem(6, MM_SoundEvents.MUSIC_DISC_FOREST_FUNK, 120));

    public static final Item MARCELIUM_SIGN = registerItem("marcelium_sign", new SignItem(new FabricItemSettings().maxCount(16), MM_Blocks.MARCELIUM_SIGN, MM_Blocks.MARCELIUM_WALL_SIGN));
    public static final Item MARCELIUM_HANGING_SIGN = registerItem("marcelium_hanging_sign", new HangingSignItem(MM_Blocks.MARCELIUM_HANGING_SIGN, MM_Blocks.MARCELIUM_WALL_HANGING_SIGN, new FabricItemSettings().maxCount(16)));

    public static final ResourceKey<TerraformBoatType> MARCELIUM_BOAT_KEY = TerraformBoatTypeRegistry.createKey(modIdentifier("marcelium"));

    public static final Item MARCELIUM_BOAT_ITEM = addToItemList(TerraformBoatItemHelper.registerBoatItem(modIdentifier("marcelium_boat"), MARCELIUM_BOAT_KEY, false), true);
    public static final Item MARCELIUM_CHEST_BOAT_ITEM = addToItemList(TerraformBoatItemHelper.registerBoatItem(modIdentifier("marcelium_chest_boat"), MARCELIUM_BOAT_KEY, true), true);

    public static final TerraformBoatType MARCELIUM_BOAT_TYPE = new TerraformBoatType.Builder()
            .item(MARCELIUM_BOAT_ITEM)
            .chestItem(MARCELIUM_CHEST_BOAT_ITEM)
            .planks(MM_Blocks.MARCELIUM_PLANKS.asItem())
            .build();


    private static final CreativeModeTab TAB_BLOCKS = FabricItemGroup.builder()
            .icon(() -> new ItemStack(MM_Blocks.MARCELLO_BLOCK))
            .title(Component.translatable("itemGroup.marcellomod.blocks"))
            .displayItems((context, entries) -> {
                for (Item item : ALL_ITEMS)
                    if (item instanceof BlockItem)
                        entries.accept(item);
            })
            .build();

    private static final CreativeModeTab TAB_ITEMS = FabricItemGroup.builder()
            .icon(() -> new ItemStack(PHONE))
            .title(Component.translatable("itemGroup.marcellomod.items"))
            .displayItems((context, entries) -> {
                for (Item item : AUTO_CREATIVE_ITEMS)
                    if (!(item instanceof BlockItem))
                        entries.accept(item);
            })
            .build();

    public static void registerAll()
    {
        Registry.register(TerraformBoatTypeRegistry.INSTANCE, MARCELIUM_BOAT_KEY, MARCELIUM_BOAT_TYPE);

        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, modIdentifier("blocks"), TAB_BLOCKS);
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, modIdentifier("items"), TAB_ITEMS);

        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.BUILDING_BLOCKS).register(content -> {
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

        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FUNCTIONAL_BLOCKS).register(content -> {
            content.addBefore(Items.CHEST, MARCELIUM_SIGN);
            content.addAfter(MARCELIUM_SIGN, MARCELIUM_HANGING_SIGN);
        });

        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.NATURAL_BLOCKS).register(content -> {
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

        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FOOD_AND_DRINKS).register(content -> {
            content.addAfter(Items.CHORUS_FRUIT, MARCELLO_FRUIT);
            content.addAfter(MARCELLO_FRUIT, MOLDY_FRUIT);
        });

        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.INGREDIENTS).register(content -> {
            content.addAfter(Items.RAW_GOLD, MARCELLO_FRUIT);
            content.addAfter(MARCELLO_FRUIT, PHONE);
            content.addAfter(Items.ANCIENT_DEBRIS, JUMPERITE_SHARD);
            content.addAfter(Items.NETHERITE_INGOT, JUMPERITE_INGOT);
            content.addAfter(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, JUMPERITE_UPGRADE_SMITHING_TEMPLATE);

            content.addAfter(Items.EGG, JUMPMAN_BALL);
        });

        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.SPAWN_EGGS).register(content -> {
            content.addAfter(Items.MAGMA_CUBE_SPAWN_EGG, MARCELLO_SPAWN_EGG);
            content.addAfter(MARCELLO_SPAWN_EGG, MARK_SPAWN_EGG);
            content.addBefore(Items.MOOSHROOM_SPAWN_EGG, MOLDY_SPAWN_EGG);
        });

        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(content -> {
            content.addAfter(Items.GOLDEN_HOE, MARCELLO_SHOVEL);
            content.addAfter(MARCELLO_SHOVEL, MARCELLO_PICKAXE);
            content.addAfter(MARCELLO_PICKAXE, MARCELLO_AXE);
            content.addAfter(MARCELLO_AXE, MARCELLO_HOE);

            content.addAfter(Items.NETHERITE_HOE, JUMPERITE_SHOVEL);
            content.addAfter(JUMPERITE_SHOVEL, JUMPERITE_PICKAXE);
            content.addAfter(JUMPERITE_PICKAXE, JUMPERITE_AXE);
            content.addAfter(JUMPERITE_AXE, JUMPERITE_HOE);

            content.addAfter(Items.FLINT_AND_STEEL, PHONE);
            content.addAfter(PHONE, BLOCK_BUTTON);
            content.addAfter(BLOCK_BUTTON, OTHERWORLDLY_PHONE);
        });

        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.COMBAT).register(content -> {
            content.addAfter(Items.GOLDEN_SWORD, MARCELLO_SWORD);
            content.addAfter(Items.GOLDEN_AXE, MARCELLO_AXE);
            content.addAfter(Items.NETHERITE_SWORD, JUMPERITE_SWORD);
            content.addAfter(Items.NETHERITE_AXE, JUMPERITE_AXE);

            content.addAfter(Items.NETHERITE_BOOTS, JUMPERITE_HELMET);
            content.addAfter(JUMPERITE_HELMET, JUMPERITE_CHESTPLATE);
            content.addAfter(JUMPERITE_CHESTPLATE, JUMPERITE_LEGGINGS);
            content.addAfter(JUMPERITE_LEGGINGS, JUMPERITE_BOOTS);

            content.addAfter(Items.EGG, JUMPMAN_BALL);
            content.addAfter(Items.TOTEM_OF_UNDYING, BLOCK_BUTTON);

        });
    }
}