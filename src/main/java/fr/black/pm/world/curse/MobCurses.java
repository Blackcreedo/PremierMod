package fr.black.pm.world.curse;


import fr.black.pm.PremierMod;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class MobCurses{

    public static final DeferredRegister<MobCurse> CURSES =
            DeferredRegister.create(CurseRegistry.MOB_CURSES, PremierMod.MOD_ID);

    public static final RegistryObject<MobCurse> LIGHTNING_STRIKE =
            registerCurse("lightning_strike", () -> new MobCurse(MobCurseCategory.HARMFUL, 3));


    private static <T extends MobCurse> RegistryObject<T> registerCurse(String name, Supplier<T> curse)
    {
        return CURSES.register(name, curse);
    }

    public static void register(IEventBus eventBus)
    {
        CURSES.register(eventBus);
    }
}
