package io.github.uncertainluei.mc.marcellomod.init.item;

import io.github.uncertainluei.mc.marcellomod.init.MM_EntityTypes;
import io.github.uncertainluei.mc.marcellomod.init.MM_Items;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Direction;
import net.minecraft.core.dispenser.BlockSource;
import net.minecraft.core.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.gameevent.GameEvent;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class MM_SpawnEggs {

    private static final DefaultDispenseItemBehavior DISPENSER_ITEM_BEHAVIOR = new DefaultDispenseItemBehavior()
    {
        public @NotNull ItemStack execute(BlockSource blockSource, ItemStack item) {
            Direction direction = blockSource.state().getValue(DispenserBlock.FACING);
            EntityType<?> entityType = ((SpawnEggItem)item.getItem()).getType(item);

            try {
                entityType.spawn(blockSource.level(), item, null, blockSource.pos().relative(direction), MobSpawnType.DISPENSER, direction != Direction.UP, false);
            } catch (Exception var6) {
                LOGGER.error("Error while dispensing spawn egg from dispenser at {}", blockSource.pos(), var6);
                return ItemStack.EMPTY;
            }

            item.shrink(1);
            blockSource.level().gameEvent(null, GameEvent.ENTITY_PLACE, blockSource.pos());
            return item;
        }
    };

    public static ArrayList<SpawnEggItem> ALL_SPAWN_EGGS = new ArrayList<>();
    private static SpawnEggItem registerEgg(EntityType<? extends Mob> defaultType, int backgroundColor, int highlightColor)
    {
        SpawnEggItem itm = new SpawnEggItem(defaultType, backgroundColor, highlightColor, new Item.Properties());
        MM_Items.registerItem(BuiltInRegistries.ENTITY_TYPE.getKey(defaultType).getPath() + "_spawn_egg", itm, MM_Items.MarcelloItemGroup.SPAWN_EGGS);
        DispenserBlock.registerBehavior(itm, DISPENSER_ITEM_BEHAVIOR);
        ALL_SPAWN_EGGS.add(itm);
        return itm;
    }

    public static SpawnEggItem MARCELLO = registerEgg(MM_EntityTypes.MARCELLO, -1037769, -12183001);
    public static SpawnEggItem MARK = registerEgg(MM_EntityTypes.MARK, -6286, -9625286);
    public static SpawnEggItem MOLDY = registerEgg(MM_EntityTypes.MOLDY, -16737793, -10079488);

    public static void register()
    {
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.SPAWN_EGGS).register(content -> {
            content.addAfter(Items.MAGMA_CUBE_SPAWN_EGG, MARCELLO);
            content.addAfter(MARCELLO, MARK);
            content.addBefore(Items.MOOSHROOM_SPAWN_EGG, MOLDY);
        });
    }
}
