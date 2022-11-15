package fr.gwengwen49.ghs.blocks.cables;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.PipeBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.pathfinder.PathComputationType;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class Hose extends PipeBlock
{

    public Hose(float p_55159_, Properties p_55160_)
    {
        super(p_55159_, p_55160_);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext p_49820_) {
        return this.getStateForPlacement(p_49820_.getLevel(), p_49820_.getClickedPos());
    }

    public BlockState getStateForPlacement(BlockGetter p_51711_, BlockPos p_51712_) {
        BlockState blockstate = p_51711_.getBlockState(p_51712_.below());
        BlockState blockstate1 = p_51711_.getBlockState(p_51712_.above());
        BlockState blockstate2 = p_51711_.getBlockState(p_51712_.north());
        BlockState blockstate3 = p_51711_.getBlockState(p_51712_.east());
        BlockState blockstate4 = p_51711_.getBlockState(p_51712_.south());
        BlockState blockstate5 = p_51711_.getBlockState(p_51712_.west());
        return this.defaultBlockState().setValue(DOWN, Boolean.valueOf(blockstate.is(this) || blockstate.is(Blocks.CHORUS_FLOWER) || blockstate.is(Blocks.END_STONE))).setValue(UP, Boolean.valueOf(blockstate1.is(this) || blockstate1.is(Blocks.CHORUS_FLOWER))).setValue(NORTH, Boolean.valueOf(blockstate2.is(this) || blockstate2.is(Blocks.CHORUS_FLOWER))).setValue(EAST, Boolean.valueOf(blockstate3.is(this) || blockstate3.is(Blocks.CHORUS_FLOWER))).setValue(SOUTH, Boolean.valueOf(blockstate4.is(this) || blockstate4.is(Blocks.CHORUS_FLOWER))).setValue(WEST, Boolean.valueOf(blockstate5.is(this) || blockstate5.is(Blocks.CHORUS_FLOWER)));
    }

    public BlockState updateShape(BlockState p_51728_, Direction p_51729_, BlockState p_51730_, LevelAccessor p_51731_, BlockPos p_51732_, BlockPos p_51733_) {
        if (!p_51728_.canSurvive(p_51731_, p_51732_)) {
            p_51731_.scheduleTick(p_51732_, this, 1);
            return super.updateShape(p_51728_, p_51729_, p_51730_, p_51731_, p_51732_, p_51733_);
        } else {
            boolean flag = p_51730_.is(this);
            return p_51728_.setValue(PROPERTY_BY_DIRECTION.get(p_51729_), Boolean.valueOf(flag));
        }
    }

    @Override
    public boolean canSurvive(BlockState p_60525_, LevelReader p_60526_, BlockPos p_60527_) {
        return true;
    }

    public void tick(BlockState p_51714_, ServerLevel p_51715_, BlockPos p_51716_, Random p_51717_) {
        if (!p_51714_.canSurvive(p_51715_, p_51716_)) {
            p_51715_.destroyBlock(p_51716_, true);
        }

    }


    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_51735_) {
        p_51735_.add(NORTH, EAST, SOUTH, WEST, UP, DOWN);
    }

    public boolean isPathfindable(BlockState p_51719_, BlockGetter p_51720_, BlockPos p_51721_, PathComputationType p_51722_) {
        return false;
    }
}
