package me.luisrandomness.marcellomod.core.items;

import me.luisrandomness.marcellomod.MarcelloMod;
import net.minecraft.enchantment.IVanishable;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;
import java.util.function.Supplier;

public class PhoneItem extends Item implements IVanishable {
    private final Supplier<? extends EntityType<?>> summoningEntity;
    private final TranslationTextComponent callMessage = new TranslationTextComponent("item." + MarcelloMod.MOD_ID + ".phone.call");

    public PhoneItem(final Supplier<? extends EntityType<?>> summoningEntity, Properties properties) {
        super(properties);
        this.summoningEntity = summoningEntity::get;
    }

    @Override
    public ActionResult<ItemStack> use(World p_77659_1_, PlayerEntity p_77659_2_, Hand p_77659_3_) {
        ItemStack phone = p_77659_2_.getItemInHand(p_77659_3_);
        if (!p_77659_1_.isClientSide && getType(new CompoundNBT()) != null) {
            ServerWorld serverWorld = (ServerWorld) p_77659_1_;
            getType(new CompoundNBT()).spawn(serverWorld, new ItemStack(Items.AIR), p_77659_2_, new BlockPos(p_77659_2_.getX(),p_77659_2_.getY(),p_77659_2_.getZ()), SpawnReason.REINFORCEMENT, false, false);
            p_77659_2_.displayClientMessage(callMessage,false);
            phone.hurtAndBreak(2, p_77659_2_, (p_220044_0_) -> {
                p_77659_2_.broadcastBreakEvent(EquipmentSlotType.MAINHAND);
            });
        }
        return super.use(p_77659_1_, p_77659_2_, p_77659_3_);
    }

    public EntityType<?> getType(@Nullable final CompoundNBT p_208076_1_) {
        return summoningEntity.get();
    }
}
