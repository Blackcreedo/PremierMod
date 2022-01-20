package fr.black.pm.world.curse;


import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.registries.ForgeRegistryEntry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Nullable;

public class MobCurseInstance extends ForgeRegistryEntry {
    private static final Logger LOGGER = LogManager.getLogger();
    private final MobCurse curse;
    private int level;

    public int getLevel() {
        return level;
    }

    private boolean isActive;
    @Nullable
    private MobCurseInstance hiddenCurse;

    public MobCurseInstance(MobCurse curse) {
        this(curse, 0, false);
    }

    public MobCurseInstance(MobCurse curse, int level) {
        this(curse, level, true);
    }

    public MobCurseInstance(MobCurse curse, int level, boolean isActive) {
        this.curse = curse;
        this.level = level;
        this.isActive = isActive;
    }

    public MobCurseInstance(MobCurseInstance curseInstance) {
        this.curse = curseInstance.curse;
        this.setDetailsFrom(curseInstance);
    }

    void setDetailsFrom(MobCurseInstance curseInstance) {
        this.level = curseInstance.level;
        this.isActive = curseInstance.isActive;
    }

    public MobCurse getCurse() {
        return this.curse == null ? null : this.curse.delegate.get();
    }

    public boolean update(MobCurseInstance curseInstance) {
        if (this.curse != curseInstance.curse) {
            LOGGER.warn("This method should only be called for matching curses!");
        }

        boolean flag = false;
        if (curseInstance.level > this.level) {
            MobCurseInstance MobCurseInstance = this.hiddenCurse;
            this.hiddenCurse = new MobCurseInstance(this);
            this.hiddenCurse.hiddenCurse = MobCurseInstance;

            this.level = curseInstance.level;
            flag = true;
        } else if (this.hiddenCurse == null) {
            this.hiddenCurse = new MobCurseInstance(curseInstance);
        } else {
            this.hiddenCurse.update(curseInstance);
        }
        return flag;
    }


    public boolean tick(LivingEntity p_19553_, Runnable p_19554_) {
        if (this.curse.isDurationCurseTick(this.level)) {
            this.applyCurse(p_19553_);
        }

        if (this.isActive && this.hiddenCurse != null) {
            this.setDetailsFrom(this.hiddenCurse);
            this.hiddenCurse = this.hiddenCurse.hiddenCurse;
            p_19554_.run();
        }
        return this.isActive;
    }


    public void applyCurse(LivingEntity entity) {
        if (this.isActive) {
            this.curse.applyCurseTick(entity, this.level);
        }
    }
}
