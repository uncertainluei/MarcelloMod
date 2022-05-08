package me.luisrandomness.marcellomod.core.registry;

import me.luisrandomness.marcellomod.MarcelloMod;
import me.luisrandomness.marcellomod.core.types.MM_ArmorTier;
import me.luisrandomness.marcellomod.core.types.MM_ToolTier;
import me.luisrandomness.marcellomod.core.items.*;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = MarcelloMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MM_Items {
    public static final Food FOOD_MARCELLO_FRUIT = new Food.Builder().nutrition(3).saturationMod(0.2F)
            .effect(() ->new EffectInstance(Effects.HUNGER,480,0), 0.75F)
            .effect(() ->new EffectInstance(Effects.POISON,480,0),0.5F)
            .build();
    public static final Food FOOD_MOLDY_FRUIT = new Food.Builder().nutrition(6).saturationMod(0.4F)
            .effect(() ->new EffectInstance(Effects.REGENERATION,120,0), 0.5F)
            .effect(() -> new EffectInstance(Effects.DAMAGE_BOOST,480,0),0.25F)
            .build();

    public static final Food FOOD_MARCELLO_FRUIT_UNNERFED = new Food.Builder().nutrition(1).saturationMod(0.3F)
            .effect(() ->new EffectInstance(Effects.MOVEMENT_SLOWDOWN,1200,5), 1F)
            .effect(() ->new EffectInstance(Effects.DIG_SLOWDOWN,1200,5), 1F)
            .effect(() ->new EffectInstance(Effects.CONFUSION,1200,5), 1F)
            .effect(() ->new EffectInstance(Effects.BLINDNESS,1200,5), 1F)
            .effect(() ->new EffectInstance(Effects.HUNGER,1200,5), 1F)
            .effect(() ->new EffectInstance(Effects.WEAKNESS,1200,5), 1F)
            .effect(() ->new EffectInstance(Effects.POISON,1200,5), 1F)
            .effect(() ->new EffectInstance(Effects.WITHER,1200,5), 1F)
            .effect(() ->new EffectInstance(Effects.UNLUCK,1200,5), 1F)
            .effect(() ->new EffectInstance(Effects.BAD_OMEN,1200,5), 1F)
            .effect(() ->new EffectInstance(Effects.LEVITATION,1200,5), 1F)
            .build();
    public static final Food FOOD_MOLDY_FRUIT_UNNERFED = new Food.Builder().nutrition(20).saturationMod(0.3F)
            .effect(() ->new EffectInstance(Effects.MOVEMENT_SPEED,1200,5), 1F)
            .effect(() ->new EffectInstance(Effects.DIG_SPEED,1200,5), 1F)
            .effect(() ->new EffectInstance(Effects.DAMAGE_BOOST,1200,5), 1F)
            .effect(() ->new EffectInstance(Effects.HEAL,1200,5), 1F)
            .effect(() ->new EffectInstance(Effects.JUMP,1200,5), 1F)
            .effect(() ->new EffectInstance(Effects.REGENERATION,1200,5), 1F)
            .effect(() ->new EffectInstance(Effects.DAMAGE_RESISTANCE,1200,5), 1F)
            .effect(() ->new EffectInstance(Effects.FIRE_RESISTANCE,1200,5), 1F)
            .effect(() ->new EffectInstance(Effects.WATER_BREATHING,1200,5), 1F)
            .effect(() ->new EffectInstance(Effects.INVISIBILITY,1200,5), 1F)
            .effect(() ->new EffectInstance(Effects.NIGHT_VISION,1200,5), 1F)
            .effect(() ->new EffectInstance(Effects.HEALTH_BOOST,1200,5), 1F)
            .effect(() ->new EffectInstance(Effects.ABSORPTION,1200,5), 1F)
            .effect(() ->new EffectInstance(Effects.SATURATION,1200,5), 1F)
            .effect(() ->new EffectInstance(Effects.LUCK,1200,5), 1F)
            .effect(() ->new EffectInstance(Effects.SLOW_FALLING,1200,5), 1F)
            .effect(() ->new EffectInstance(Effects.CONDUIT_POWER,1200,5), 1F)
            .effect(() ->new EffectInstance(Effects.DOLPHINS_GRACE,1200,5), 1F)
            .effect(() ->new EffectInstance(Effects.HERO_OF_THE_VILLAGE,1200,5), 1F)
            .build();

    public static final Rarity CRINGE = Rarity.create("cringe", TextFormatting.RED);

    public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, MarcelloMod.MOD_ID);

    public static final RegistryObject<BlockItem> MARCELLO_BLOCK = REGISTRY.register("marcello_block",() -> new BlockItem(MM_Blocks.MARCELLO_BLOCK.get(),new Item.Properties().stacksTo(64).tab(ItemGroup.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<BlockItem> MARK_BLOCK = REGISTRY.register("mark_block",() -> new BlockItem(MM_Blocks.MARK_BLOCK.get(),new Item.Properties().stacksTo(64).tab(ItemGroup.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<BlockItem> JUMPERITE_BLOCK = REGISTRY.register("jumperite_block",() -> new BlockItem(MM_Blocks.JUMPERITE_BLOCK.get(),new Item.Properties().stacksTo(64).tab(ItemGroup.TAB_BUILDING_BLOCKS)));

    public static final RegistryObject<BlockItem> MARCELLO_ORE = REGISTRY.register("marcello_ore",() -> new BlockItem(MM_Blocks.MARCELLO_ORE.get(),new Item.Properties().stacksTo(64).tab(ItemGroup.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<BlockItem> NETHER_MARCELLO_ORE = REGISTRY.register("nether_marcello_ore",() -> new BlockItem(MM_Blocks.NETHER_MARCELLO_ORE.get(),new Item.Properties().stacksTo(64).tab(ItemGroup.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<BlockItem> JUMPERITE_ORE = REGISTRY.register("jumperite_ore",() -> new BlockItem(MM_Blocks.JUMPERITE_ORE.get(),new Item.Properties().stacksTo(64).tab(ItemGroup.TAB_BUILDING_BLOCKS)));

    public static final RegistryObject<Item> MARCELLO_FRUIT = REGISTRY.register("marcello_fruit",() -> new Item(new Item.Properties().stacksTo(64).food(FOOD_MARCELLO_FRUIT).tab(ItemGroup.TAB_FOOD)));
    public static final RegistryObject<Item> MOLDY_FRUIT = REGISTRY.register("moldy_fruit",() -> new Item(new Item.Properties().stacksTo(64).food(FOOD_MOLDY_FRUIT).tab(ItemGroup.TAB_FOOD)));

    public static final RegistryObject<Item> JUMPERITE_SHARD = REGISTRY.register("jumperite_shard",() -> new Item(new Item.Properties().stacksTo(64).tab(ItemGroup.TAB_MISC).rarity(CRINGE)));
    public static final RegistryObject<Item> JUMPERITE_INGOT = REGISTRY.register("jumperite_ingot",() -> new Item(new Item.Properties().stacksTo(64).tab(ItemGroup.TAB_MISC).rarity(CRINGE)));
    public static final RegistryObject<Item> JUMPERITE_ROD = REGISTRY.register("jumperite_rod",() -> new Item(new Item.Properties().stacksTo(64).tab(ItemGroup.TAB_MISC).rarity(CRINGE)));

    public static final RegistryObject<PhoneItem> PHONE = REGISTRY.register("phone",() -> new PhoneItem(MM_EntityTypes.MARCELLO, new Item.Properties().stacksTo(1).defaultDurability(16).durability(16).tab(ItemGroup.TAB_TOOLS)));
    public static final RegistryObject<BlockButtonItem> BLOCK_BUTTON = REGISTRY.register("block_button",() -> new BlockButtonItem(new Item.Properties().stacksTo(8).tab(ItemGroup.TAB_TOOLS)));

    public static final RegistryObject<MarcelloSwordItem> MARCELLO_SWORD = REGISTRY.register("marcello_sword",() -> new MarcelloSwordItem(MM_ToolTier.MARCELLO,3,-2.4F,new Item.Properties().tab(ItemGroup.TAB_COMBAT)));
    public static final RegistryObject<MarcelloShovelItem> MARCELLO_SHOVEL = REGISTRY.register("marcello_shovel",() -> new MarcelloShovelItem(MM_ToolTier.MARCELLO,1.5F,-3F,new Item.Properties().tab(ItemGroup.TAB_TOOLS)));
    public static final RegistryObject<MarcelloPickaxeItem> MARCELLO_PICKAXE = REGISTRY.register("marcello_pickaxe",() -> new MarcelloPickaxeItem(MM_ToolTier.MARCELLO,1,-2.8F,new Item.Properties().tab(ItemGroup.TAB_TOOLS)));
    public static final RegistryObject<MarcelloAxeItem> MARCELLO_AXE = REGISTRY.register("marcello_axe",() -> new MarcelloAxeItem(MM_ToolTier.MARCELLO,6F,-3.1F,new Item.Properties().tab(ItemGroup.TAB_TOOLS)));
    public static final RegistryObject<MarcelloHoeItem> MARCELLO_HOE = REGISTRY.register("marcello_hoe",() -> new MarcelloHoeItem(MM_ToolTier.MARCELLO,-2,-1F,new Item.Properties().tab(ItemGroup.TAB_TOOLS)));

    public static final RegistryObject<MarcelloSwordItem> JUMPERITE_SWORD = REGISTRY.register("jumperite_sword",() -> new MarcelloSwordItem(MM_ToolTier.JUMPERITE,3,-2.4F,new Item.Properties().tab(ItemGroup.TAB_COMBAT).rarity(CRINGE)));
    public static final RegistryObject<MarcelloShovelItem> JUMPERITE_SHOVEL = REGISTRY.register("jumperite_shovel",() -> new MarcelloShovelItem(MM_ToolTier.JUMPERITE,1.5F,-3F,new Item.Properties().tab(ItemGroup.TAB_TOOLS).rarity(CRINGE)));
    public static final RegistryObject<MarcelloPickaxeItem> JUMPERITE_PICKAXE = REGISTRY.register("jumperite_pickaxe",() -> new MarcelloPickaxeItem(MM_ToolTier.JUMPERITE,1,-2.8F,new Item.Properties().tab(ItemGroup.TAB_TOOLS).rarity(CRINGE)));
    public static final RegistryObject<MarcelloAxeItem> JUMPERITE_AXE = REGISTRY.register("jumperite_axe",() -> new MarcelloAxeItem(MM_ToolTier.JUMPERITE,5F,-3.1F,new Item.Properties().tab(ItemGroup.TAB_TOOLS).rarity(CRINGE)));
    public static final RegistryObject<MarcelloHoeItem> JUMPERITE_HOE = REGISTRY.register("jumperite_hoe",() -> new MarcelloHoeItem(MM_ToolTier.JUMPERITE,-2,-1F,new Item.Properties().tab(ItemGroup.TAB_TOOLS).rarity(CRINGE)));

    public static final RegistryObject<ArmorItem> JUMPERITE_HELMET = REGISTRY.register("jumperite_helmet",() -> new ArmorItem(MM_ArmorTier.JUMPERITE, EquipmentSlotType.HEAD, new Item.Properties().tab(ItemGroup.TAB_COMBAT).rarity(CRINGE)));
    public static final RegistryObject<ArmorItem> JUMPERITE_CHESTPLATE = REGISTRY.register("jumperite_chestplate",() -> new ArmorItem(MM_ArmorTier.JUMPERITE, EquipmentSlotType.CHEST, new Item.Properties().tab(ItemGroup.TAB_COMBAT).rarity(CRINGE)));
    public static final RegistryObject<ArmorItem> JUMPERITE_LEGGINGS = REGISTRY.register("jumperite_leggings",() -> new ArmorItem(MM_ArmorTier.JUMPERITE, EquipmentSlotType.LEGS, new Item.Properties().tab(ItemGroup.TAB_COMBAT).rarity(CRINGE)));
    public static final RegistryObject<ArmorItem> JUMPERITE_BOOTS = REGISTRY.register("jumperite_boots",() -> new ArmorItem(MM_ArmorTier.JUMPERITE, EquipmentSlotType.FEET, new Item.Properties().tab(ItemGroup.TAB_COMBAT).rarity(CRINGE)));

    public static final RegistryObject<SpawnEggItem> MARCELLO_SPAWN_EGG = REGISTRY.register("marcello_spawn_egg",() -> new MM_SpawnEggItem(MM_EntityTypes.MARCELLO, -1037769, -12183001, new Item.Properties().tab(ItemGroup.TAB_MISC)));
    public static final RegistryObject<SpawnEggItem> MOLDY_SPAWN_EGG = REGISTRY.register("moldy_spawn_egg",() -> new MM_SpawnEggItem(MM_EntityTypes.MOLDY, -16737793, -10079488, new Item.Properties().tab(ItemGroup.TAB_MISC)));
}
