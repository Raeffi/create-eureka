package dev.schis.create_eureka;

import com.simibubi.create.content.kinetics.base.ShaftInstance;
import com.simibubi.create.content.kinetics.base.ShaftRenderer;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.BlockEntityEntry;

import dev.schis.create_eureka.content.RotationEngineBlockEntity;

public class CreateEurekaBlockEntities {
    private static final CreateRegistrate REGISTRATE = CreateEurekaMod.getRegistrate();

	public static final BlockEntityEntry<RotationEngineBlockEntity> ROTATION_ENGINE = REGISTRATE
			.blockEntity("rotation_engine", RotationEngineBlockEntity::new)
			.instance(() -> ShaftInstance::new, false)
			.validBlocks(CreateEurekaBlocks.ROTATION_ENGINE)
			.renderer(() -> ShaftRenderer::new)
			.register();

	public static void register() {
		CreateEurekaMod.LOGGER.info("Registering block entities for " + CreateEurekaMod.NAME);
	}
}
