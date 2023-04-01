package com.speedy.speedys_mod.datagen;

import com.speedy.speedys_mod.SpeedysMod;
import com.speedy.speedys_mod.init.BlockInit;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class SpeedyBlockStateProvider extends BlockStateProvider{
	public SpeedyBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
		super(output, SpeedysMod.ID, exFileHelper);
		
	}

	@Override
	protected void registerStatesAndModels() {
		blockWithItem(BlockInit.FRADLITE_BLOCK);
		blockWithItem(BlockInit.FRADLITE_ORE);
		blockWithItem(BlockInit.DEEPSLATE_FRADLITE_ORE);
		blockWithItem(BlockInit.CORRUPTION_BLOCK);	
		blockWithItem(BlockInit.CORRUPTION_SPAWN_BLOCK);
		blockWithItem(BlockInit.DEACTIVATED_CORRUPTION_BLOCK);	
		blockWithItem(BlockInit.CORRUPTION_BLOCK_BODY);	
		blockWithItem(BlockInit.SURFACE_CORRUPTION_BLOCK);	




	}
	
	private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

}
