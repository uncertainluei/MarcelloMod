package io.github.luisrandomness.marcellomod.item;

import io.github.luisrandomness.marcellomod.MarcelloMod;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.Vanishable;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.apache.logging.log4j.core.jmx.Server;

import java.util.function.Consumer;

public class PhoneItem extends Item implements Vanishable {
    public EntityType<?> summoningEntity;
    private static final MutableText callMessage = Text.translatable("item." + MarcelloMod.MOD_NAMESPACE + ".phone.call");

    public PhoneItem(EntityType<?> summoningEntity, Settings settings) {
        super(settings);
        this.summoningEntity = summoningEntity;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack phone = user.getStackInHand(hand);
        if (!world.isClient() && world instanceof ServerWorld serverWorld && summoningEntity != null)
        {
            summoningEntity.spawn(serverWorld, user.getBlockPos(), SpawnReason.REINFORCEMENT);
            user.sendMessage(callMessage);
            phone.damage(1, user, (e) -> {
                // Mojang why isn't there a helper function to convert from hand type -> equipment slot?!?!
                e.sendEquipmentBreakStatus(hand == Hand.MAIN_HAND ? EquipmentSlot.MAINHAND : EquipmentSlot.OFFHAND);
            });
        }
        return super.use(world, user, hand);
    }
}
