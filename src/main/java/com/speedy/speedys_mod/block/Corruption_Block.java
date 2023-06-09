package com.speedy.speedys_mod.block;


import java.util.Random;

import com.speedy.speedys_mod.init.BlockInit;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;


public class Corruption_Block extends Block{
	  Random rand = new Random();

	
	
	public Corruption_Block(Properties p_49795_) {
		super(p_49795_);		
		
	}
	

	@Override
	public void randomTick(BlockState blockstate, ServerLevel level, BlockPos pos, RandomSource randSrc) {
		Direction dir = Direction.getRandom(randSrc);
		trySpread(dir, 0, blockstate, level, pos, randSrc);	
	}
	
	public void trySpread(Direction dir, int tries, BlockState blockstate, ServerLevel level, BlockPos pos, RandomSource randSrc) {
		if(tries < 7) {
			BlockPos neighbor = pos.relative(dir);
			BlockState adjacentState = level.getBlockState(neighbor);
			if(adjacentState.getBlock() != this &&
				  adjacentState.getBlock() != Blocks.AIR &&
				  adjacentState.getBlock() != Blocks.WATER &&
				  adjacentState.getBlock() != Blocks.LAVA &&
				  adjacentState.getBlock() != BlockInit.DEACTIVATED_CORRUPTION_BLOCK.get() &&
				  adjacentState.getBlock() != BlockInit.CORRUPTION_SPAWN_BLOCK.get()

				  ){
			  
				  level.setBlock(neighbor, blockstate, 3);
				  level.setBlock(pos, BlockInit.DEACTIVATED_CORRUPTION_BLOCK.get().defaultBlockState(), 3);
			}
			else if(tries < 4){
				trySpread(dir.getClockWise(Direction.Axis.Y), tries + 1, blockstate, level, pos, randSrc);
			}
			else if(tries < 5) {
				trySpread(Direction.UP, tries + 1, blockstate, level, pos, randSrc);
			}
			else {
				trySpread(Direction.DOWN, tries + 1, blockstate, level, pos, randSrc);
			}
			level.setBlock(pos, BlockInit.DEACTIVATED_CORRUPTION_BLOCK.get().defaultBlockState(), 3);

		}
	}
}
