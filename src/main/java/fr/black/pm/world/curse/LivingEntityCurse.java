package fr.black.pm.world.curse;

import com.google.common.collect.Maps;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.Map;

public abstract class LivingEntityCurse extends LivingEntity {
    private final Map<MobCurse, MobCurseInstance> activeCurses = Maps.newHashMap();
    private boolean CursesDirty = true;
    
    
    public LivingEntityCurse(EntityType<? extends LivingEntity> p_20966_, Level p_20967_) {
        super(p_20966_, p_20967_);
    }


    public boolean canBeAffected(MobCurseInstance p_21197_) {
        CurseEvent.CurseApplicableEvent event = new CurseEvent.CurseApplicableEvent(this, p_21197_);
        net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(event);
        if (event.getResult() != net.minecraftforge.eventbus.api.Event.Result.DEFAULT) return event.getResult() == net.minecraftforge.eventbus.api.Event.Result.ALLOW;
        return true;
    }
    
    
    
    public final boolean addCurse(MobCurseInstance p_21165_) {
        return this.addCurse(p_21165_, (Entity)null);
    }

    public boolean addCurse(MobCurseInstance p_147208_, @Nullable Entity p_147209_) {
        if (!this.canBeAffected(p_147208_)) {
            return false;
        } else {
            MobCurseInstance mobcurseinstance = this.activeCurses.get(p_147208_.getCurse());
            net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(new CurseEvent.CurseAddedEvent(this, mobcurseinstance, p_147208_, p_147209_));
            if (mobcurseinstance == null) {
                this.activeCurses.put(p_147208_.getCurse(), p_147208_);
                this.onCurseAdded(p_147208_, p_147209_);
                return true;
            } else if (mobcurseinstance.update(p_147208_)) {
                this.onCurseUpdated(mobcurseinstance, true, p_147209_);
                return true;
            } else {
                return false;
            }
        }
    }

    protected void onCurseAdded(MobCurseInstance p_147190_, @Nullable Entity p_147191_) {
        this.CursesDirty = true;
        if (!this.level.isClientSide) {
            p_147190_.getCurse().addAttributeModifiers(this, this.getAttributes(), p_147190_.getLevel());
        }
    }

    protected void onCurseUpdated(MobCurseInstance p_147192_, boolean p_147193_, @Nullable Entity p_147194_) {
        this.CursesDirty = true;
        if (p_147193_ && !this.level.isClientSide) {
            MobCurse mobCurse = p_147192_.getCurse();
            mobCurse.removeAttributeModifiers(this, this.getAttributes(), p_147192_.getLevel());
            mobCurse.addAttributeModifiers(this, this.getAttributes(), p_147192_.getLevel());
        }
    }

    protected void onCurseRemoved(MobCurseInstance p_21126_) {
        this.CursesDirty = true;
        if (!this.level.isClientSide) {
            p_21126_.getCurse().removeAttributeModifiers(this, this.getAttributes(), p_21126_.getLevel());
        }
    }


    
    
    
}
