package me.luisrandomness.marcellomod.core.registry;

import me.luisrandomness.marcellomod.MarcelloMod;
import me.luisrandomness.marcellomod.core.types.MarcelloModArmorTier;
import me.luisrandomness.marcellomod.core.types.MarcelloModToolTier;
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

@Mod.EventBusSubscriber(modid = MarcelloMod.ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MarcelloModItems {
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

    public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, MarcelloMod.ID);

    public static final RegistryObject<BlockItem> MARCELLO_BLOCK = REGISTRY.register("marcello_block",() -> new BlockItem(MarcelloModBlocks.MARCELLO_BLOCK.get(),new Item.Properties().stacksTo(64).tab(ItemGroup.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<BlockItem> MARK_BLOCK = REGISTRY.register("mark_block",() -> new BlockItem(MarcelloModBlocks.MARK_BLOCK.get(),new Item.Properties().stacksTo(64).tab(ItemGroup.TAB_BUILDING_BLOCKS)));

    public static final RegistryObject<BlockItem> MARCELLO_ORE = REGISTRY.register("marcello_ore",() -> new BlockItem(MarcelloModBlocks.MARCELLO_ORE.get(),new Item.Properties().stacksTo(64).tab(ItemGroup.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<BlockItem> NETHER_MARCELLO_ORE = REGISTRY.register("nether_marcello_ore",() -> new BlockItem(MarcelloModBlocks.NETHER_MARCELLO_ORE.get(),new Item.Properties().stacksTo(64).tab(ItemGroup.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<BlockItem> JUMPERITE_ORE = REGISTRY.register("jumperite_ore",() -> new BlockItem(MarcelloModBlocks.JUMPERITE_ORE.get(),new Item.Properties().stacksTo(64).tab(ItemGroup.TAB_BUILDING_BLOCKS)));

    public static final RegistryObject<Item> MARCELLO_FRUIT = REGISTRY.register("marcello_fruit",() -> new MM_Item(new Item.Properties().stacksTo(64).food(FOOD_MARCELLO_FRUIT).tab(ItemGroup.TAB_FOOD)));
    public static final RegistryObject<Item> MOLDY_FRUIT = REGISTRY.register("moldy_fruit",() -> new MM_Item(new Item.Properties().stacksTo(64).food(FOOD_MOLDY_FRUIT).tab(ItemGroup.TAB_FOOD)));

    public static final RegistryObject<Item> JUMPERITE_SHARD = REGISTRY.register("jumperite_shard",() -> new MM_Item(new Item.Properties().stacksTo(64).tab(ItemGroup.TAB_MISC).rarity(CRINGE)));
    public static final RegistryObject<Item> JUMPERITE_INGOT = REGISTRY.register("jumperite_ingot",() -> new MM_Item(new Item.Properties().stacksTo(64).tab(ItemGroup.TAB_MISC).rarity(CRINGE)));
    public static final RegistryObject<Item> JUMPERITE_ROD = REGISTRY.register("jumperite_rod",() -> new MM_Item(new Item.Properties().stacksTo(64).tab(ItemGroup.TAB_MISC).rarity(CRINGE)));

    public static final RegistryObject<PhoneItem> PHONE = REGISTRY.register("phone",() -> new PhoneItem(MarcelloModEntityTypes.MARCELLO, new Item.Properties().stacksTo(1).defaultDurability(16).durability(16).tab(ItemGroup.TAB_TOOLS)));

    public static final RegistryObject<MarcelloSwordItem> MARCELLO_SWORD = REGISTRY.register("marcello_sword",() -> new MarcelloSwordItem(MarcelloModToolTier.MARCELLO,3,-2.4F,new Item.Properties().tab(ItemGroup.TAB_COMBAT)));
    public static final RegistryObject<MarcelloShovelItem> MARCELLO_SHOVEL = REGISTRY.register("marcello_shovel",() -> new MarcelloShovelItem(MarcelloModToolTier.MARCELLO,1.5F,-3F,new Item.Properties().tab(ItemGroup.TAB_TOOLS)));
    public static final RegistryObject<MarcelloPickaxeItem> MARCELLO_PICKAXE = REGISTRY.register("marcello_pickaxe",() -> new MarcelloPickaxeItem(MarcelloModToolTier.MARCELLO,1,-2.8F,new Item.Properties().tab(ItemGroup.TAB_TOOLS)));
    public static final RegistryObject<MarcelloAxeItem> MARCELLO_AXE = REGISTRY.register("marcello_axe",() -> new MarcelloAxeItem(MarcelloModToolTier.MARCELLO,6F,-3.1F,new Item.Properties().tab(ItemGroup.TAB_TOOLS)));
    public static final RegistryObject<MarcelloHoeItem> MARCELLO_HOE = REGISTRY.register("marcello_hoe",() -> new MarcelloHoeItem(MarcelloModToolTier.MARCELLO,-2,-1F,new Item.Properties().tab(ItemGroup.TAB_TOOLS)));

    public static final RegistryObject<MarcelloSwordItem> JUMPERITE_SWORD = REGISTRY.register("jumperite_sword",() -> new MarcelloSwordItem(MarcelloModToolTier.JUMPERITE,3,-2.4F,new Item.Properties().tab(ItemGroup.TAB_COMBAT).rarity(CRINGE)));
    public static final RegistryObject<MarcelloShovelItem> JUMPERITE_SHOVEL = REGISTRY.register("jumperite_shovel",() -> new MarcelloShovelItem(MarcelloModToolTier.JUMPERITE,1.5F,-3F,new Item.Properties().tab(ItemGroup.TAB_TOOLS).rarity(CRINGE)));
    public static final RegistryObject<MarcelloPickaxeItem> JUMPERITE_PICKAXE = REGISTRY.register("jumperite_pickaxe",() -> new MarcelloPickaxeItem(MarcelloModToolTier.JUMPERITE,1,-2.8F,new Item.Properties().tab(ItemGroup.TAB_TOOLS).rarity(CRINGE)));
    public static final RegistryObject<MarcelloAxeItem> JUMPERITE_AXE = REGISTRY.register("jumperite_axe",() -> new MarcelloAxeItem(MarcelloModToolTier.JUMPERITE,5F,-3.1F,new Item.Properties().tab(ItemGroup.TAB_TOOLS).rarity(CRINGE)));
    public static final RegistryObject<MarcelloHoeItem> JUMPERITE_HOE = REGISTRY.register("jumperite_hoe",() -> new MarcelloHoeItem(MarcelloModToolTier.JUMPERITE,-2,-1F,new Item.Properties().tab(ItemGroup.TAB_TOOLS).rarity(CRINGE)));

    public static final RegistryObject<ArmorItem> JUMPERITE_HELMET = REGISTRY.register("jumperite_helmet",() -> new MM_ArmorItem(MarcelloModArmorTier.JUMPERITE, EquipmentSlotType.HEAD, new Item.Properties().tab(ItemGroup.TAB_COMBAT).rarity(CRINGE)));
    public static final RegistryObject<ArmorItem> JUMPERITE_CHESTPLATE = REGISTRY.register("jumperite_chestplate",() -> new MM_ArmorItem(MarcelloModArmorTier.JUMPERITE, EquipmentSlotType.CHEST, new Item.Properties().tab(ItemGroup.TAB_COMBAT).rarity(CRINGE)));
    public static final RegistryObject<ArmorItem> JUMPERITE_LEGGINGS = REGISTRY.register("jumperite_leggings",() -> new MM_ArmorItem(MarcelloModArmorTier.JUMPERITE, EquipmentSlotType.LEGS, new Item.Properties().tab(ItemGroup.TAB_COMBAT).rarity(CRINGE)));
    public static final RegistryObject<ArmorItem> JUMPERITE_BOOTS = REGISTRY.register("jumperite_boots",() -> new MM_ArmorItem(MarcelloModArmorTier.JUMPERITE, EquipmentSlotType.FEET, new Item.Properties().tab(ItemGroup.TAB_COMBAT).rarity(CRINGE)));

    public static final RegistryObject<MM_SpawnEggItem> MARCELLO_SPAWN_EGG = REGISTRY.register("marcello_spawn_egg",() -> new MM_SpawnEggItem(MarcelloModEntityTypes.MARCELLO, -1037769, -12183001, new Item.Properties().tab(ItemGroup.TAB_MISC)));
    public static final RegistryObject<MM_SpawnEggItem> MOLDY_SPAWN_EGG = REGISTRY.register("moldy_spawn_egg",() -> new MM_SpawnEggItem(MarcelloModEntityTypes.MOLDY, -16737793, -10079488, new Item.Properties().tab(ItemGroup.TAB_MISC)));
}
