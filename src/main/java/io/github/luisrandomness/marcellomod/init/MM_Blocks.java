package io.github.luisrandomness.marcellomod.init;

import com.terraformersmc.terraform.sign.api.block.TerraformHangingSignBlock;
import com.terraformersmc.terraform.sign.api.block.TerraformSignBlock;
import com.terraformersmc.terraform.sign.api.block.TerraformWallHangingSignBlock;
import com.terraformersmc.terraform.sign.api.block.TerraformWallSignBlock;
import io.github.luisrandomness.marcellomod.MarcelloMod;
import io.github.luisrandomness.marcellomod.world.MM_ConfiguredFeatures;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;

import java.util.HashMap;
import java.util.Optional;

public class MM_Blocks {

    static HashMap<Block, BlockItem> blockItems = new HashMap<>();
    public static BlockItem getBlockItem(Block block)
    {
        if (blockItems.containsKey(block)) return blockItems.get(block);

        BlockItem item = (BlockItem)MM_Items.registerItem(BuiltInRegistries.BLOCK.getKey(block).getPath(), new BlockItem(block, new Item.Properties()));
        blockItems.put(block,item);
        return item;
    }

    public static Block registerBlock(String identifier, Block block)
    {
        return registerBlock(identifier,block,true);
    }
    public static Block registerBlock(String identifier, Block block, boolean includeItemForm)
    {
        Block registered = Registry.register(BuiltInRegistries.BLOCK, MarcelloMod.modIdentifier(identifier), block);
        if (includeItemForm)
            getBlockItem(registered);
        return registered;
    }

    public static final Block MARCELLO_BLOCK = registerBlock("marcello_block", new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
            .strength(2.4F).requiresCorrectToolForDrops().sound(SoundType.WART_BLOCK)));
    public static final Block MARK_BLOCK = registerBlock("mark_block", new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
            .strength(4.8F,12F).requiresCorrectToolForDrops().sound(SoundType.WART_BLOCK)));

    public static final DropExperienceBlock MARCELLO_ORE = (DropExperienceBlock) registerBlock("marcello_ore", new DropExperienceBlock(UniformInt.of(0, 3), BlockBehaviour.Properties.ofFullCopy(Blocks.LAPIS_ORE)));
    public static final DropExperienceBlock DEEPSLATE_MARCELLO_ORE = (DropExperienceBlock) registerBlock("deepslate_marcello_ore", new DropExperienceBlock(UniformInt.of(0, 3), BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_LAPIS_ORE)));
    public static final DropExperienceBlock NETHER_MARCELLO_ORE = (DropExperienceBlock) registerBlock("nether_marcello_ore", new DropExperienceBlock(UniformInt.of(0, 3), BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_QUARTZ_ORE)));

    public static final DropExperienceBlock RUISIUM_ORE = (DropExperienceBlock) registerBlock("ruisium_ore", new DropExperienceBlock(UniformInt.of(4, 7), BlockBehaviour.Properties.ofFullCopy(Blocks.ANCIENT_DEBRIS)
            .strength(8F,32F).requiresCorrectToolForDrops()));
    public static final DropExperienceBlock END_RUISIUM_ORE = (DropExperienceBlock) registerBlock("end_ruisium_ore", new DropExperienceBlock(UniformInt.of(4, 7), BlockBehaviour.Properties.ofFullCopy(Blocks.ANCIENT_DEBRIS)
            .strength(8F,32F).requiresCorrectToolForDrops()));

    public static final Block RUISIUM_SHARD_BLOCK = registerBlock("ruisium_shard_block", new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_IRON_BLOCK)
            .strength(12F,32F).requiresCorrectToolForDrops().sound(SoundType.ANCIENT_DEBRIS)));

    public static final Block RUISIUM_BRICKS = registerBlock("ruisium_bricks", new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS)
            .strength(12F,32F).requiresCorrectToolForDrops().sound(SoundType.ANCIENT_DEBRIS)));
    public static final Block RUISIUM_BRICK_SLAB = registerBlock("ruisium_brick_slab", new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_SLAB)
            .strength(12F,32F).requiresCorrectToolForDrops().sound(SoundType.ANCIENT_DEBRIS)));
    public static final Block RUISIUM_BRICK_STAIRS = registerBlock("ruisium_brick_stairs", new StairBlock(RUISIUM_BRICKS.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_STAIRS)
            .strength(12F,32F).requiresCorrectToolForDrops().sound(SoundType.ANCIENT_DEBRIS)));
    public static final Block RUISIUM_BRICK_WALL = registerBlock("ruisium_brick_wall", new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL)
            .strength(12F,32F).requiresCorrectToolForDrops().sound(SoundType.ANCIENT_DEBRIS)));

    public static final Block CHISELED_RUISIUM_BRICKS = registerBlock("chiseled_ruisium_bricks", new Block(BlockBehaviour.Properties.ofFullCopy(MM_Blocks.RUISIUM_SHARD_BLOCK)));

    public static final Block RUISIUM_BLOCK = registerBlock("ruisium_block", new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)
            .strength(20F,32F).requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK)));

    public static final BlockSetType BLOCKSET_MARCELIUM = new BlockSetType("marcellomod:marcelium");
    public static final WoodType WOODTYPE_MARCELIUM = new WoodType("marcellomod:marcelium",BLOCKSET_MARCELIUM);

    public static final Block MARCELIUM_LOG = registerBlock("marcelium_log", new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));
    public static final Block MARCELIUM_WOOD = registerBlock("marcelium_wood", new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)));
    public static final Block STRIPPED_MARCELIUM_LOG = registerBlock("stripped_marcelium_log", new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG)));
    public static final Block STRIPPED_MARCELIUM_WOOD = registerBlock("stripped_marcelium_wood", new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final Block MARCELIUM_PLANKS = registerBlock("marcelium_planks", new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final Block MARCELIUM_STAIRS = registerBlock("marcelium_stairs", new StairBlock(MM_Blocks.MARCELIUM_PLANKS.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS)));
    public static final Block MARCELIUM_SLAB = registerBlock("marcelium_slab", new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB)));
    public static final Block MARCELIUM_FENCE = registerBlock("marcelium_fence", new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE)));
    public static final Block MARCELIUM_FENCE_GATE = registerBlock("marcelium_fence_gate", new FenceGateBlock(WOODTYPE_MARCELIUM,BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE)));
    public static final Block MARCELIUM_PRESSURE_PLATE = registerBlock("marcelium_pressure_plate", new PressurePlateBlock(BLOCKSET_MARCELIUM,BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE)));
    public static final Block MARCELIUM_BUTTON = registerBlock("marcelium_button", new ButtonBlock(BLOCKSET_MARCELIUM,30,BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON)));
    public static final Block MARCELIUM_DOOR = registerBlock("marcelium_door", new DoorBlock(BLOCKSET_MARCELIUM,BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR)));
    public static final Block MARCELIUM_TRAPDOOR = registerBlock("marcelium_trapdoor", new TrapDoorBlock(BLOCKSET_MARCELIUM,BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR)));

    public static final ResourceLocation MARCELIUM_SIGN_TEXTURE = MarcelloMod.modIdentifier("entity/signs/marcelium");
    public static final ResourceLocation MARCELIUM_HANGING_SIGN_TEXTURE = MarcelloMod.modIdentifier("entity/signs/hanging/marcelium");
    public static final ResourceLocation MARCELIUM_HANGING_SIGN_GUI = MarcelloMod.modIdentifier("textures/gui/hanging_sign/marcelium");

    public static final Block MARCELIUM_SIGN = registerBlock("marcelium_sign", new TerraformSignBlock(MARCELIUM_SIGN_TEXTURE,BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN)), false);
    public static final Block MARCELIUM_WALL_SIGN = registerBlock("marcelium_wall_sign", new TerraformWallSignBlock(MARCELIUM_SIGN_TEXTURE,BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN)),false);

    public static final Block MARCELIUM_HANGING_SIGN = registerBlock("marcelium_hanging_sign", new TerraformHangingSignBlock(MARCELIUM_HANGING_SIGN_TEXTURE, MARCELIUM_HANGING_SIGN_GUI,BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN)), false);
    public static final Block MARCELIUM_WALL_HANGING_SIGN = registerBlock("marcelium_wall_hanging_sign", new TerraformWallHangingSignBlock(MARCELIUM_HANGING_SIGN_TEXTURE, MARCELIUM_HANGING_SIGN_GUI,BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN)),false);

    public static final Block RED_MARCELIUM_LEAVES = registerBlock("red_marcelium_leaves", new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final Block GREEN_MARCELIUM_LEAVES = registerBlock("green_marcelium_leaves", new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final Block YELLOW_MARCELIUM_LEAVES = registerBlock("yellow_marcelium_leaves", new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));

    public static final TreeGrower TREE_MARCELIUM_RED = new TreeGrower("marcellomod:marcelium_red", Optional.empty(), Optional.of(MM_ConfiguredFeatures.MARCELIUM_RED), Optional.empty());
    public static final TreeGrower TREE_MARCELIUM_GREEN = new TreeGrower("marcellomod:marcelium_green", Optional.empty(), Optional.of(MM_ConfiguredFeatures.MARCELIUM_GREEN), Optional.empty());
    public static final TreeGrower TREE_MARCELIUM_YELLOW = new TreeGrower("marcellomod:marcelium_yellow", Optional.empty(), Optional.of(MM_ConfiguredFeatures.MARCELIUM_YELLOW), Optional.empty());

    public static final Block RED_MARCELIUM_SAPLING = registerBlock("red_marcelium_sapling", new SaplingBlock(TREE_MARCELIUM_RED, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final Block GREEN_MARCELIUM_SAPLING = registerBlock("green_marcelium_sapling", new SaplingBlock(TREE_MARCELIUM_GREEN, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final Block YELLOW_MARCELIUM_SAPLING = registerBlock("yellow_marcelium_sapling", new SaplingBlock(TREE_MARCELIUM_YELLOW, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final Block POTTED_RED_MARCELIUM_SAPLING = registerBlock("potted_red_marcelium_sapling", new FlowerPotBlock(RED_MARCELIUM_SAPLING, BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_OAK_SAPLING)), false);
    public static final Block POTTED_YELLOW_MARCELIUM_SAPLING = registerBlock("potted_yellow_marcelium_sapling", new FlowerPotBlock(YELLOW_MARCELIUM_SAPLING, BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_OAK_SAPLING)), false);
    public static final Block POTTED_GREEN_MARCELIUM_SAPLING = registerBlock("potted_green_marcelium_sapling", new FlowerPotBlock(GREEN_MARCELIUM_SAPLING, BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_OAK_SAPLING)), false);

    public static final BlockSetType BLOCKSET_QUARTZ_BRICKS = new BlockSetType("marcellomod:quartz_bricks");

    public static final Block DOOR_2_WALL = registerBlock("door_2_wall", new DoorBlock(BLOCKSET_QUARTZ_BRICKS,BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_DOOR).strength(0.8F).mapColor(MapColor.QUARTZ).instrument(NoteBlockInstrument.BASEDRUM)));

    public static final BlockFamily FAMILY_MARCELIUM = BlockFamilies.familyBuilder(MARCELIUM_PLANKS)
            .button(MARCELIUM_BUTTON)
            .fence(MARCELIUM_FENCE)
            .fenceGate(MARCELIUM_FENCE_GATE)
            .pressurePlate(MARCELIUM_PRESSURE_PLATE)
            .slab(MARCELIUM_SLAB)
            .stairs(MARCELIUM_STAIRS)
            .sign(MARCELIUM_SIGN,MARCELIUM_WALL_SIGN)
            .door(MARCELIUM_DOOR)
            .trapdoor(MARCELIUM_TRAPDOOR)
            .recipeGroupPrefix("wooden").recipeUnlockedBy("has_planks").getFamily();
    public static final BlockFamily FAMILY_RUISIUM_BRICK = BlockFamilies.familyBuilder(RUISIUM_BRICKS)
            .slab(RUISIUM_BRICK_SLAB)
            .stairs(RUISIUM_BRICK_STAIRS)
            .wall(RUISIUM_BRICK_WALL)
            .recipeUnlockedBy("has_ruisium_shard").getFamily();

    public static void registerBlockEvents()
    {
        StrippableBlockRegistry.register(MARCELIUM_LOG,STRIPPED_MARCELIUM_LOG);
        StrippableBlockRegistry.register(MARCELIUM_WOOD,STRIPPED_MARCELIUM_WOOD);

        FlammableBlockRegistry flammables = FlammableBlockRegistry.getDefaultInstance();
        flammables.add(MM_Tags.BLOCK_MARCELIUM_LOGS, 6, 3);
        flammables.add(MARCELIUM_PLANKS, 6, 3);
        flammables.add(MARCELIUM_SLAB, 6, 3);
        flammables.add(MARCELIUM_STAIRS, 6, 3);
        flammables.add(MARCELIUM_FENCE, 6, 3);
        flammables.add(MARCELIUM_FENCE_GATE, 6, 3);
        flammables.add(MARCELIUM_FENCE_GATE, 6, 3);

        flammables.add(MM_Tags.BLOCK_MARCELIUM_LEAVES, 9, 6);
    }
}
