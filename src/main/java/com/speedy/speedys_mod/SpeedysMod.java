package com.speedy.speedys_mod;

import com.speedy.speedys_mod.init.BlockInit;
import com.speedy.speedys_mod.init.ItemInit;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.event.CreativeModeTabEvent;
//import net.minecraft.world.item.ItemStack;
//import net.minecraftforge.api.distmarker.Dist;
//import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("speedys_mod")
public class SpeedysMod {
	
	public static final String MOD_ID = "speedys_mod";
	
//	public static final CreativeModeTab SPEEDYS_TAB = new CreativeModeTab(MOD_ID) {
//		
//		@Override
//		@OnlyIn(Dist.CLIENT)
//		public ItemStack makeIcon() {
//			// TODO Auto-generated method stub
//			return new ItemStack(ItemInit.EXAMPLE_ITEM.get());
//		}
//	};
//	
	public SpeedysMod() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		
		ItemInit.ITEMS.register(bus);
		BlockInit.BLOCKS.register(bus);
		
		MinecraftForge.EVENT_BUS.register(this);
		
        // Register the item to a creative tab
        bus.addListener(this::addCreative);
	}
	
    private void addCreative(CreativeModeTabEvent.BuildContents event)
    {
        if (event.getTab() == CreativeModeTabs.BUILDING_BLOCKS)
            event.accept(BlockInit.EXAMPLE_BLOCK);
    }

}
