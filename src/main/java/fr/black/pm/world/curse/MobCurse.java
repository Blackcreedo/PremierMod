package fr.black.pm.world.curse;

import com.google.common.collect.Maps;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;

import javax.annotation.Nullable;
import java.util.Map;

public class MobCurse extends net.minecraftforge.registries.ForgeRegistryEntry<MobCurse> {
    private final Map<Attribute, AttributeModifier> attributeModifiers = Maps.newHashMap();
    private final MobCurseCategory category;
    private final int rank;
    @Nullable
    private String descriptionId;

    public MobCurse(MobCurseCategory category, int rank) {
        this.category = category;
        this.rank = rank;
    }

    protected String getOrCreateDescriptionId() {
        if (this.descriptionId == null) {
            this.descriptionId = Util.makeDescriptionId("effect", CurseRegistry.MOB_CURSES.getKey(this));
        }

        return this.descriptionId;
    }

    public String getDescriptionId() {
        return this.getOrCreateDescriptionId();
    }

    public int getRank() {
        return this.rank;
    }


    public MobCurseCategory getCategory() {
        return this.category;
    }

    public double getAttributeModifierValue(int p_19457_, AttributeModifier p_19458_) {
        return p_19458_.getAmount() * (double)(p_19457_ + 1);
    }


    public void applyCurseTick(LivingEntity entity, int p_19468_) {
        if (this == MobCurses.LIGHTNING_STRIKE.get()) {
            ServerLevel world = (ServerLevel) entity.level;
            BlockPos position = entity.blockPosition();
            EntityType.LIGHTNING_BOLT.spawn(world, null, null, position, MobSpawnType.TRIGGERED, true, true);
        }
    }

    public boolean isDurationCurseTick(int p_19456_) {
        if (this == MobCurses.LIGHTNING_STRIKE.get()) {
            int j = 50 >> p_19456_;
            if (j > 0) {
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

    public void removeAttributeModifiers(LivingEntity p_19469_, AttributeMap p_19470_, int p_19471_) {
        for(Map.Entry<Attribute, AttributeModifier> entry : this.attributeModifiers.entrySet()) {
            AttributeInstance attributeinstance = p_19470_.getInstance(entry.getKey());
            if (attributeinstance != null) {
                attributeinstance.removeModifier(entry.getValue());
            }
        }
    }

    public void addAttributeModifiers(LivingEntity p_19478_, AttributeMap p_19479_, int p_19480_) {
        for(Map.Entry<Attribute, AttributeModifier> entry : this.attributeModifiers.entrySet()) {
            AttributeInstance attributeinstance = p_19479_.getInstance(entry.getKey());
            if (attributeinstance != null) {
                AttributeModifier attributemodifier = entry.getValue();
                attributeinstance.removeModifier(attributemodifier);
                attributeinstance.addPermanentModifier(new AttributeModifier(attributemodifier.getId(), this.getDescriptionId() + " " + p_19480_, this.getAttributeModifierValue(p_19480_, attributemodifier), attributemodifier.getOperation()));
            }
        }
    }
}
