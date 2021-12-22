package fr.black.pm.item;

import fr.black.pm.PremierMod;
import fr.black.pm.item.custom.CoalCokeItem;
import fr.black.pm.item.custom.Firestone;
import fr.black.pm.item.custom.SmartBlowTorchItem;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


public class ModItems 
{

	public static final DeferredRegister<Item> ITEMS = 
			DeferredRegister.create(ForgeRegistries.ITEMS, PremierMod.MOD_ID);
	
	public static final RegistryObject<Item> TITANIUM_INGOT = 
			ITEMS.register("titanium_ingot", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.PREMIER_MOD_TAB)));
	
	public static final RegistryObject<Item> TITANIUM_NUGGET = 
			ITEMS.register("titanium_nugget", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.PREMIER_MOD_TAB)));
	
	public static final RegistryObject<Item> RAW_TITANIUM = 
			ITEMS.register("raw_titanium", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.PREMIER_MOD_TAB)));
	
	public static final RegistryObject<Item> RUBY = 
			ITEMS.register("ruby", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.PREMIER_MOD_TAB)));
	
	public static final RegistryObject<Item> TOMATO = 
			ITEMS.register("tomato", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.PREMIER_MOD_TAB)
					.food(new FoodProperties.Builder().nutrition(2).saturationMod(.2f).build())));
	
	public static final RegistryObject<Item> SMART_BLOW_TORCH = 
			ITEMS.register("smart_blow_torch", () -> new SmartBlowTorchItem(new Item.Properties().tab(ModCreativeModeTab.PREMIER_MOD_TAB)
					.durability(500)));
	
	public static final RegistryObject<Item> FIRESTONE = 
			ITEMS.register("firestone", () -> new Firestone(new Item.Properties().tab(ModCreativeModeTab.PREMIER_MOD_TAB)
					.durability(30)));
	
	public static final RegistryObject<Item> COAL_COKE = 
			ITEMS.register("coal_coke", () -> new CoalCokeItem(new Item.Properties().tab(ModCreativeModeTab.PREMIER_MOD_TAB)));
	
	
	
	public static void register(IEventBus eventBus) {
		ITEMS.register(eventBus);
	}
	
}
