package fr.black.pm.item;

import fr.black.pm.PremierMod;
import fr.black.pm.item.custom.CoalCokeItem;
import fr.black.pm.item.custom.Firestone;
import fr.black.pm.item.custom.SmartBlowTorchItem;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
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


	/* TITANIUM TOOLS */
	public static final RegistryObject<Item> TITANIUM_SWORD =
			ITEMS.register("titanium_sword", () -> new SwordItem(ModTiers.TITANIUM, 5,5,
			new Item.Properties().tab(ModCreativeModeTab.PREMIER_MOD_TAB)));
	public static final RegistryObject<Item> TITANIUM_PICKAXE =
			ITEMS.register("titanium_pickaxe", () -> new PickaxeItem(ModTiers.TITANIUM, 5,5,
			new Item.Properties().tab(ModCreativeModeTab.PREMIER_MOD_TAB)));
	public static final RegistryObject<Item> TITANIUM_AXE =
			ITEMS.register("titanium_axe", () -> new AxeItem(ModTiers.TITANIUM, 5,5,
			new Item.Properties().tab(ModCreativeModeTab.PREMIER_MOD_TAB)));
	public static final RegistryObject<Item> TITANIUM_SHOVEL =
			ITEMS.register("titanium_shovel", () -> new ShovelItem(ModTiers.TITANIUM, 5,5,
			new Item.Properties().tab(ModCreativeModeTab.PREMIER_MOD_TAB)));
	public static final RegistryObject<Item> TITANIUM_HOE =
			ITEMS.register("titanium_hoe", () -> new HoeItem(ModTiers.TITANIUM, 5,5,
			new Item.Properties().tab(ModCreativeModeTab.PREMIER_MOD_TAB)));


	/* RUBY TOOLS */
	public static final RegistryObject<Item> RUBY_SWORD =
			ITEMS.register("ruby_sword", () -> new SwordItem(ModTiers.RUBY, 5,5,
					new Item.Properties().tab(ModCreativeModeTab.PREMIER_MOD_TAB)));
	public static final RegistryObject<Item> RUBY_PICKAXE =
			ITEMS.register("ruby_pickaxe", () -> new PickaxeItem(ModTiers.RUBY, 5,5,
					new Item.Properties().tab(ModCreativeModeTab.PREMIER_MOD_TAB)));
	public static final RegistryObject<Item> RUBY_AXE =
			ITEMS.register("ruby_axe", () -> new AxeItem(ModTiers.RUBY, 5,5,
					new Item.Properties().tab(ModCreativeModeTab.PREMIER_MOD_TAB)));
	public static final RegistryObject<Item> RUBY_SHOVEL =
			ITEMS.register("ruby_shovel", () -> new ShovelItem(ModTiers.RUBY, 5,5,
					new Item.Properties().tab(ModCreativeModeTab.PREMIER_MOD_TAB)));
	public static final RegistryObject<Item> RUBY_HOE =
			ITEMS.register("ruby_hoe", () -> new HoeItem(ModTiers.RUBY, 5,5,
					new Item.Properties().tab(ModCreativeModeTab.PREMIER_MOD_TAB)));

	
	
	
	public static void register(IEventBus eventBus) {
		ITEMS.register(eventBus);
	}
	
}
