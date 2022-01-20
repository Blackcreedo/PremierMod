package fr.black.pm.world.curse;



import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryManager;


public class CurseRegistry<T> extends ForgeRegistries {

    public static final IForgeRegistry<MobCurse> MOB_CURSES = RegistryManager.ACTIVE.getRegistry(MobCurse.class);

    public static final class Keys {
        public static final ResourceKey<Registry<MobCurse>> MOB_CURSES = key("mob_curse");

        private static <T> ResourceKey<Registry<T>> key(String name)
        {
            return ResourceKey.createRegistryKey(new ResourceLocation(name));
        }
    }

}








