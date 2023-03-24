package com.speedy.speedys_mod.datagen;

import java.util.Set;

import java.util.List;

import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

public class SpeedyLootTableProvider {
	public static LootTableProvider create(PackOutput output) {
		return new LootTableProvider(output, Set.of(), 
				List.of(new LootTableProvider.SubProviderEntry(SpeedyBlockLootTables::new, LootContextParamSets.BLOCK)));
	}

}
