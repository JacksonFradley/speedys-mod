package com.speedy.speedys_mod.init;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class SpeedyTiers {
	//variables:
	// level, uses, speed, attack damage bonus, enchantment value
	public static final ForgeTier FRADLITE = new ForgeTier(3, 200, 4f, 4f, 22,
			BlockTags.NEEDS_IRON_TOOL,
			() -> Ingredient.of(ItemInit.FRADLITE.get()));
}
