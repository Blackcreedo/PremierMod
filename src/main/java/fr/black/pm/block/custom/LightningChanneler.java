package fr.black.pm.block.custom;

import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class LightningChanneler extends Block {

    public LightningChanneler (BlockBehaviour.Properties pProperties) {
        super(pProperties);
    }

    @SuppressWarnings("deprecation")
    @Override
    public InteractionResult use(BlockState pBlockState, Level pLevel, BlockPos pBlockPos, Player player,
                                 InteractionHand Hand, BlockHitResult Hit) {
        if(!pLevel.isClientSide()) {
            if(Hand == InteractionHand.MAIN_HAND) {
                player.sendMessage(new TextComponent("Lightning Channeler have been right clicked"), Util.NIL_UUID);
                if(!player.isCrouching()){
                    //open gui
                } else {
                    //if rain summon lightning on the lightning channeler
                    if(pLevel.isThundering() || pLevel.isRaining()){
                        ServerLevel world = (ServerLevel) pLevel;
                        EntityType.LIGHTNING_BOLT.spawn(world, null, null, pBlockPos, MobSpawnType.TRIGGERED, true, true);
                    }
                }

            }
        }

        return super.use(pBlockState, pLevel, pBlockPos, player, Hand, Hit);
    }

}
