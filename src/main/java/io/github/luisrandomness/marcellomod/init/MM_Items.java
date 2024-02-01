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
import net.minecraft.text.Text;
import net.minecraft.util.Rarity;

import java.util.ArrayList;

import static io.github.luisrandomness.marcellomod.MarcelloMod.modIdentifier;

public class MM_Items {

    public static final FoodComponent FOOD_MARCELLO_FRUIT =  new FoodComponent.Builder().hunger(3).saturationModifier(0.2F)
            .statusEffect(new StatusEffectInstance(StatusEffects.HUNGER,480,0), 0.75F)
            .statusEffect(new StatusEffectInstance(StatusEffects.POISON,480,0),0.5F)
            .build();
    public static final FoodComponent FOOD_MOLDY_FRUIT = new FoodComponent.Builder().hunger(6).saturationModifier(0.4F)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION,120,0), 0.5F)
            .statusEffect(new StatusEffectInstance(StatusEffects.STRENGTH,480,0),0.25F)
            .build();

    public static final FoodComponent FOOD_MARCELLO_FRUIT_UNNERFED = new FoodComponent.Builder().hunger(1).saturationModifier(0.3F)
            .statusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS,1200,5), 1F)
            .statusEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE,1200,5), 1F)
            .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA,1200,5), 1F)
            .statusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS,1200,5), 1F)
            .statusEffect(new StatusEffectInstance(StatusEffects.DARKNESS,1200,5), 1F)
            .statusEffect(new StatusEffectInstance(StatusEffects.HUNGER,1200,5), 1F)
            .statusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS,1200,5), 1F)
            .statusEffect(new StatusEffectInstance(StatusEffects.POISON,1200,5), 1F)
            .statusEffect(new StatusEffectInstance(StatusEffects.WITHER,1200,5), 1F)
            .statusEffect(new StatusEffectInstance(StatusEffects.UNLUCK,1200,5), 1F)
            .statusEffect(new StatusEffectInstance(StatusEffects.BAD_OMEN,1200,5), 1F)
            .statusEffect(new StatusEffectInstance(StatusEffects.LEVITATION,1200,5), 1F)
            .statusEffect(new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE,1200,5), 1F)
            .build();
    public static final FoodComponent FOOD_MOLDY_FRUIT_UNNERFED = new FoodComponent.Builder().hunger(20).saturationModifier(0.3F)
            .statusEffect(new StatusEffectInstance(StatusEffects.SPEED,1200,5), 1F)
            .statusEffect(new StatusEffectInstance(StatusEffects.HASTE,1200,5), 1F)
            .statusEffect(new StatusEffectInstance(StatusEffects.STRENGTH,1200,5), 1F)
            .statusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH,1200,5), 1F)
            .statusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST,1200,5), 1F)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION,1200,5), 1F)
            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE,1200,5), 1F)
            .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE,1200,5), 1F)
            .statusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING,1200,5), 1F)
            .statusEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY,1200,5), 1F)
            .statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION,1200,5), 1F)
            .statusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST,1200,5), 1F)
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION,1200,5), 1F)
            .statusEffect(new StatusEffectInstance(StatusEffects.SATURATION,1200,5), 1F)
            .statusEffect(new StatusEffectInstance(StatusEffects.LUCK,1200,5), 1F)
            .statusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING,1200,5), 1F)
            .statusEffect(new StatusEffectInstance(StatusEffects.CONDUIT_POWER,1200,5), 1F)
            .statusEffect(new StatusEffectInstance(StatusEffects.DOLPHINS_GRACE,1200,5), 1F)
            .statusEffect(new StatusEffectInstance(StatusEffects.HERO_OF_THE_VILLAGE,1200,5), 1F)
            .build();

    private static final ArrayList<Item> ALL_ITEMS = new ArrayList<>();
    public static Item registerItem(String identifier, Item item)
    {
        Item result = Registry.register(Registries.ITEM, modIdentifier(identifier), item);
        ALL_ITEMS.add(result);
        return result;
    }
    public static final Item MARCELLO_FRUIT =  registerItem("marcello_fruit", new Item(new FabricItemSettings().food(FOOD_MARCELLO_FRUIT)));
    public static final Item MOLDY_FRUIT =  registerItem("moldy_fruit", new Item(new FabricItemSettings().food(FOOD_MOLDY_FRUIT)));
    public static final Item JUMPMAN_BALL =  registerItem("jumpman_ball", new SnowballItem(new FabricItemSettings().maxCount(16)));
    public static final Item JUMPERITE_SHARD = registerItem("jumperite_shard", new Item(new FabricItemSettings().rarity(Rarity.EPIC)));
    public static final Item JUMPERITE_INGOT = registerItem("jumperite_ingot", new Item(new FabricItemSettings().rarity(Rarity.EPIC)));
    public static final Item JUMPERITE_ROD = registerItem("jumperite_rod", new Item(new FabricItemSettings().rarity(Rarity.EPIC)));

    public static final Item PHONE = registerItem ("phone", new PhoneItem(EntityType.CREEPER, new FabricItemSettings().maxCount(1).maxDamage(8)));
//  public static final BlockButtonItem BLOCK_BUTTON = registerItem ("block_button", new BlockButtonItem(new FabricItemSettings().stacksTo(8)));
//
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
                for (Item item : ALL_ITEMS)
                    if (!(item instanceof BlockItem))
                        entries.add(item);
            })
            .build();

    public static void registerAll()
    {
        Registry.register(Registries.ITEM_GROUP, modIdentifier("blocks"), TAB_BLOCKS);
        Registry.register(Registries.ITEM_GROUP, modIdentifier("items"), TAB_ITEMS);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(content -> {
            content.addAfter(Items.NETHERITE_BLOCK, MM_Blocks.JUMPERITE_BLOCK);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(content -> {
            content.addBefore(Items.COAL_ORE, MM_Blocks.MARCELLO_BLOCK);
            content.addAfter(MM_Blocks.MARCELLO_BLOCK, MM_Blocks.MARK_BLOCK);
            content.addAfter(Items.DEEPSLATE_GOLD_ORE, MM_Blocks.MARCELLO_ORE);
            content.addAfter(MM_Blocks.MARCELLO_ORE, MM_Blocks.DEEPSLATE_MARCELLO_ORE);
            content.addAfter(Items.NETHER_GOLD_ORE, MM_Blocks.NETHER_MARCELLO_ORE);
            content.addAfter(Items.ANCIENT_DEBRIS, MM_Blocks.JUMPERITE_ORE);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(content -> {
            content.addAfter(Items.CHORUS_FRUIT, MARCELLO_FRUIT);
            content.addAfter(MARCELLO_FRUIT, MOLDY_FRUIT);
            content.addAfter(Items.CLOCK, PHONE);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(content -> {
            content.addAfter(Items.RAW_GOLD, MARCELLO_FRUIT);
            content.addAfter(MARCELLO_FRUIT, PHONE);
            content.addAfter(Items.ANCIENT_DEBRIS, JUMPERITE_SHARD);
            content.addAfter(Items.NETHERITE_INGOT, JUMPERITE_INGOT);
            content.addAfter(JUMPERITE_INGOT, JUMPERITE_ROD);
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
        });


    }
}