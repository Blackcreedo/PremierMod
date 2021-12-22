package fr.black.pm.block.custom;

import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class SpeedyBlock extends Block{

	public SpeedyBlock(Properties pProperties) {
		super(pProperties);
	}

	
	@SuppressWarnings("deprecation")
	@Override
	public InteractionResult use(BlockState pBlockState, Level pLevel, BlockPos pBlockPos, Player pPlayer,
			InteractionHand pInteractionHand, BlockHitResult pBlockHitResult) {
		if(!pLevel.isClientSide()) {
			if(pInteractionHand == InteractionHand.MAIN_HAND) {
				pPlayer.sendMessage(new TextComponent("SpeedyBlock have been right clicked"), Util.NIL_UUID);
			}
		}
		return super.use(pBlockState, pLevel, pBlockPos, pPlayer, pInteractionHand, pBlockHitResult);
	}	
	
	
	
	@Override
	public void stepOn(Level pLevel, BlockPos pBlockPos, BlockState pBlockState, Entity pEntity) {
		if(!pLevel.isClientSide()) {
			if(pEntity instanceof LivingEntity) {
				LivingEntity entity = ((LivingEntity) pEntity);
				entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 10, 20));
			}
		}
		
		super.stepOn(pLevel, pBlockPos, pBlockState, pEntity);
	}
	
	
	
}
