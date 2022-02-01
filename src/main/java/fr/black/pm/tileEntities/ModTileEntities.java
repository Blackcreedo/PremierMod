package fr.black.pm.tileEntities;

import fr.black.pm.PremierMod;
import fr.black.pm.tileEntities.custom.LightningChannelerTile;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTileEntities {
    public static DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, PremierMod.MOD_ID);

    public static final RegistryObject<BlockEntityType<LightningChannelerTile>> LIGHTNING_CHANNELER =
            BLOCK_ENTITIES.register("lightning_channeler", () -> new BlockEntityType.Builder.create())

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
