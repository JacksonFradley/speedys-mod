package com.speedy.speedys_mod.datagen;

import com.speedy.speedys_mod.SpeedysMod;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SpeedysMod.ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
	@SubscribeEvent
	public static void gatherData(GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		PackOutput packOutput = generator.getPackOutput();
		ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
		
		generator.addProvider(true, new SpeedyRecipeProvider(packOutput));
		generator.addProvider(true,  SpeedyLootTableProvider.create(packOutput));
		generator.addProvider(true, new SpeedyBlockStateProvider(packOutput, existingFileHelper));
		generator.addProvider(true, new SpeedyItemModelProvider(packOutput, existingFileHelper));

	}
	
}
