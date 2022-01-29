package fr.black.pm.world.dimension;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import fr.black.pm.PremierMod;

public class ModDimensions {
    public static ResourceKey<Level> FIRST_DIMENSION = ResourceKey.create(Registry.DIMENSION_REGISTRY,
            new ResourceLocation(PremierMod.MOD_ID, "first_dimension"));
}
