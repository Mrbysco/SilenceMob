package com.mrbysco.silencemob;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.UseEntityCallback;

public class SilenceMob implements ModInitializer {
	@Override
	public void onInitialize() {
		UseEntityCallback.EVENT.register((player, level, hand, entity, result) ->
				SilenceHelper.interact(player, entity, player.getItemInHand(hand)));
	}
}
