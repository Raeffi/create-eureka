package dev.schis.create_eureka;

import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.BlockEntry;

import net.minecraft.world.level.block.Block;

public class CreateEurekaBlocks {
	public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(CreateEurekaMod.MOD_ID);

	public static final BlockEntry<Block> EXAMPLE_BLOCK = REGISTRATE.block("example_block", Block::new).register();

	public static void init() {
		// load the class and register everything
		CreateEurekaMod.LOGGER.info("Registering blocks for " + CreateEurekaMod.NAME);
	}
}
