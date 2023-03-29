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
	public void randomTick(BlockState blockstate, ServerLevel level, BlockPos pos, RandomSource p_222957_) {
		// TODO Auto-generated method stub
		for(Direction dir : Direction.values()){
			
			  BlockPos neighbor = pos.relative(dir);
			  BlockState adjacentState = level.getBlockState(neighbor);
			  if(adjacentState.getBlock() != this &&
					  adjacentState.getBlock() != Blocks.AIR &&
					  adjacentState.getBlock() != Blocks.WATER &&
					  adjacentState.getBlock() != Blocks.LAVA &&
					  adjacentState.getBlock() != BlockInit.FRADLITE_BLOCK.get()){//checking if this is already our block
				  int chance = rand.nextInt(20);
				  if(chance == 19) {
					  //var fradBlock = new Fradlite_Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_PURPLE).strength(1.7f)
					  //		.sound(SoundType.AMETHYST).requiresCorrectToolForDrops());
					  level.setBlock(neighbor, BlockInit.FRADLITE_BLOCK.get().defaultBlockState(), 3);
				  }
				  else {
					  level.setBlock(neighbor, blockstate, 3);
				  }
			  }
			}
	}
}
