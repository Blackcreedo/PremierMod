package fr.black.pm.tileEntities;

import fr.black.pm.block.ModBlocks;
import fr.black.pm.PremierMod;
import fr.black.pm.item.ModCreativeModeTab;
import fr.black.pm.item.ModItems;
import fr.black.pm.tileEntities.custom.PowergenBlock;
import fr.black.pm.tileEntities.custom.PowergenBlockEntity;
import fr.black.pm.tileEntities.custom.PowergenContainer;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;


public class ModTileEntities {
    public static DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, PremierMod.MOD_ID);

    public static DeferredRegister<MenuType<?>> CONTAINERS =
            DeferredRegister.create(ForgeRegistries.CONTAINERS, PremierMod.MOD_ID);


    public static final RegistryObject<PowergenBlock> POWERGEN = registerBlock("powergen", PowergenBlock::new);
    public static final RegistryObject<BlockEntityType<PowergenBlockEntity>> POWERGEN_BLOCKENTITY =
            BLOCK_ENTITIES.register("powergen", () -> BlockEntityType.Builder.of(PowergenBlockEntity::new, POWERGEN.get()).build(null));
    public static final RegistryObject<MenuType<PowergenContainer>> POWERGEN_CONTAINER =
            CONTAINERS.register("powergen", () -> IForgeContainerType.create((windowId, inv, data) -> new PowergenContainer(windowId,data.readBlockPos(), inv, inv.player)));



    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block)
    {
        RegistryObject<T> toReturn = ModBlocks.BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block)
    {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(ModCreativeModeTab.PREMIER_MOD_TAB)));
    }


    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
        CONTAINERS.register(eventBus);
    }
}