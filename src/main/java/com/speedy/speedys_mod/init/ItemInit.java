package com.speedy.speedys_mod.init;

import com.google.common.base.Supplier;
import com.speedy.speedys_mod.SpeedysMod;
import com.speedy.speedys_mod.item.Fradlite;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SpeedysMod.ID);
	
	public static final RegistryObject<Item> FRADLITE = register("fradlite", () -> new Fradlite(new Item.Properties()));
	
	private static <T extends Item> RegistryObject<T> register(final String name, final Supplier<T> item){
		return ITEMS.register(name, item);
	}
}