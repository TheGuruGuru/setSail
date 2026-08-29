package com.theGuruGuru.setsail.content.kinetics;

import com.theGuruGuru.setsail.AllBlockEntityTypes;
import com.simibubi.create.content.kinetics.base.RotatedPillarKineticBlock;
import com.simibubi.create.foundation.block.IBE;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

/**
 * Example kinetic generator. It uses the same axle-style base as CreateSetSailKineticBlock;
 * the difference is entirely in the block entity, CreateSetSailGeneratorBlockEntity.
 */
public class CreateSetSailGeneratorBlock extends RotatedPillarKineticBlock implements IBE<CreateSetSailGeneratorBlockEntity> {

    public CreateSetSailGeneratorBlock(Properties properties) {
        super(properties);
    }

    @Override
    public boolean hasShaftTowards(LevelReader world, BlockPos pos, BlockState state, Direction face) {
        return face.getAxis() == state.getValue(AXIS);
    }

    @Override
    public Direction.Axis getRotationAxis(BlockState state) {
        return state.getValue(AXIS);
    }

    @Override
    public Class<CreateSetSailGeneratorBlockEntity> getBlockEntityClass() {
        return CreateSetSailGeneratorBlockEntity.class;
    }

    @Override
    public BlockEntityType<? extends CreateSetSailGeneratorBlockEntity> getBlockEntityType() {
        return AllBlockEntityTypes.EXAMPLE_GENERATOR.get();
    }
}
