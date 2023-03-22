package com.speedy.speedys_mod;

import com.speedy.speedys_mod.init.BlockInit;
import com.speedy.speedys_mod.init.ItemInit;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
//import net.minecraft.world.item.ItemStack;
//import net.minecraftforge.api.distmarker.Dist;
//import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(SpeedysMod.ID)
@Mod.EventBusSubscriber(modid = SpeedysMod.ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class SpeedysMod {
	
	public static final String ID = "speedys_mod";
	
	public SpeedysMod() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		
		ItemInit.ITEMS.register(bus);
		BlockInit.BLOCKS.register(bus);
		
		
		MinecraftForge.EVENT_BUS.register(this);
		
        // Register the item to a creative tab
        bus.addListener(this::buildContents);
	}

	@SubscribeEvent
	public void buildContents(CreativeModeTabEvent.Register event) {
        event.registerCreativeModeTab(new ResourceLocation(ID, "speedystab"), builder -> 
            builder.title(Component.translatable("itemGroup." + ID + ".speedystab"))
                .icon(() -> new ItemStack(BlockInit.FRADLITE_BLOCK.get()))
                .displayItems((enabledFlags, populator, hasPermissions) -> {
                    populator.accept(BlockInit.FRADLITE_BLOCK.get());
                    populator.accept(ItemInit.FRADLITE.get());
                    // more items here
                })
        );
    }
	

	
}

