package com.speedy.speedys_mod.worldgen.ore;

import java.util.List;

import com.speedy.speedys_mod.SpeedysMod;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

public class SpeedyPlacedFeatures {

    public static final ResourceKey<PlacedFeature> FRADLITE_BLOCK_PLACED_KEY = createKey("fradlite_block_placed");

	
    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);
        
        register(context, FRADLITE_BLOCK_PLACED_KEY, configuredFeatures.getOrThrow(SpeedyConfiguredFeatures.OVERWORLD_FRADLITE_BLOCK_KEY),
                SpeedyOrePlacement.commonOrePlacement(16, // veins per chunk
                        HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-64), VerticalAnchor.absolute(80))));
    }
    
    
    
	
    private static ResourceKey<PlacedFeature> createKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(SpeedysMod.ID, name));
    }
    
    
    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
    			List<PlacementModifier> modifiers) {
    	context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
    
    
    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
            	PlacementModifier... modifiers) {
    	register(context, key, configuration, List.of(modifiers));
    }
    
}