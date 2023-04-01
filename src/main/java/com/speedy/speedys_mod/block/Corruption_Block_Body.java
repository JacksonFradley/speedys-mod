package com.speedy.speedys_mod.block;

import com.speedy.speedys_mod.init.BlockInit;
import java.lang.Math;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class Corruption_Block_Body extends Block{
	
	public BlockPos origin;
	
	public Corruption_Block_Body(Properties p_49795_) {
		super(p_49795_);
	}

	@Override
	public void onPlace(BlockState blockstate, Level level, BlockPos pos, BlockState p_60569_, boolean p_60570_) {

		for(Direction dir: Direction.values()) {
			BlockPos neighbor = pos.relative(dir);
			if(level.getBlockState(neighbor) == BlockInit.CORRUPTION_SPAWN_BLOCK.get().defaultBlockState()) {
				origin = neighbor;
			}
			else if(level.getBlockState(neighbor) == BlockInit.CORRUPTION_BLOCK_BODY.get().defaultBlockState()) {
				if(((Corruption_Block_Body)level.getBlockState(neighbor).getBlock()).getOrigin() != null) {
					origin = ((Corruption_Block_Body)level.getBlockState(neighbor).getBlock()).getOrigin();
				}
			}
		}
	
	}
	
	
	
	
	@Override
	public void randomTick(BlockState blockstate, ServerLevel level, BlockPos pos, RandomSource randSrc) {
		Direction dir = Direction.getRandom(randSrc);
		BlockPos neighbor = pos.relative(dir);
		BlockState adjacentState = level.getBlockState(neighbor);
		boolean canPlace = checkPlace(level, neighbor);
		if(adjacentState.getBlock() != this &&
			  adjacentState.getBlock() != Blocks.AIR &&
			  adjacentState.getBlock() != Blocks.WATER &&
			  adjacentState.getBlock() != Blocks.LAVA &&
			  adjacentState.getBlock() != BlockInit.DEACTIVATED_CORRUPTION_BLOCK.get() &&
			  adjacentState.getBlock() != BlockInit.CORRUPTION_SPAWN_BLOCK.get() &&
			  canPlace
			  ){
		  
			  level.setBlock(neighbor, blockstate, 3);
		}
	}
	
	public boolean checkPlace(ServerLevel level, BlockPos pos) {
		if(origin != null) {
			Double xDiff = Math.abs(1.0 *(pos.getX() - origin.getX()));
			Double yDiff = Math.abs(1.0 *(pos.getY() - origin.getY()));
			Double zDiff = Math.abs(1.0 *(pos.getZ() - origin.getZ()));
			Double xzHypot = Math.sqrt((xDiff * xDiff) + (zDiff * zDiff));
			Double Distance = Math.sqrt((yDiff * yDiff) + (xzHypot * xzHypot));
			if(Distance <= ((Corruption_Spawn_Block)level.getBlockState(origin).getBlock()).Range) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
	
	public BlockPos getOrigin() {
		return origin;
	}
	
}
