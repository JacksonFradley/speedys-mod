package com.speedy.speedys_mod.block;

import com.speedy.speedys_mod.init.BlockInit;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class Corruption_Spawn_Block extends Block{
	public int Range;

	public Corruption_Spawn_Block(Properties p_49795_) {
		super(p_49795_);
		Range = 10;
		
	}

	@Override
	public void onPlace(BlockState blockstate, Level level, BlockPos pos, BlockState p_60569_, boolean bool) {
		System.out.println("placed");
		for(Direction dir: Direction.values()) {
			BlockPos neighbor = pos.relative(dir);
			  BlockState adjacentState = level.getBlockState(neighbor);
			  if(adjacentState.getBlock() != this &&
					  adjacentState.getBlock() != Blocks.AIR &&
					  adjacentState.getBlock() != Blocks.WATER &&
					  adjacentState.getBlock() != Blocks.LAVA
					  ){
				  
					  level.setBlock(neighbor, BlockInit.CORRUPTION_BLOCK_BODY.get().defaultBlockState(), 3);
			  }
		}
	
	}
	
	
	
	
}
