/*package fr.black.pm.tileEntities.custom;

import fr.black.pm.item.ModItems;
import fr.black.pm.tileEntities.ModTileEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nonnull;

public class LightningChannelerTile extends BlockEntity {

    private final ItemStackHandler itemHandler = createHandler();
    private final LazyOptional<IItemHandler> handler = LazyOptional.of(() -> itemHandler);


    public LightningChannelerTile(BlockEntityType<?> type, BlockPos pos, BlockState blockState) {
        super(type, pos, blockState);
    }

    public LightningChannelerTile() {
        this(ModTileEntities.LIGHTNING_CHANNELER_TILE.get());
    }



    private ItemStackHandler createHandler(){
        return new ItemStackHandler(2){
            @Override
            protected void onContentsChanged(int slot) {
                super.onContentsChanged(slot);
            }

            @Override
            public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
                switch(slot){
                    case 0: return stack.getItem() == Items.GLASS_PANE;
                    case 1: return stack.getItem() == ModItems.RUBY.get() || stack.getItem() == ModItems.FIRESTONE.get();
                    default: return false;
                }
            }

            @Override
            public int getSlotLimit(int slot) {
                return super.getSlotLimit(slot);
            }

            @Nonnull
            @Override
            public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate) {
                if(!isItemValid(slot,stack)){
                    return stack;
                }

                return super.insertItem(slot, stack, simulate);
            }
        };
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap) {
        if(cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY){
            return handler.cast();
        }

        return super.getCapability(cap);
    }

    @Override
    public CompoundTag getUpdateTag() {
        return super.getUpdateTag();
    }


    public void lightningHasStruck(){
        boolean hasFocusInFirstSlot = this.itemHandler.getStackInSlot(0).getCount()>0
                && this.itemHandler.getStackInSlot(0).getItem() == Items.GLASS_PANE;

        boolean hasRubyInSecondSlot = this.itemHandler.getStackInSlot(0).getCount()>0
                && this.itemHandler.getStackInSlot(0).getItem() == ModItems.FIRESTONE.get();

        if(hasFocusInFirstSlot && hasRubyInSecondSlot){
            this.itemHandler.getStackInSlot(0).shrink(1);
            this.itemHandler.getStackInSlot(1).shrink(1);
            this.itemHandler.insertItem(1, new ItemStack(ModItems.FIRESTONE.get()), false);
        }
    }
}
*/