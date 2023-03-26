package com.speedy.speedys_mod.init;

import com.google.common.base.Supplier;
import com.speedy.speedys_mod.SpeedysMod;
import com.speedy.speedys_mod.item.Fradlite;

import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SpeedysMod.ID);
	
	public static final RegistryObject<Item> FRADLITE = register("fradlite", () -> new Fradlite(new Item.Properties()));
	
	public static final RegistryObject<Item> FRADLITE_SWORD = ITEMS.register("fradlite_sword", 
			() -> new SwordItem(SpeedyTiers.FRADLITE, 3, -2.4f,
					new Item.Properties()));
	
	public static final RegistryObject<Item> FRADLITE_PICKAXE = ITEMS.register("fradlite_pickaxe", 
			() -> new PickaxeItem(SpeedyTiers.FRADLITE, 1, -2.8f,
					new Item.Properties()));
	
	public static final RegistryObject<Item> FRADLITE_AXE = ITEMS.register("fradlite_axe", 
			() -> new AxeItem(SpeedyTiers.FRADLITE, 4.0f, -3f,
					new Item.Properties()));
	
	public static final RegistryObject<Item> FRADLITE_SHOVEL = ITEMS.register("fradlite_shovel", 
			() -> new ShovelItem(SpeedyTiers.FRADLITE, 0, -3f,
					new Item.Properties()));
	
	public static final RegistryObject<Item> FRADLITE_HOE = ITEMS.register("fradlite_hoe", 
			() -> new HoeItem(SpeedyTiers.FRADLITE, -3, 0f,
					new Item.Properties()));

	
	
	
	
	
	private static <T extends Item> RegistryObject<T> register(final String name, final Supplier<T> item){
		return ITEMS.register(name, item);
	}
}
