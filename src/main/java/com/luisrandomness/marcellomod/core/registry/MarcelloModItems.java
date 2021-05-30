package com.luisrandomness.marcellomod.core.registry;

import com.luisrandomness.marcellomod.MarcelloMod;
import com.luisrandomness.marcellomod.core.types.MarcelloModArmorTier;
import com.luisrandomness.marcellomod.core.types.MarcelloModToolTier;
import com.luisrandomness.marcellomod.core.items.*;
import net.minecraft.entity.EntityType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = MarcelloMod.ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MarcelloModItems {
    public static final Food FOOD_MARCELLO_FRUIT = new Food.Builder().nutrition(3).saturationMod(0.2F)
            .effect(new EffectInstance(Effects.HUNGER,480,0), 0.75F)
            .effect(new EffectInstance(Effects.POISON,480,0),0.5F)
            .build();
    public static final Food FOOD_MOLDY_FRUIT = new Food.Builder().nutrition(6).saturationMod(0.4F)
            .effect(new EffectInstance(Effects.REGENERATION,120,0), 0.5F)
            .effect(new EffectInstance(Effects.DAMAGE_BOOST,480,0),0.25F)
            .build();

    public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, MarcelloMod.ID);

    public static final RegistryObject<BlockItem> MARCELLO_BLOCK = REGISTRY.register("marcello_block",() -> new BlockItem(MarcelloModBlocks.MARCELLO_BLOCK.get(),new Item.Properties().stacksTo(64).tab(MarcelloModItemGroups.MAIN)));
    public static final RegistryObject<BlockItem> MARK_BLOCK = REGISTRY.register("mark_block",() -> new BlockItem(MarcelloModBlocks.MARK_BLOCK.get(),new Item.Properties().stacksTo(64).tab(MarcelloModItemGroups.MAIN)));

    public static final RegistryObject<BlockItem> MARCELLO_ORE = REGISTRY.register("marcello_ore",() -> new BlockItem(MarcelloModBlocks.MARCELLO_ORE.get(),new Item.Properties().stacksTo(64).tab(MarcelloModItemGroups.MAIN)));
    public static final RegistryObject<BlockItem> NETHER_MARCELLO_ORE = REGISTRY.register("nether_marcello_ore",() -> new BlockItem(MarcelloModBlocks.NETHER_MARCELLO_ORE.get(),new Item.Properties().stacksTo(64).tab(MarcelloModItemGroups.MAIN)));
    public static final RegistryObject<BlockItem> JUMPERITE_ORE = REGISTRY.register("jumperite_ore",() -> new BlockItem(MarcelloModBlocks.JUMPERITE_ORE.get(),new Item.Properties().stacksTo(64).tab(MarcelloModItemGroups.MAIN)));

    public static final RegistryObject<Item> MARCELLO_FRUIT = REGISTRY.register("marcello_fruit",() -> new Item(new Item.Properties().stacksTo(64).food(FOOD_MARCELLO_FRUIT).tab(MarcelloModItemGroups.MAIN)));
    public static final RegistryObject<Item> MOLDY_FRUIT = REGISTRY.register("moldy_fruit",() -> new Item(new Item.Properties().stacksTo(64).food(FOOD_MOLDY_FRUIT).tab(MarcelloModItemGroups.MAIN)));

    public static final RegistryObject<Item> JUMPERITE_SHARD = REGISTRY.register("jumperite_shard",() -> new Item(new Item.Properties().stacksTo(64).tab(MarcelloModItemGroups.MAIN)));
    public static final RegistryObject<Item> JUMPERITE_INGOT = REGISTRY.register("jumperite_ingot",() -> new Item(new Item.Properties().stacksTo(64).tab(MarcelloModItemGroups.MAIN)));
    public static final RegistryObject<Item> JUMPERITE_ROD = REGISTRY.register("jumperite_rod",() -> new Item(new Item.Properties().stacksTo(64).tab(MarcelloModItemGroups.MAIN)));

    public static final RegistryObject<PhoneItem> PHONE = REGISTRY.register("phone",() -> new PhoneItem(EntityType.ZOMBIE, new Item.Properties().stacksTo(1).defaultDurability(16).durability(16).tab(MarcelloModItemGroups.MAIN)));

    public static final RegistryObject<MarcelloSwordItem> MARCELLO_SWORD = REGISTRY.register("marcello_sword",() -> new MarcelloSwordItem(MarcelloModToolTier.MARCELLO,3,-2.4F,new Item.Properties().tab(MarcelloModItemGroups.MAIN)));
    public static final RegistryObject<MarcelloShovelItem> MARCELLO_SHOVEL = REGISTRY.register("marcello_shovel",() -> new MarcelloShovelItem(MarcelloModToolTier.MARCELLO,1.5F,-3F,new Item.Properties().tab(MarcelloModItemGroups.MAIN)));
    public static final RegistryObject<MarcelloPickaxeItem> MARCELLO_PICKAXE = REGISTRY.register("marcello_pickaxe",() -> new MarcelloPickaxeItem(MarcelloModToolTier.MARCELLO,1,-2.8F,new Item.Properties().tab(MarcelloModItemGroups.MAIN)));
    public static final RegistryObject<MarcelloAxeItem> MARCELLO_AXE = REGISTRY.register("marcello_axe",() -> new MarcelloAxeItem(MarcelloModToolTier.MARCELLO,6F,-3.1F,new Item.Properties().tab(MarcelloModItemGroups.MAIN)));
    public static final RegistryObject<MarcelloHoeItem> MARCELLO_HOE = REGISTRY.register("marcello_hoe",() -> new MarcelloHoeItem(MarcelloModToolTier.MARCELLO,-2,-1F,new Item.Properties().tab(MarcelloModItemGroups.MAIN)));

    public static final RegistryObject<MarcelloSwordItem> JUMPERITE_SWORD = REGISTRY.register("jumperite_sword",() -> new MarcelloSwordItem(MarcelloModToolTier.JUMPERITE,3,-2.4F,new Item.Properties().tab(MarcelloModItemGroups.MAIN)));
    public static final RegistryObject<MarcelloShovelItem> JUMPERITE_SHOVEL = REGISTRY.register("jumperite_shovel",() -> new MarcelloShovelItem(MarcelloModToolTier.JUMPERITE,1.5F,-3F,new Item.Properties().tab(MarcelloModItemGroups.MAIN)));
    public static final RegistryObject<MarcelloPickaxeItem> JUMPERITE_PICKAXE = REGISTRY.register("jumperite_pickaxe",() -> new MarcelloPickaxeItem(MarcelloModToolTier.JUMPERITE,1,-2.8F,new Item.Properties().tab(MarcelloModItemGroups.MAIN)));
    public static final RegistryObject<MarcelloAxeItem> JUMPERITE_AXE = REGISTRY.register("jumperite_axe",() -> new MarcelloAxeItem(MarcelloModToolTier.JUMPERITE,5F,-3.1F,new Item.Properties().tab(MarcelloModItemGroups.MAIN)));
    public static final RegistryObject<MarcelloHoeItem> JUMPERITE_HOE = REGISTRY.register("jumperite_hoe",() -> new MarcelloHoeItem(MarcelloModToolTier.JUMPERITE,-2,-1F,new Item.Properties().tab(MarcelloModItemGroups.MAIN)));

    public static final RegistryObject<ArmorItem> JUMPERITE_HELMET = REGISTRY.register("jumperite_helmet",() -> new ArmorItem(MarcelloModArmorTier.JUMPERITE, EquipmentSlotType.HEAD, new Item.Properties().tab(MarcelloModItemGroups.MAIN)));
    public static final RegistryObject<ArmorItem> JUMPERITE_CHESTPLATE = REGISTRY.register("jumperite_chestplate",() -> new ArmorItem(MarcelloModArmorTier.JUMPERITE, EquipmentSlotType.CHEST, new Item.Properties().tab(MarcelloModItemGroups.MAIN)));
    public static final RegistryObject<ArmorItem> JUMPERITE_LEGGINGS = REGISTRY.register("jumperite_leggings",() -> new ArmorItem(MarcelloModArmorTier.JUMPERITE, EquipmentSlotType.LEGS, new Item.Properties().tab(MarcelloModItemGroups.MAIN)));
    public static final RegistryObject<ArmorItem> JUMPERITE_BOOTS = REGISTRY.register("jumperite_boots",() -> new ArmorItem(MarcelloModArmorTier.JUMPERITE, EquipmentSlotType.FEET, new Item.Properties().tab(MarcelloModItemGroups.MAIN)));

    public static final RegistryObject<SpawnEggItem> MARCELLO_SPAWN_EGG = REGISTRY.register("marcello_spawn_egg",() -> new SpawnEggItem(MarcelloModEntityTypes.MARCELLO.get(), -1037769, -12183001, new Item.Properties().tab(MarcelloModItemGroups.MAIN)));
}
