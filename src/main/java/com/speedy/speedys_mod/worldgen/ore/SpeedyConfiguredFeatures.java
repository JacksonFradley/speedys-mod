package com.speedy.speedys_mod.worldgen.ore;

import java.util.List;

import com.speedy.speedys_mod.SpeedysMod;
import com.speedy.speedys_mod.init.BlockInit;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

public class SpeedyConfiguredFeatures {
	public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_FRADLITE_BLOCK_KEY = registerKey("fradlite_block");
	
	public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
		RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
		RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
		
		List<OreConfiguration.TargetBlockState> overworldFradliteBlock = List.of(OreConfiguration.target(stoneReplaceables,
				BlockInit.FRADLITE_BLOCK.get().defaultBlockState()),
				OreConfiguration.target(deepslateReplaceables, BlockInit.FRADLITE_BLOCK.get().defaultBlockState()));
		
		register(context, OVERWORLD_FRADLITE_BLOCK_KEY, Feature.ORE, new OreConfiguration(overworldFradliteBlock, 9));
		
	}
	
	
	
	
	
	public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
		return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(SpeedysMod.ID, name));
	}
	
	private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
            ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
				context.register(key, new ConfiguredFeature<>(feature, configuration));
			}
	
}
