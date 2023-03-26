package com.speedy.speedys_mod.datagen;

import java.util.function.Consumer;

import javax.annotation.Nullable;

import com.speedy.speedys_mod.SpeedysMod;
import com.speedy.speedys_mod.init.BlockInit;
import com.speedy.speedys_mod.init.ItemInit;

import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

public class SpeedyRecipeProvider extends RecipeProvider implements IConditionBuilder{

	public SpeedyRecipeProvider(PackOutput output) {
		super(output);
	}

	@Override
	protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
		
		
		// 9 block packed blocks
		nineBlockStorageRecipes(consumer, RecipeCategory.MISC, ItemInit.FRADLITE.get(), RecipeCategory.BUILDING_BLOCKS, BlockInit.FRADLITE_BLOCK.get());

		// weapons
         ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ItemInit.FRADLITE_SWORD.get())
         .define('B', ItemInit.FRADLITE.get())
         .define('I', Items.STICK)
         .pattern("B")
         .pattern("B")
         .pattern("I")
         .unlockedBy("has_fradlite", inventoryTrigger(ItemPredicate.Builder.item()
                 .of(ItemInit.FRADLITE.get()).build()))
         .save(consumer);
         
         // tools
         ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ItemInit.FRADLITE_PICKAXE.get())
         .define('B', ItemInit.FRADLITE.get())
         .define('I', Items.STICK)
         .pattern("BBB")
         .pattern(" I ")
         .pattern(" I ")
         .unlockedBy("has_fradlite", inventoryTrigger(ItemPredicate.Builder.item()
                 .of(ItemInit.FRADLITE.get()).build()))
         .save(consumer);
         
         ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ItemInit.FRADLITE_AXE.get())
         .define('B', ItemInit.FRADLITE.get())
         .define('I', Items.STICK)
         .pattern("BB")
         .pattern("IB")
         .pattern("I ")
         .unlockedBy("has_fradlite", inventoryTrigger(ItemPredicate.Builder.item()
                 .of(ItemInit.FRADLITE.get()).build()))
         .save(consumer);
         
         ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ItemInit.FRADLITE_SHOVEL.get())
         .define('B', ItemInit.FRADLITE.get())
         .define('I', Items.STICK)
         .pattern("B")
         .pattern("I")
         .pattern("I")
         .unlockedBy("has_fradlite", inventoryTrigger(ItemPredicate.Builder.item()
                 .of(ItemInit.FRADLITE.get()).build()))
         .save(consumer);
         
         ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ItemInit.FRADLITE_HOE.get())
         .define('B', ItemInit.FRADLITE.get())
         .define('I', Items.STICK)
         .pattern("BB")
         .pattern("I ")
         .pattern("I ")
         .unlockedBy("has_fradlite", inventoryTrigger(ItemPredicate.Builder.item()
                 .of(ItemInit.FRADLITE.get()).build()))
         .save(consumer);
	}
	
	
	
	protected static void nineBlockStorageRecipes(Consumer<FinishedRecipe> p_249580_, RecipeCategory p_251203_, ItemLike p_251689_, RecipeCategory p_251376_, ItemLike p_248771_) {
	      nineBlockStorageRecipes(p_249580_, p_251203_, p_251689_, p_251376_, p_248771_, getSimpleRecipeName(p_248771_), (String)null, getSimpleRecipeName(p_251689_), (String)null);
	   }

	protected static void nineBlockStorageRecipes(Consumer<FinishedRecipe> p_250423_, RecipeCategory p_250083_, ItemLike p_250042_,
			RecipeCategory p_248977_, ItemLike p_251911_, String p_250475_, @Nullable String p_248641_,
			String p_252237_, @Nullable String p_250414_) {
	      ShapelessRecipeBuilder.shapeless(p_250083_, p_250042_, 9).requires(p_251911_).group(p_250414_).unlockedBy(getHasName(p_251911_), has(p_251911_))
	      .save(p_250423_, new ResourceLocation(SpeedysMod.ID, p_252237_));
	      ShapedRecipeBuilder.shaped(p_248977_, p_251911_).define('#', p_250042_).pattern("###").pattern("###").pattern("###").group(p_248641_)
	      .unlockedBy(getHasName(p_250042_), has(p_250042_)).save(p_250423_, new ResourceLocation(SpeedysMod.ID, p_250475_));
	   }
}
