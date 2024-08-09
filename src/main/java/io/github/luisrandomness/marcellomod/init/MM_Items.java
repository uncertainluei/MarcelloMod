package io.github.luisrandomness.marcellomod.init;

import com.terraformersmc.terraform.boat.api.TerraformBoatType;
import com.terraformersmc.terraform.boat.api.TerraformBoatTypeRegistry;
import com.terraformersmc.terraform.boat.api.item.TerraformBoatItemHelper;
import io.github.luisrandomness.marcellomod.item.*;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.core.dispenser.BlockSource;
import net.minecraft.core.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.core.registries.*;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.effect.*;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.gameevent.GameEvent;

import java.util.ArrayList;

import static io.github.luisrandomness.marcellomod.MarcelloMod.modIdentifier;

public class MM_Items {
    public static final FoodProperties FOOD_MARCELLO_FRUIT =  new FoodProperties.Builder().nutrition(3).saturationModifier(0.2F)
            .effect(new MobEffectInstance(MobEffects.HUNGER,480,0), 0.75F)
            .effect(new MobEffectInstance(MobEffects.POISON,480,0),0.5F)
            .build();
    public static final FoodProperties FOOD_MOLDY_FRUIT = new FoodProperties.Builder().nutrition(5).saturationModifier(0.4F)
            .effect(new MobEffectInstance(MobEffects.REGENERATION,120,0), 0.5F)
            .effect(new MobEffectInstance(MobEffects.DAMAGE_BOOST,480,0),0.25F)
            .build();

    public static final FoodProperties FOOD_MARK_FRUIT =  new FoodProperties.Builder().nutrition(6).saturationModifier(0.2F)
            .effect(new MobEffectInstance(MobEffects.CONFUSION,480,0),0.75F)
            .effect(new MobEffectInstance(MM_MobEffects.BLOCKED,480,0), 0.5F)
            .effect(new MobEffectInstance(MobEffects.POISON,240,2), 0.5F)
            .effect(new MobEffectInstance(MobEffects.WITHER,120,1), 0.1F)
            .build();

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

    public static final Item MARCELLO_FRUIT =  registerItem("marcello_fruit", new Item(new Item.Properties().food(FOOD_MARCELLO_FRUIT)));
    public static final Item MOLDY_FRUIT =  registerItem("moldy_fruit", new Item(new Item.Properties().food(FOOD_MOLDY_FRUIT)));
    public static final Item MARK_FRUIT =  registerItem("mark_fruit", new Item(new Item.Properties().food(FOOD_MARK_FRUIT)));

    public static final Item RUISIUM_SHARD = registerItem("ruisium_shard", new Item(new Item.Properties().rarity(Rarity.EPIC)));
    public static final Item RUISIUM_INGOT = registerItem("ruisium_ingot", new Item(new Item.Properties().rarity(Rarity.EPIC)));
    public static final Item RUISIUM_UPGRADE_SMITHING_TEMPLATE = registerItem("ruisium_upgrade_smithing_template", new RuisiumUpgradeTemplateItem());

    public static final Item PHONE = registerItem ("phone", new PhoneItem(MM_EntityTypes.MARCELLO, new Item.Properties().stacksTo(1).durability(8)));
    public static final Item OTHERWORLDLY_PHONE = registerItem ("otherworldly_phone", new Item(new Item.Properties().stacksTo(1).durability(64).rarity(Rarity.RARE)));
    public static final Item BLOCK_BUTTON = registerItem ("block_button", new BlockButtonItem(new Item.Properties().stacksTo(1).durability(8)));

    public static final Item MARCELLO_SWORD = registerItem ("marcello_sword", new MarcelloSwordItem(MM_ToolTier.MARCELLO, new Item.Properties().attributes(SwordItem.createAttributes(MM_ToolTier.MARCELLO, 3, -2.4F))));
    public static final Item MARCELLO_SHOVEL = registerItem ("marcello_shovel", new MarcelloShovelItem(MM_ToolTier.MARCELLO, new Item.Properties().attributes(ShovelItem.createAttributes(MM_ToolTier.MARCELLO, 1.5F, -3F))));
    public static final Item MARCELLO_PICKAXE = registerItem ("marcello_pickaxe", new MarcelloPickaxeItem(MM_ToolTier.MARCELLO, new Item.Properties().attributes(PickaxeItem.createAttributes(MM_ToolTier.MARCELLO, 1F, -2.8F))));
    public static final Item MARCELLO_AXE = registerItem ("marcello_axe", new MarcelloAxeItem(MM_ToolTier.MARCELLO, new Item.Properties().attributes(AxeItem.createAttributes(MM_ToolTier.MARCELLO, 6F, -3.1F))));
    public static final Item MARCELLO_HOE = registerItem ("marcello_hoe", new MarcelloHoeItem(MM_ToolTier.MARCELLO, new Item.Properties().attributes(HoeItem.createAttributes(MM_ToolTier.MARCELLO, -2F, -1F))));

    public static final Item RUISIUM_SWORD = registerItem ("ruisium_sword", new MarcelloSwordItem(MM_ToolTier.RUISIUM, new Item.Properties().rarity(Rarity.EPIC).attributes(SwordItem.createAttributes(MM_ToolTier.RUISIUM, 3, -2.6F))));
    public static final Item RUISIUM_SHOVEL = registerItem ("ruisium_shovel", new MarcelloShovelItem(MM_ToolTier.RUISIUM, new Item.Properties().rarity(Rarity.EPIC).attributes(ShovelItem.createAttributes(MM_ToolTier.RUISIUM, 1.5F, -3F))));
    public static final Item RUISIUM_PICKAXE = registerItem ("ruisium_pickaxe", new MarcelloPickaxeItem(MM_ToolTier.RUISIUM, new Item.Properties().rarity(Rarity.EPIC).attributes(PickaxeItem.createAttributes(MM_ToolTier.RUISIUM, 1F, -2.8F))));
    public static final Item RUISIUM_AXE = registerItem ("ruisium_axe", new MarcelloAxeItem(MM_ToolTier.RUISIUM, new Item.Properties().rarity(Rarity.EPIC).attributes(AxeItem.createAttributes(MM_ToolTier.RUISIUM, 5F, -3.1F))));
    public static final Item RUISIUM_HOE = registerItem ("ruisium_hoe", new MarcelloHoeItem(MM_ToolTier.RUISIUM, new Item.Properties().rarity(Rarity.EPIC).attributes(HoeItem.createAttributes(MM_ToolTier.RUISIUM, -5, -0F))));

    public static final Item RUISIUM_BOW = registerItem("ruisium_bow", new RuisiumBowItem(MM_ToolTier.RUISIUM, new Item.Properties().rarity(Rarity.EPIC)));

    public static final Item HAMMER_PENCIL = registerItem ("hammer_pencil", new Item(new Item.Properties().stacksTo(1).durability(64)));

    public static final ArmorItem RUISIUM_HELMET = (ArmorItem) registerItem("ruisium_helmet", new ArmorItem(MM_ArmorTiers.RUISIUM, ArmorItem.Type.HELMET, new Item.Properties().rarity(Rarity.EPIC).durability(ArmorItem.Type.HELMET.getDurability(35))));
    public static final ArmorItem RUISIUM_CHESTPLATE = (ArmorItem) registerItem("ruisium_chestplate", new ArmorItem(MM_ArmorTiers.RUISIUM, ArmorItem.Type.CHESTPLATE, new Item.Properties().rarity(Rarity.EPIC).durability(ArmorItem.Type.CHESTPLATE.getDurability(35))));
    public static final ArmorItem RUISIUM_LEGGINGS = (ArmorItem) registerItem("ruisium_leggings", new ArmorItem(MM_ArmorTiers.RUISIUM, ArmorItem.Type.LEGGINGS, new Item.Properties().rarity(Rarity.EPIC).durability(ArmorItem.Type.LEGGINGS.getDurability(35))));
    public static final ArmorItem RUISIUM_BOOTS = (ArmorItem) registerItem("ruisium_boots", new ArmorItem(MM_ArmorTiers.RUISIUM, ArmorItem.Type.BOOTS, new Item.Properties().rarity(Rarity.EPIC).durability(ArmorItem.Type.BOOTS.getDurability(35))));

    public static final Item MARCELLO_SPAWN_EGG = registerItem ("marcello_spawn_egg", new SpawnEggItem(MM_EntityTypes.MARCELLO, -1037769, -12183001, new Item.Properties()));
    public static final Item MARK_SPAWN_EGG = registerItem ("mark_spawn_egg", new SpawnEggItem(MM_EntityTypes.MARK, -6286, -9625286, new Item.Properties()));
    public static final Item MOLDY_SPAWN_EGG = registerItem ("moldy_spawn_egg", new SpawnEggItem(MM_EntityTypes.MOLDY, -16737793, -10079488, new Item.Properties()));

    public static final Item MARCELIUM_SIGN = registerItem("marcelium_sign", new SignItem(new Item.Properties().stacksTo(16), MM_Blocks.MARCELIUM_SIGN, MM_Blocks.MARCELIUM_WALL_SIGN));
    public static final Item MARCELIUM_HANGING_SIGN = registerItem("marcelium_hanging_sign", new HangingSignItem(MM_Blocks.MARCELIUM_HANGING_SIGN, MM_Blocks.MARCELIUM_WALL_HANGING_SIGN, new Item.Properties().stacksTo(16)));

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

            content.addAfter(Items.NETHERITE_BLOCK, MM_Blocks.RUISIUM_SHARD_BLOCK);
            content.addAfter(MM_Blocks.RUISIUM_SHARD_BLOCK, MM_Blocks.RUISIUM_BLOCK);
            content.addAfter(MM_Blocks.RUISIUM_BLOCK, MM_Blocks.RUISIUM_BRICKS);
            content.addAfter(MM_Blocks.RUISIUM_BRICKS, MM_Blocks.RUISIUM_BRICK_STAIRS);
            content.addAfter(MM_Blocks.RUISIUM_BRICK_STAIRS, MM_Blocks.RUISIUM_BRICK_SLAB);
            content.addAfter(MM_Blocks.RUISIUM_BRICK_SLAB, MM_Blocks.RUISIUM_BRICK_WALL);
            content.addAfter(MM_Blocks.RUISIUM_BRICK_WALL, MM_Blocks.CHISELED_RUISIUM_BRICKS);

            content.addAfter(Items.QUARTZ_BRICKS, MM_Blocks.DOOR_2_WALL);

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
            content.addAfter(Items.ANCIENT_DEBRIS, MM_Blocks.RUISIUM_ORE);
            content.addAfter(MM_Blocks.RUISIUM_ORE, MM_Blocks.END_RUISIUM_ORE);
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
            content.addAfter(MOLDY_FRUIT, MARK_FRUIT);
        });

        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.INGREDIENTS).register(content -> {
            content.addAfter(Items.RAW_GOLD, MARCELLO_FRUIT);
            content.addAfter(MARCELLO_FRUIT, PHONE);
            content.addAfter(Items.NETHERITE_INGOT, RUISIUM_SHARD);
            content.addAfter(RUISIUM_SHARD, RUISIUM_INGOT);
            content.addAfter(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, RUISIUM_UPGRADE_SMITHING_TEMPLATE);
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

            content.addAfter(Items.NETHERITE_HOE, RUISIUM_SHOVEL);
            content.addAfter(RUISIUM_SHOVEL, RUISIUM_PICKAXE);
            content.addAfter(RUISIUM_PICKAXE, RUISIUM_AXE);
            content.addAfter(RUISIUM_AXE, RUISIUM_HOE);

            content.addAfter(Items.FLINT_AND_STEEL, PHONE);
            content.addAfter(PHONE, OTHERWORLDLY_PHONE);
            content.addAfter(OTHERWORLDLY_PHONE, BLOCK_BUTTON);
            content.addAfter(BLOCK_BUTTON, HAMMER_PENCIL);

            content.addAfter(Items.BAMBOO_CHEST_RAFT, MARCELIUM_BOAT_ITEM);
            content.addAfter(MARCELIUM_BOAT_ITEM, MARCELIUM_CHEST_BOAT_ITEM);
        });

        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.COMBAT).register(content -> {
            content.addAfter(Items.GOLDEN_SWORD, MARCELLO_SWORD);
            content.addAfter(Items.GOLDEN_AXE, MARCELLO_AXE);
            content.addAfter(Items.NETHERITE_SWORD, RUISIUM_SWORD);
            content.addAfter(Items.NETHERITE_AXE, RUISIUM_AXE);

            content.addAfter(Items.NETHERITE_BOOTS, RUISIUM_HELMET);
            content.addAfter(RUISIUM_HELMET, RUISIUM_CHESTPLATE);
            content.addAfter(RUISIUM_CHESTPLATE, RUISIUM_LEGGINGS);
            content.addAfter(RUISIUM_LEGGINGS, RUISIUM_BOOTS);
            content.addAfter(Items.TOTEM_OF_UNDYING, BLOCK_BUTTON);

            content.addAfter(Items.BOW, RUISIUM_BOW);
            content.addAfter(Items.MACE, HAMMER_PENCIL);
        });

        // Spawn Egg Dispenser behavior
        DefaultDispenseItemBehavior spawnEggDispenseBehavior = new DefaultDispenseItemBehavior() {
            public ItemStack execute(BlockSource blockSource, ItemStack item) {
                Direction direction = (Direction)blockSource.state().getValue(DispenserBlock.FACING);
                EntityType<?> entityType = ((SpawnEggItem)item.getItem()).getType(item);

                try {
                    entityType.spawn(blockSource.level(), item, (Player)null, blockSource.pos().relative(direction), MobSpawnType.DISPENSER, direction != Direction.UP, false);
                } catch (Exception var6) {
                    LOGGER.error("Error while dispensing spawn egg from dispenser at {}", blockSource.pos(), var6);
                    return ItemStack.EMPTY;
                }

                item.shrink(1);
                blockSource.level().gameEvent((Entity)null, GameEvent.ENTITY_PLACE, blockSource.pos());
                return item;
            }
        };

        DispenserBlock.registerBehavior(MARCELLO_SPAWN_EGG, spawnEggDispenseBehavior);
        DispenserBlock.registerBehavior(MOLDY_SPAWN_EGG, spawnEggDispenseBehavior);
        DispenserBlock.registerBehavior(MARK_SPAWN_EGG, spawnEggDispenseBehavior);
    }
}