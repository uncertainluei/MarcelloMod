package io.github.luisrandomness.marcellomod.init;

import com.terraformersmc.terraform.sign.block.TerraformHangingSignBlock;
import com.terraformersmc.terraform.sign.block.TerraformSignBlock;
import com.terraformersmc.terraform.sign.block.TerraformWallHangingSignBlock;
import com.terraformersmc.terraform.sign.block.TerraformWallSignBlock;
import io.github.luisrandomness.marcellomod.MarcelloMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.block.*;
import net.minecraft.data.family.BlockFamilies;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

import java.awt.*;
import java.util.HashMap;

public class MM_Blocks {

    static HashMap<Block, BlockItem> blockItems = new HashMap<>();
    public static BlockItem getBlockItem(Block block)
    {
        if (blockItems.containsKey(block)) return blockItems.get(block);

        BlockItem item = (BlockItem)MM_Items.registerItem(Registries.BLOCK.getId(block).getPath(), new BlockItem(block, new FabricItemSettings()));
        blockItems.put(block,item);
        return item;
    }

    public static Block registerBlock(String identifier, Block block)
    {
        return registerBlock(identifier,block,true);
    }
    public static Block registerBlock(String identifier, Block block, boolean includeItemForm)
    {
        Block registered = Registry.register(Registries.BLOCK, MarcelloMod.modIdentifier(identifier), block);
        if (includeItemForm)
            getBlockItem(registered);
        return registered;
    }

    public static final Block MARCELLO_BLOCK = registerBlock("marcello_block", new Block(FabricBlockSettings.copyOf(Blocks.STONE)
            .strength(2.4F).requiresTool().sounds(BlockSoundGroup.WART_BLOCK)));
    public static final Block MARK_BLOCK = registerBlock("mark_block", new Block(FabricBlockSettings.copyOf(Blocks.STONE)
            .strength(4.8F,12F).requiresTool().sounds(BlockSoundGroup.WART_BLOCK)));

    public static final ExperienceDroppingBlock MARCELLO_ORE = (ExperienceDroppingBlock) registerBlock("marcello_ore", new ExperienceDroppingBlock(UniformIntProvider.create(0, 3), FabricBlockSettings.copyOf(Blocks.LAPIS_ORE)));
    public static final ExperienceDroppingBlock DEEPSLATE_MARCELLO_ORE = (ExperienceDroppingBlock) registerBlock("deepslate_marcello_ore", new ExperienceDroppingBlock(UniformIntProvider.create(0, 3), FabricBlockSettings.copyOf(Blocks.DEEPSLATE_LAPIS_ORE)));
    public static final ExperienceDroppingBlock NETHER_MARCELLO_ORE = (ExperienceDroppingBlock) registerBlock("nether_marcello_ore", new ExperienceDroppingBlock(UniformIntProvider.create(0, 3), FabricBlockSettings.copyOf(Blocks.NETHER_QUARTZ_ORE)));

    public static final ExperienceDroppingBlock JUMPERITE_ORE = (ExperienceDroppingBlock) registerBlock("jumperite_ore", new ExperienceDroppingBlock(UniformIntProvider.create(4, 7), FabricBlockSettings.copyOf(Blocks.ANCIENT_DEBRIS)
            .strength(8F,32F).requiresTool()));
    public static final Block JUMPERITE_BLOCK = registerBlock("jumperite_block", new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)
            .strength(20F,32F).requiresTool().sounds(BlockSoundGroup.NETHERITE)));

    public static final BlockSetType BLOCKSET_MARCELIUM = new BlockSetType("marcellomod:marcelium");
    public static final WoodType WOODTYPE_MARCELIUM = new WoodType("marcellomod:marcelium",BLOCKSET_MARCELIUM);

    public static final Block MARCELIUM_LOG = registerBlock("marcelium_log", new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG)));
    public static final Block MARCELIUM_WOOD = registerBlock("marcelium_wood", new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD)));
    public static final Block STRIPPED_MARCELIUM_LOG = registerBlock("stripped_marcelium_log", new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG)));
    public static final Block STRIPPED_MARCELIUM_WOOD = registerBlock("stripped_marcelium_wood", new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD)));

    public static final Block MARCELIUM_PLANKS = registerBlock("marcelium_planks", new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)));
    public static final Block MARCELIUM_STAIRS = registerBlock("marcelium_stairs", new StairsBlock(MM_Blocks.MARCELIUM_PLANKS.getDefaultState(), FabricBlockSettings.copyOf(Blocks.OAK_STAIRS)));
    public static final Block MARCELIUM_SLAB = registerBlock("marcelium_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.OAK_SLAB)));
    public static final Block MARCELIUM_FENCE = registerBlock("marcelium_fence", new FenceBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE)));
    public static final Block MARCELIUM_FENCE_GATE = registerBlock("marcelium_fence_gate", new FenceGateBlock(WOODTYPE_MARCELIUM,FabricBlockSettings.copyOf(Blocks.OAK_FENCE_GATE)));
    public static final Block MARCELIUM_PRESSURE_PLATE = registerBlock("marcelium_pressure_plate", new PressurePlateBlock(BLOCKSET_MARCELIUM,FabricBlockSettings.copyOf(Blocks.OAK_PRESSURE_PLATE)));
    public static final Block MARCELIUM_BUTTON = registerBlock("marcelium_button", new ButtonBlock(BLOCKSET_MARCELIUM,30,FabricBlockSettings.copyOf(Blocks.OAK_BUTTON)));
    public static final Block MARCELIUM_DOOR = registerBlock("marcelium_door", new DoorBlock(BLOCKSET_MARCELIUM,FabricBlockSettings.copyOf(Blocks.OAK_DOOR)));
    public static final Block MARCELIUM_TRAPDOOR = registerBlock("marcelium_trapdoor", new TrapdoorBlock(BLOCKSET_MARCELIUM,FabricBlockSettings.copyOf(Blocks.OAK_TRAPDOOR)));

    public static final Identifier MARCELIUM_SIGN_TEXTURE = MarcelloMod.modIdentifier("entity/signs/marcelium");
    public static final Identifier MARCELIUM_HANGING_SIGN_TEXTURE = MarcelloMod.modIdentifier("entity/signs/hanging/marcelium");
    public static final Identifier MARCELIUM_HANGING_SIGN_GUI = MarcelloMod.modIdentifier("textures/gui/hanging_sign/marcelium");

    public static final Block MARCELIUM_SIGN = registerBlock("marcelium_sign", new TerraformSignBlock(MARCELIUM_SIGN_TEXTURE,FabricBlockSettings.copyOf(Blocks.OAK_SIGN)), false);
    public static final Block MARCELIUM_WALL_SIGN = registerBlock("marcelium_wall_sign", new TerraformWallSignBlock(MARCELIUM_SIGN_TEXTURE,FabricBlockSettings.copyOf(Blocks.OAK_WALL_SIGN)),false);

    public static final Block MARCELIUM_HANGING_SIGN = registerBlock("marcelium_hanging_sign", new TerraformHangingSignBlock(MARCELIUM_HANGING_SIGN_TEXTURE, MARCELIUM_HANGING_SIGN_GUI,FabricBlockSettings.copyOf(Blocks.OAK_SIGN)), false);
    public static final Block MARCELIUM_WALL_HANGING_SIGN = registerBlock("marcelium_wall_hanging_sign", new TerraformWallHangingSignBlock(MARCELIUM_HANGING_SIGN_TEXTURE, MARCELIUM_HANGING_SIGN_GUI,FabricBlockSettings.copyOf(Blocks.OAK_WALL_SIGN)),false);

    public static final Block RED_MARCELIUM_LEAVES = registerBlock("red_marcelium_leaves", new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES)));
    public static final Block GREEN_MARCELIUM_LEAVES = registerBlock("green_marcelium_leaves", new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES)));
    public static final Block YELLOW_MARCELIUM_LEAVES = registerBlock("yellow_marcelium_leaves", new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES)));
    public static final Block RED_MARCELIUM_SAPLING = registerBlock("red_marcelium_sapling", new SaplingBlock(SaplingGenerator.OAK, FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)));
    public static final Block GREEN_MARCELIUM_SAPLING = registerBlock("green_marcelium_sapling", new SaplingBlock(SaplingGenerator.OAK, FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)));
    public static final Block YELLOW_MARCELIUM_SAPLING = registerBlock("yellow_marcelium_sapling", new SaplingBlock(SaplingGenerator.OAK, FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)));
    public static final Block POTTED_RED_MARCELIUM_SAPLING = registerBlock("potted_red_marcelium_sapling", new FlowerPotBlock(RED_MARCELIUM_SAPLING, FabricBlockSettings.copyOf(Blocks.POTTED_OAK_SAPLING)), false);
    public static final Block POTTED_YELLOW_MARCELIUM_SAPLING = registerBlock("potted_yellow_marcelium_sapling", new FlowerPotBlock(YELLOW_MARCELIUM_SAPLING, FabricBlockSettings.copyOf(Blocks.POTTED_OAK_SAPLING)), false);

    public static final Block POTTED_GREEN_MARCELIUM_SAPLING = registerBlock("potted_green_marcelium_sapling", new FlowerPotBlock(GREEN_MARCELIUM_SAPLING, FabricBlockSettings.copyOf(Blocks.POTTED_OAK_SAPLING)), false);

    public static final BlockFamily FAMILY_MARCELIUM = BlockFamilies.register(MM_Blocks.MARCELIUM_PLANKS).button(MM_Blocks.MARCELIUM_BUTTON).fence(MM_Blocks.MARCELIUM_FENCE).fenceGate(MM_Blocks.MARCELIUM_FENCE_GATE).pressurePlate(MM_Blocks.MARCELIUM_PRESSURE_PLATE).slab(MM_Blocks.MARCELIUM_SLAB).stairs(MM_Blocks.MARCELIUM_STAIRS).sign(MARCELIUM_SIGN,MARCELIUM_WALL_SIGN).door(MM_Blocks.MARCELIUM_DOOR).trapdoor(MM_Blocks.MARCELIUM_TRAPDOOR).group("wooden").unlockCriterionName("has_planks").build();

    public static void registerBlockEvents()
    {
        StrippableBlockRegistry.register(MARCELIUM_LOG,STRIPPED_MARCELIUM_LOG);
        StrippableBlockRegistry.register(MARCELIUM_WOOD,STRIPPED_MARCELIUM_WOOD);
    }
}
