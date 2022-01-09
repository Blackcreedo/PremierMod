package fr.black.pm.block;

import fr.black.pm.PremierMod;
import fr.black.pm.block.custom.*;
import fr.black.pm.item.ModCreativeModeTab;
import fr.black.pm.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModBlocks{

	public static final DeferredRegister<Block> BLOCKS =
			DeferredRegister.create(ForgeRegistries.BLOCKS, PremierMod.MOD_ID);
	
	public static final RegistryObject<Block> TITANIUM_BLOCK = 
			registerBlock("titanium_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(10f).requiresCorrectToolForDrops()));
	
	public static final RegistryObject<Block> TITANIUM_STAIRS =
			registerBlock("titanium_stairs", () -> new StairBlock(() -> TITANIUM_BLOCK.get().defaultBlockState(), 
					BlockBehaviour.Properties.of(Material.METAL).strength(10f).requiresCorrectToolForDrops()));
	
	public static final RegistryObject<Block> TITANIUM_SLAB = 
			registerBlock("titanium_slab", () -> new SlabBlock(BlockBehaviour.Properties.of(Material.METAL).strength(10f).requiresCorrectToolForDrops()));
	
	public static final RegistryObject<Block> TITANIUM_WALL = 
			registerBlock("titanium_wall", () -> new WallBlock(BlockBehaviour.Properties.of(Material.METAL).strength(10f).requiresCorrectToolForDrops()));
	
	
	public static final RegistryObject<Block> TITANIUM_ORE = 
			registerBlock("titanium_ore", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(8f).requiresCorrectToolForDrops()));
	
	public static final RegistryObject<Block> TITANIUM_DOOR = 
			registerBlock("titanium_door", () -> new DoorBlock(BlockBehaviour.Properties.of(Material.METAL).strength(10f).requiresCorrectToolForDrops()));
	
	public static final RegistryObject<Block> TITANIUM_TRAPDOOR = 
			registerBlock("titanium_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.METAL).strength(10f).requiresCorrectToolForDrops()));
	
	public static final RegistryObject<Block> TITANIUM_PRESSURE_PLATE = 
			registerBlock("titanium_pressure_plate", () -> new PressurePlateBlock(
					PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of(Material.METAL).strength(10f).requiresCorrectToolForDrops()));
	
	public static final RegistryObject<Block> TITANIUM_BUTTON = 
			registerBlock("titanium_button", () -> new TitaniumButtonBlock(
					BlockBehaviour.Properties.of(Material.METAL).strength(10f).requiresCorrectToolForDrops()));
	
	public static final RegistryObject<Block> SPEEDY_BLOCK = 
			registerBlock("speedy_block", () -> new SpeedyBlock(BlockBehaviour.Properties.of(Material.METAL).strength(5f).requiresCorrectToolForDrops()));
	
	public static final RegistryObject<Block> RUBY_ORE = 
			registerBlock("ruby_ore", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(5f).requiresCorrectToolForDrops()));
	
	public static final RegistryObject<Block> RUBY_BLOCK = 
			registerBlock("ruby_block", () -> new Block(BlockBehaviour.Properties.of(Material.AMETHYST).strength(5f).requiresCorrectToolForDrops()));
	
	public static final RegistryObject<Block> RUBY_STAIRS =
			registerBlock("ruby_stairs", () -> new StairBlock(() -> RUBY_BLOCK.get().defaultBlockState(),
					BlockBehaviour.Properties.of(Material.AMETHYST).strength(5f).requiresCorrectToolForDrops()));
	
	public static final RegistryObject<Block> RUBY_SLAB = 
			registerBlock("ruby_slab", () -> new SlabBlock( BlockBehaviour.Properties.of(Material.AMETHYST).strength(5f).requiresCorrectToolForDrops()));
	
	public static final RegistryObject<Block> RUBY_WALL = 
			registerBlock("ruby_wall", () -> new WallBlock(BlockBehaviour.Properties.of(Material.AMETHYST).strength(5f).requiresCorrectToolForDrops()));
	
	
	public static final RegistryObject<Block> FIRESTONE_BLOCK = 
			registerBlock("firestone_block", () -> new FireStoneBlock(BlockBehaviour.Properties.of(Material.STONE).strength(5f).requiresCorrectToolForDrops()));
	
	public static final RegistryObject<Block> TEST_BLOCK =
			registerBlock("test_block", () -> new TestBlock(BlockBehaviour.Properties.of(Material.STONE).strength(5f).requiresCorrectToolForDrops()));

	public static final RegistryObject<Block> TOMATO_PLANT =
			BLOCKS.register("tomato_plant", () -> new TomatoPlantBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT)));








	
	private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block)
	{
		RegistryObject<T> toReturn = BLOCKS.register(name, block);
		registerBlockItem(name, toReturn);
		return toReturn;
	}
	
	
	private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block)
	{
		ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(ModCreativeModeTab.PREMIER_MOD_TAB)));
	}
	
	public static void register(IEventBus eventBus)
	{
		BLOCKS.register(eventBus);
	}
	
	
	
}
