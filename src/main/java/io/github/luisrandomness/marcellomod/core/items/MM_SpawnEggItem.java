package io.github.luisrandomness.marcellomod.core.items;

import io.github.luisrandomness.marcellomod.core.registry.MM_ItemGroup;
import net.minecraft.entity.EntityType;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.common.util.Lazy;
import net.minecraftforge.common.util.NonNullSupplier;
import net.minecraftforge.fml.RegistryObject;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.DispenserBlock;
import net.minecraft.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.entity.SpawnReason;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import java.util.Map;

// Obtained from https://raw.githubusercontent.com/Cadiboo/Example-Mod/1.15.2/src/main/java/io/github/cadiboo/examplemod/item/FixedSpawnEggItem.java

public class MM_SpawnEggItem extends SpawnEggItem {

    protected static final List<MM_SpawnEggItem> UNADDED_EGGS = new ArrayList<>();
    private final Lazy<? extends EntityType<?>> entityTypeSupplier;

    public MM_SpawnEggItem(final NonNullSupplier<? extends EntityType<?>> entityTypeSupplier, final int p_i48465_2_, final int p_i48465_3_, final Properties p_i48465_4_) {
        super(null, p_i48465_2_, p_i48465_3_, p_i48465_4_);
        this.entityTypeSupplier = Lazy.of(entityTypeSupplier::get);
        UNADDED_EGGS.add(this);
    }

    public MM_SpawnEggItem(final RegistryObject<? extends EntityType<?>> entityTypeSupplier, final int p_i48465_2_, final int p_i48465_3_, final Properties p_i48465_4_) {
        super(null, p_i48465_2_, p_i48465_3_, p_i48465_4_);
        this.entityTypeSupplier = Lazy.of(entityTypeSupplier);
        UNADDED_EGGS.add(this);
    }

    public static void initUnaddedEggs() {
        final Map<EntityType<?>, SpawnEggItem> EGGS = ObfuscationReflectionHelper.getPrivateValue(SpawnEggItem.class, null, "field_195987_b");
        DefaultDispenseItemBehavior defaultDispenseItemBehavior = new DefaultDispenseItemBehavior() {
            public ItemStack dispenseStack(IBlockSource source, ItemStack stack) {
                Direction direction = source.getBlockState().getValue(DispenserBlock.FACING);
                EntityType<?> entitytype = ((SpawnEggItem) stack.getItem()).getType(stack.getTag());
                entitytype.spawn(source.getLevel(), stack, null, source.getPos().relative(direction), SpawnReason.DISPENSER, direction != Direction.UP, false);
                stack.shrink(1);
                return stack;
            }
        };
        for (final SpawnEggItem egg : UNADDED_EGGS) {
            EGGS.put(egg.getType(null), egg);
            DispenserBlock.registerBehavior(egg, defaultDispenseItemBehavior);
            // ItemColors for each spawn egg don't need to be registered because this method is called before ItemColors is created
        }
        UNADDED_EGGS.clear();
    }

    @Override
    public EntityType<?> getType(@Nullable final CompoundNBT p_208076_1_) {
        return entityTypeSupplier.get();
    }

    @Override
    protected boolean allowdedIn(ItemGroup p_194125_1_) {
        return super.allowdedIn(p_194125_1_) || p_194125_1_ == MM_ItemGroup.TAB;
    }
}

