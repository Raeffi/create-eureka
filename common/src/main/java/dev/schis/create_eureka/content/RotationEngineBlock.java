package dev.schis.create_eureka.content;

import com.simibubi.create.content.kinetics.base.HorizontalKineticBlock;
import com.simibubi.create.foundation.block.IBE;

import dev.schis.create_eureka.CreateEurekaBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Axis;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class RotationEngineBlock extends HorizontalKineticBlock implements IBE<RotationEngineBlockEntity> {
    public static final IntegerProperty HEAT = IntegerProperty.create("heat", 0, 4);

    public RotationEngineBlock(Properties properties) {
        super(properties);
        registerDefaultState(defaultBlockState()
                .setValue(HEAT, 0));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(HEAT);
        super.createBlockStateDefinition(builder);
    }

    @Override
    public Axis getRotationAxis(BlockState state) {
		return state.getValue(HORIZONTAL_FACING)
			.getClockWise()
			.getAxis();
    }

	@Override
	public boolean hasShaftTowards(LevelReader world, BlockPos pos, BlockState state, Direction face) {
		return face.getAxis() == getRotationAxis(state);
	}

    @Override
    public Class<RotationEngineBlockEntity> getBlockEntityClass() {
        return RotationEngineBlockEntity.class;
    }

    @Override
    public BlockEntityType<? extends RotationEngineBlockEntity> getBlockEntityType() {
        return CreateEurekaBlockEntities.ROTATION_ENGINE.get();
    }

}