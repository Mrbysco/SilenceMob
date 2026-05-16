package com.mrbysco.silencemob;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class SilenceHelper {
	public static InteractionResult interact(Player player, Entity entity, ItemStack itemStack) {
		if (!itemStack.is(Reference.SILENCE_ITEM)) {
			return InteractionResult.PASS;
		}
		entity.setSilent(!entity.isSilent());
		itemStack.consume(1, player);

		//Play sound to indicate consumption
		entity.level().playSound((Entity)null, entity.getX(), entity.getY(), entity.getZ(), SoundEvents.GENERIC_EAT.value(), entity.getSoundSource(), 1.0F, 1.0F);

		//Trigger poof particle
		entity.level().broadcastEntityEvent(entity, (byte)60);

		player.swing(player.getUsedItemHand());

		return InteractionResult.SUCCESS;
	}
}
