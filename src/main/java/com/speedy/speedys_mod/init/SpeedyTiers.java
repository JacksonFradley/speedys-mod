package com.speedy.speedys_mod.init;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class SpeedyTiers {
	public static final ForgeTier FRADLITE = new ForgeTier(2, 1400, 1.5f, 2f, 22,
			BlockTags.NEEDS_IRON_TOOL,
			() -> Ingredient.of(ItemInit.FRADLITE.get()));
}
