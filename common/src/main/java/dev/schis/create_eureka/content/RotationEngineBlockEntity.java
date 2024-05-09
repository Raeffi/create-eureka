package dev.schis.create_eureka.content;

import static dev.schis.create_eureka.content.RotationEngineBlock.HEAT;

import org.valkyrienskies.core.api.ships.ServerShip;
import org.valkyrienskies.eureka.EurekaConfig;
import org.valkyrienskies.eureka.ship.EurekaShipControl;
import org.valkyrienskies.mod.common.VSGameUtilsKt;

import com.simibubi.create.content.kinetics.base.KineticBlockEntity;

import dev.schis.create_eureka.CreateEurekaMod;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
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
            int newHeat = (int) Math.floor((double) Math.abs(getSpeed()) / 64);
            if (heat != newHeat) {
                level.setBlockAndUpdate(getBlockPos(), getBlockState().setValue(HEAT, newHeat));
                heat = newHeat;
            }
        }
    }

    @Override
    public void tick() {
        super.tick();
        
        if (level.isClientSide)
            return;

        if (Math.abs(getSpeed()) > 0) {
            // CreateEurekaMod.LOGGER.info("Setting speed:", getSpeed());
            ServerShip ship = VSGameUtilsKt.getShipManagingPos((ServerLevel) getLevel(), this.getBlockPos());
            if (ship != null) {
                // CreateEurekaMod.LOGGER.info("Found Ship");
                EurekaShipControl shipControl = ship.getAttachment(EurekaShipControl.class);
                if (shipControl != null) {
                    // CreateEurekaMod.LOGGER.info("Found Ship Control");
                    float effectiveHeat = Math.abs(getSpeed()) / 256f;
                    // CreateEurekaMod.LOGGER.info("Effective Heat: ", effectiveHeat);

                    shipControl.setPowerLinear(shipControl.getPowerLinear() + lerp(
                            EurekaConfig.SERVER.getEnginePowerLinearMin(),
                            EurekaConfig.SERVER.getEnginePowerLinear(),
                            effectiveHeat));

                    shipControl.setPowerAngular(shipControl.getPowerAngular() + lerp(
                            EurekaConfig.SERVER.getEnginePowerAngularMin(),
                            EurekaConfig.SERVER.getEnginePowerAngular(),
                            effectiveHeat));
                }
            }
        }
    }

    private float lerp(float a, float b, float f) {
        return a * (1.0f - f) + (b * f);
    }
}