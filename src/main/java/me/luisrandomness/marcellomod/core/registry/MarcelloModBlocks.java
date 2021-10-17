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

@Mod.EventBusSubscriber(modid = MarcelloMod.ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MarcelloModBlocks {
    public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, MarcelloMod.ID);

    public static final RegistryObject<MarcelloModOreBlock> MARCELLO_ORE = MarcelloModBlocks.REGISTRY.register("marcello_ore",() -> new MarcelloModOreBlock(Block.Properties.of(Material.STONE)
            .strength(2.4F)
            .harvestLevel(2)
            .harvestTool(ToolType.PICKAXE)
            .requiresCorrectToolForDrops()
    ));
    public static final RegistryObject<MarcelloModOreBlock> NETHER_MARCELLO_ORE = MarcelloModBlocks.REGISTRY.register("nether_marcello_ore",() -> new MarcelloModOreBlock(Block.Properties.of(Material.STONE)
            .strength(1.8F)
            .harvestLevel(0)
            .harvestTool(ToolType.PICKAXE)
            .requiresCorrectToolForDrops()
    ));
    public static final RegistryObject<MarcelloTypeBlock> JUMPERITE_ORE = MarcelloModBlocks.REGISTRY.register("jumperite_ore",() -> new MarcelloTypeBlock(Block.Properties.of(Material.STONE)
            .strength(8F,32F)
            .harvestLevel(3)
            .harvestTool(ToolType.PICKAXE)
            .requiresCorrectToolForDrops()
    ));

    public static final RegistryObject<MarcelloTypeBlock> MARCELLO_BLOCK = MarcelloModBlocks.REGISTRY.register("marcello_block",() -> new MarcelloTypeBlock(Block.Properties.of(Material.STONE)
            .strength(2.4F)
            .harvestLevel(2)
            .harvestTool(ToolType.PICKAXE)
            .requiresCorrectToolForDrops()
    ));
    public static final RegistryObject<MarcelloTypeBlock> MARK_BLOCK = MarcelloModBlocks.REGISTRY.register("mark_block",() -> new MarcelloTypeBlock(Block.Properties.of(Material.STONE)
            .strength(4.8F,12F)
            .harvestLevel(2)
            .harvestTool(ToolType.PICKAXE)
            .requiresCorrectToolForDrops()
    ));
}
