package fr.black.pm.world.curse;


import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class CurseEvent extends LivingEvent {

    @Nullable
    protected final MobCurseInstance curse;

    public CurseEvent(LivingEntity entity, @Nullable MobCurseInstance curse) {
        super(entity);
        this.curse = curse;
    }

    @Nullable
    public MobCurseInstance getCurseEffect()
    {
        return curse;
    }

    @Event.HasResult
    public static class CurseApplicableEvent extends CurseEvent
    {
        public CurseApplicableEvent(LivingEntity living, MobCurseInstance curse)
        {
            super(living, curse);
        }

        /**
         * @return the CurseEffect.
         */
        @Override
        @Nonnull
        public MobCurseInstance getCurseEffect()
        {
            return super.getCurseEffect();
        }
    }


    public static class CurseAddedEvent extends CurseEvent
    {
        private final MobCurseInstance oldCurse;
        private final Entity source;

        @Deprecated(forRemoval = true, since = "1.17.1")
        public CurseAddedEvent(LivingEntity living, MobCurseInstance oldCurse, MobCurseInstance newCurse)
        {
            this(living, oldCurse, newCurse, null);
        }

        public CurseAddedEvent(LivingEntity living, MobCurseInstance oldCurse, MobCurseInstance newCurse, Entity source)
        {
            super(living, newCurse);
            this.oldCurse = oldCurse;
            this.source = source;
        }

        /**
         * @return the added CurseEffect. This is the umerged CurseEffect if the old CurseEffect is not null.
         */
        @Override
        @Nonnull
        public MobCurseInstance getCurseEffect()
        {
            return super.getCurseEffect();
        }

        /**
         * @return the old CurseEffect. THis can be null if the entity did not have an effect of this kind before.
         */
        @Nullable
        public MobCurseInstance getOldCurseEffect()
        {
            return oldCurse;
        }

        /**
         * Returns the entity source of the effect, or {@code null} if none exists.
         *
         * @return the entity source of the effect, or {@code null}
         */
        @Nullable
        public Entity getCurseSource()
        {
            return source;
        }
    }
    

}
