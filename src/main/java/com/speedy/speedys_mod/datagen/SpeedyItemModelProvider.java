package com.speedy.speedys_mod.datagen;

import com.speedy.speedys_mod.SpeedysMod;
import com.speedy.speedys_mod.init.ItemInit;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class SpeedyItemModelProvider extends ItemModelProvider{

	public SpeedyItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
		super(output, SpeedysMod.ID, existingFileHelper);
		
	}

	@Override
	protected void registerModels() {
		simpleItem(ItemInit.FRADLITE);
		handheldItem(ItemInit.FRADLITE_SWORD);
		handheldItem(ItemInit.FRADLITE_PICKAXE);
		handheldItem(ItemInit.FRADLITE_AXE);
		handheldItem(ItemInit.FRADLITE_SHOVEL);
		handheldItem(ItemInit.FRADLITE_HOE);
		
	}
	
	//helpers \/
	
	//simple Item examples: stick, iron ingot, ...
	private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(SpeedysMod.ID,"item/" + item.getId().getPath()));
    }

	//handheld Item examples: sword, pickaxe
    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(SpeedysMod.ID,"item/" + item.getId().getPath()));
    }
	
}
