package fr.black.pm.enchantment;

import fr.black.pm.PremierMod;
import fr.black.pm.effect.ModEffects;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


public class LightningStrikerEnchantmentBis extends Enchantment {
    //private int tickCount = 0;
    private boolean called;
    /*private int count = 1;
    private int level;
    private LivingEntity target;
    private ServerPlayer player;
    private ServerLevel world;
*/

    protected LightningStrikerEnchantmentBis(Rarity p_44676_, EnchantmentCategory p_44677_, EquipmentSlot... p_44678_) {
        super(p_44676_, p_44677_, p_44678_);
    }

    @Override
    public void doPostAttack(LivingEntity pAttacker, Entity pTarget, int pLevel) {
        if (called){called = false;}  // fix the 2 times call
        else{
            called = true;
            ServerPlayer player = (ServerPlayer) pAttacker;
            if(!pAttacker.level.isClientSide()){
                if(pTarget instanceof LivingEntity) {
                    LivingEntity target = (LivingEntity) pTarget;
                    generateLightning(player, target, pLevel);
                }
            }
        }
        super.doPostAttack(pAttacker, pTarget, pLevel);
    }

    private void generateLightning(ServerPlayer player, LivingEntity target,int pLevel) {
        ServerLevel world = (ServerLevel) player.level;
        BlockPos position = target.blockPosition();
        EntityType.LIGHTNING_BOLT.spawn(world, null, null, position, MobSpawnType.TRIGGERED, true, true);
        target.addEffect(new MobEffectInstance(ModEffects.LIGHTNING_STRIKE.get(), 40*pLevel, 60, false, false));
        //MinecraftForge.EVENT_BUS.register(this);
    }

/*
    @SubscribeEvent
    public void onTick(TickEvent.ServerTickEvent event){
        if(count < level){
            if(tickCount >= 40){
                BlockPos position = target.blockPosition();
                EntityType.LIGHTNING_BOLT.spawn(world, null, null, position, MobSpawnType.TRIGGERED, true, true);
                tickCount = 0;
                count ++;
            }
            tickCount ++;
        } else {
            tickCount = 0;
            count = 1;
            MinecraftForge.EVENT_BUS.unregister(this);
        }
    }
*/
    @Override
    public int getMaxLevel() {
        return 5;
    }

}
