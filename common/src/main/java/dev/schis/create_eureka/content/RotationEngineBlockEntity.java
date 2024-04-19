package dev.schis.create_eureka.content;

import static dev.schis.create_eureka.content.RotationEngineBlock.HEAT;

import com.simibubi.create.content.kinetics.base.KineticBlockEntity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class RotationEngineBlockEntity extends KineticBlockEntity {

    private int heat = 0;

    public RotationEngineBlockEntity(BlockEntityType<?> typeIn, BlockPos pos, BlockState state) {
        super(typeIn, pos, state);
    }

    @Override
    public void onSpeedChanged(float prevSpeed) {
        super.onSpeedChanged(prevSpeed);
        if (level != null) {
            int newHeat = (int)Math.floor((double)Math.abs(getSpeed()) / 64);
            if (heat != newHeat) {
                level.setBlockAndUpdate(getBlockPos(), getBlockState().setValue(HEAT, newHeat));
                heat = newHeat;
            }
            
            // EUREKA
        }
    }
}