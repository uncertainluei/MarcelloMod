package com.luisrandomness.marcellomod.core.items;

import com.luisrandomness.marcellomod.MarcelloMod;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class PhoneItem extends Item {
    private EntityType<?> summoningEntity;
    private final TranslationTextComponent callMessage = new TranslationTextComponent("item." + MarcelloMod.ID + ".phone.call");

    public PhoneItem(EntityType<?> summoningEntity, Properties properties) {
        super(properties);
        this.summoningEntity = summoningEntity;
    }

    @Override
    public ActionResult<ItemStack> use(World p_77659_1_, PlayerEntity p_77659_2_, Hand p_77659_3_) {
        ItemStack phone = p_77659_2_.getItemInHand(p_77659_3_);
        if (!p_77659_1_.isClientSide && summoningEntity != null) {
            ServerWorld serverWorld = (ServerWorld) p_77659_1_;
            summoningEntity.spawn(serverWorld, new ItemStack(Items.AIR), p_77659_2_, new BlockPos(p_77659_2_.getX(),p_77659_2_.getY(),p_77659_2_.getZ()), SpawnReason.REINFORCEMENT, false, false);
            p_77659_2_.displayClientMessage(callMessage,false);
            phone.hurtAndBreak(2, p_77659_2_, (p_220044_0_) -> {
                p_77659_2_.broadcastBreakEvent(EquipmentSlotType.MAINHAND);
            });
        }
        return super.use(p_77659_1_, p_77659_2_, p_77659_3_);
    }
}
