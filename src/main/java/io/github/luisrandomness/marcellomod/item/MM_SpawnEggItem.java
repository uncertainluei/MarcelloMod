package io.github.luisrandomness.marcellomod.item;

import net.minecraft.core.Direction;
import net.minecraft.core.dispenser.BlockSource;
import net.minecraft.core.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.gameevent.GameEvent;
import org.jetbrains.annotations.NotNull;

public class MM_SpawnEggItem extends SpawnEggItem {

    private static final DefaultDispenseItemBehavior DISPENSER_ITEM_BEHAVIOR = new DefaultDispenseItemBehavior()
    {
        public @NotNull ItemStack execute(BlockSource blockSource, ItemStack item) {
            Direction direction = (Direction)blockSource.state().getValue(DispenserBlock.FACING);
            EntityType<?> entityType = ((SpawnEggItem)item.getItem()).getType(item);

            try {
                entityType.spawn(blockSource.level(), item, (Player)null, blockSource.pos().relative(direction), MobSpawnType.DISPENSER, direction != Direction.UP, false);
            } catch (Exception var6) {
                LOGGER.error("Error while dispensing spawn egg from dispenser at {}", blockSource.pos(), var6);
                return ItemStack.EMPTY;
            }

            item.shrink(1);
            blockSource.level().gameEvent((Entity)null, GameEvent.ENTITY_PLACE, blockSource.pos());
            return item;
        }
    };

    public MM_SpawnEggItem(EntityType<? extends Mob> defaultType, int backgroundColor, int highlightColor)
    {
        super(defaultType, backgroundColor, highlightColor, new Item.Properties());
        DispenserBlock.registerBehavior(this, DISPENSER_ITEM_BEHAVIOR);
    }
}
