package xiaohei.oregrowthchamber;

import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.world.BlockView;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class OreGrowthChamberBlock extends Block implements BlockEntityProvider {

    public OreGrowthChamberBlock(Settings settings) {
        super(settings);
    }

    @Override
    public BlockEntity createBlockEntity(BlockView world) {
        return null;
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        // With inheriting from BlockWithEntity this defaults to INVISIBLE, so we need
        // to change that!
        return BlockRenderType.MODEL;
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand,
            BlockHitResult hit) {
        // You need a Block.createScreenHandlerFactory implementation that delegates to
        // the block entity,
        // such as the one from BlockWithEntity
        player.openHandledScreen(state.createScreenHandlerFactory(world, pos));
        return ActionResult.SUCCESS;
    }
    // player.sendMessage(new LiteralText("Hello, world!"), false);

    // This method will drop all items onto the ground when the block is broken
    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof mBlockEntity) {
                ItemScatterer.spawn(world, pos, (mBlockEntity) blockEntity);
                // update comparators
                world.updateComparators(pos, this);
            }
            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }

    @Override
    public boolean hasComparatorOutput(BlockState state) {
        return true;
    }

    @Override
    public int getComparatorOutput(BlockState state, World world, BlockPos pos) {
        return ScreenHandler.calculateComparatorOutput(world.getBlockEntity(pos));
    }
}