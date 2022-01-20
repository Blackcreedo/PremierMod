package fr.black.pm.world.curse;

import net.minecraft.ChatFormatting;

public enum MobCurseCategory {
    BENEFICIAL(ChatFormatting.BLUE),
    HARMFUL(ChatFormatting.RED),
    NEUTRAL(ChatFormatting.BLUE);

    private final ChatFormatting tooltipFormatting;

    private MobCurseCategory(ChatFormatting p_19496_) {
        this.tooltipFormatting = p_19496_;
    }

    public ChatFormatting getTooltipFormatting() {
        return this.tooltipFormatting;
    }

}
