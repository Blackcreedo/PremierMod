package fr.black.pm.world.biome;

import fr.black.pm.PremierMod;
import fr.black.pm.block.ModBlocks;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilderBaseConfiguration;

public class ModSurfaceConfigs {

    public static final ConfiguredSurfaceBuilder<SurfaceBuilderBaseConfiguration> LAVA_SURFACE_BUILDER =
            register("lava_surface", SurfaceBuilder.DEFAULT.configured(new SurfaceBuilderBaseConfiguration(
                    Blocks.MAGMA_BLOCK.defaultBlockState(),
                    ModBlocks.TITANIUM_BLOCK.get().defaultBlockState(),
                    Blocks.SANDSTONE.defaultBlockState()
            )));


    private static <T extends SurfaceBuilderBaseConfiguration> ConfiguredSurfaceBuilder<T> register(String name,
                                                                                                    ConfiguredSurfaceBuilder<T> surfaceBuilder){
        return Registry.register(BuiltinRegistries.CONFIGURED_SURFACE_BUILDER, new ResourceLocation(PremierMod.MOD_ID, name), surfaceBuilder);
    }

}
