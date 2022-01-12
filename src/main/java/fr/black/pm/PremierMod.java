package fr.black.pm;

import fr.black.pm.block.ModBlocks;
import fr.black.pm.enchantment.ModEnchantment;
import fr.black.pm.item.ModItems;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(PremierMod.MOD_ID)

public class PremierMod 
{
	public static final String MOD_ID = "pm";
	
	
	public PremierMod()
	{
		IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
		
		ModItems.register(eventBus);
		ModBlocks.register(eventBus);
		ModEnchantment.register(eventBus);
		eventBus.addListener(this::setup);
		
		
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	
	private void setup(final FMLCommonSetupEvent event) 
	{
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.TITANIUM_DOOR.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.TITANIUM_TRAPDOOR.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.TOMATO_PLANT.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.PEPPER_PLANT.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.ORCHID.get(), RenderType.cutout());
	}
	
	
}
