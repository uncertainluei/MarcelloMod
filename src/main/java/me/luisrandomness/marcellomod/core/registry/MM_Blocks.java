package me.luisrandomness.marcellomod.core.registry;

import me.luisrandomness.marcellomod.MarcelloMod;
import me.luisrandomness.marcellomod.core.blocks.*;
import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = MarcelloMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MM_Blocks {
    public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, MarcelloMod.MOD_ID);

    public static final RegistryObject<MarcelloTypeBlock> MARCELLO_BLOCK = MM_Blocks.REGISTRY.register("marcello_block",() -> new MarcelloTypeBlock(Block.Properties.of(Material.STONE)
            .strength(2.4F)
            .harvestLevel(2)
            .harvestTool(ToolType.PICKAXE)
            .requiresCorrectToolForDrops()
            .sound(SoundType.WART_BLOCK)
    ));
    public static final RegistryObject<MarcelloTypeBlock> MARK_BLOCK = MM_Blocks.REGISTRY.register("mark_block",() -> new MarcelloTypeBlock(Block.Properties.of(Material.STONE)
            .strength(4.8F,12F)
            .harvestLevel(2)
            .harvestTool(ToolType.PICKAXE)
            .requiresCorrectToolForDrops()
            .sound(SoundType.WART_BLOCK)
    ));
    public static final RegistryObject<Block> JUMPERITE_BLOCK = MM_Blocks.REGISTRY.register("jumperite_block",() -> new Block(Block.Properties.of(Material.HEAVY_METAL)
            .strength(20F,32F)
            .harvestLevel(3)
            .harvestTool(ToolType.PICKAXE)
            .requiresCorrectToolForDrops()
            .sound(SoundType.NETHERITE_BLOCK)
    ));

    public static final RegistryObject<MM_OreBlock> MARCELLO_ORE = MM_Blocks.REGISTRY.register("marcello_ore",() -> new MM_OreBlock(Block.Properties.of(Material.STONE)
            .strength(2.4F)
            .harvestLevel(2)
            .harvestTool(ToolType.PICKAXE)
            .requiresCorrectToolForDrops()
    ));
    public static final RegistryObject<MM_OreBlock> NETHER_MARCELLO_ORE = MM_Blocks.REGISTRY.register("nether_marcello_ore",() -> new MM_OreBlock(Block.Properties.of(Material.STONE)
            .strength(1.8F)
            .harvestLevel(0)
            .harvestTool(ToolType.PICKAXE)
            .requiresCorrectToolForDrops()
            .sound(SoundType.NETHER_ORE)
    ));
    public static final RegistryObject<MarcelloTypeBlock> JUMPERITE_ORE = MM_Blocks.REGISTRY.register("jumperite_ore",() -> new MarcelloTypeBlock(Block.Properties.of(Material.STONE)
            .strength(8F,32F)
            .harvestLevel(3)
            .harvestTool(ToolType.PICKAXE)
            .requiresCorrectToolForDrops()
            .sound(SoundType.ANCIENT_DEBRIS)
    ));
}
