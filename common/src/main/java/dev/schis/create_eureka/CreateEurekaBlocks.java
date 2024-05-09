package dev.schis.create_eureka;

import static com.simibubi.create.foundation.data.ModelGen.customItemModel;
import static com.simibubi.create.foundation.data.TagGen.axeOrPickaxe;
import static dev.schis.create_eureka.content.RotationEngineBlock.HEAT;

import com.simibubi.create.content.kinetics.BlockStressDefaults;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.data.SharedProperties;
import com.tterrag.registrate.util.entry.BlockEntry;

import dev.schis.create_eureka.content.RotationEngineBlock;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.material.MapColor;

public class CreateEurekaBlocks {
	private static final CreateRegistrate REGISTRATE = CreateEurekaMod.getRegistrate();

	public static final BlockEntry<RotationEngineBlock> ROTATION_ENGINE = REGISTRATE
			.block("rotation_engine", RotationEngineBlock::new)
			.initialProperties(SharedProperties::stone)
			.properties(p -> p
					.noOcclusion()
					.mapColor(MapColor.DEEPSLATE)
					.requiresCorrectToolForDrops()
					.strength(3.5f)
					.lightLevel(s -> s.getValue(HEAT) * 3))
			.addLayer(() -> RenderType::cutoutMipped)
			.transform(BlockStressDefaults.setImpact(32.0))
			.transform(axeOrPickaxe())
			.item()
			.transform(customItemModel())
			.register();

	public static void register() {
		CreateEurekaMod.LOGGER.info("Registering blocks for " + CreateEurekaMod.NAME);
	}
}
