package me.luisrandomness.marcellomod.core.registry;

import me.luisrandomness.marcellomod.MarcelloMod;
import me.luisrandomness.marcellomod.core.enchantments.MarkEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = MarcelloMod.ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MarcelloModEnchantments {
    public static final DeferredRegister<Enchantment> REGISTRY = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, MarcelloMod.ID);

    public static final RegistryObject<MarkEnchantment> MARK = REGISTRY.register("mark", () -> new MarkEnchantment(Enchantment.Rarity.VERY_RARE, EnchantmentType.WEAPON, new EquipmentSlotType[]{EquipmentSlotType.MAINHAND}));
}
