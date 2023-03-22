package com.speedy.speedys_mod.init;

import java.util.function.Function;

import com.google.common.base.Supplier;
import com.speedy.speedys_mod.SpeedysMod;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockInit {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, SpeedysMod.ID);
	public static final DeferredRegister<Item> ITEMS = ItemInit.ITEMS;
	
	public static final RegistryObject<Block> FRADLITE_BLOCK = register("fradlite_block",
			() -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_PURPLE).strength(1.7f)
					.sound(SoundType.AMETHYST).requiresCorrectToolForDrops())
			, object -> () -> new BlockItem(object.get(), new Item.Properties()));
	
	public static final RegistryObject<Block> FRADLITE_ORE = register("fradlite_ore",
			() -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(2.0f).requiresCorrectToolForDrops())
			, object -> () -> new BlockItem(object.get(), new Item.Properties()));
	
	private static <T extends Block> RegistryObject<T> registerBlock(final String name, final Supplier<? extends T> block){
		return BLOCKS.register(name, block);
	}
	
	private static <T extends Block> RegistryObject<T> register(final String name, final Supplier<? extends T> block,
			Function<RegistryObject<T>, Supplier<? extends Item>> item){
		RegistryObject<T> obj = registerBlock(name, block);
		ITEMS.register(name, item.apply(obj));
		return obj;
	}
	
}
