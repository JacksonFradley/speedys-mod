package com.speedy.speedys_mod.datagen;

import java.util.Set;

import com.speedy.speedys_mod.init.BlockInit;
import com.speedy.speedys_mod.init.ItemInit;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

public class SpeedyBlockLootTables extends BlockLootSubProvider{

	public SpeedyBlockLootTables() {
		super(Set.of(), FeatureFlags.REGISTRY.allFlags());
		
	}
	

	@Override
	protected void generate() {
		//blocks that drop self
		dropSelf(BlockInit.FRADLITE_BLOCK.get());
		
		//ores
		add(BlockInit.FRADLITE_ORE.get(),
			(block) -> createOreDrop(BlockInit.FRADLITE_ORE.get(), ItemInit.FRADLITE.get()));
		add(BlockInit.DEEPSLATE_FRADLITE_ORE.get(),
				(block) -> createOreDrop(BlockInit.DEEPSLATE_FRADLITE_ORE.get(), ItemInit.FRADLITE.get()));
		
		
	}
	
	
	@Override
	protected Iterable<Block> getKnownBlocks() {
		return BlockInit.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
	}
}
