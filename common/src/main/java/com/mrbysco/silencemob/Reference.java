package com.mrbysco.silencemob;

import com.mojang.logging.LogUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import org.slf4j.Logger;

public class Reference {
	public static final String MOD_ID = "silencemob";
	public static final String MOD_NAME = "Silent Mob!";
	public static final Logger LOGGER = LogUtils.getLogger();

	public static final TagKey<Item> SILENCE_ITEM = TagKey.create(Registries.ITEM, modLoc("silence_item"));

	public static Identifier modLoc(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}