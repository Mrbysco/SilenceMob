package com.mrbysco.silencemob;

import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

@Mod(Reference.MOD_ID)
public class SilenceMob {

	public SilenceMob() {
		NeoForge.EVENT_BUS.addListener(this::interactEvent);
	}

	private void interactEvent(PlayerInteractEvent.EntityInteract event) {
		if (event.getTarget() instanceof LivingEntity livingEntity && !livingEntity.level().isClientSide()) {
			final Player player = event.getEntity();
			InteractionResult result = SilenceHelper.interact(player, livingEntity, event.getItemStack());
			if (result != InteractionResult.PASS) {
				event.setCancellationResult(result);
				event.setCanceled(true);
			}
		}
	}
}