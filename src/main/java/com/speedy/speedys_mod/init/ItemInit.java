package com.speedy.speedys_mod.init;

import com.google.common.base.Supplier;
import com.speedy.speedys_mod.SpeedysMod;
import com.speedy.speedys_mod.item.Fradlite;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SpeedysMod.ID);
	
	public static final RegistryObject<Item> FRADLITE = register("fradlite", () -> new Fradlite(new Item.Properties()));
	
	public static final RegistryObject<Item> FRADLITE_SWORD = ITEMS.register("fradlite_sword", 
			() -> new SwordItem(SpeedyTiers.FRADLITE, 2, 2.5f,
					new Item.Properties()));
	
	public static final RegistryObject<Item> FRADLITE_PICKAXE = ITEMS.register("fradlite_pickaxe", 
			() -> new PickaxeItem(SpeedyTiers.FRADLITE, 2, 3f,
					new Item.Properties()));
	
	
	
	
	
	private static <T extends Item> RegistryObject<T> register(final String name, final Supplier<T> item){
		return ITEMS.register(name, item);
	}
}
