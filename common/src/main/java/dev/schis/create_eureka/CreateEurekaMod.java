package dev.schis.create_eureka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.simibubi.create.Create;
import com.simibubi.create.foundation.data.CreateRegistrate;

import net.minecraft.resources.ResourceLocation;

public class CreateEurekaMod {
    public static final String MOD_ID = "create_eureka";
    public static final String NAME = "Create: Eureka!";
    public static final Logger LOGGER = LoggerFactory.getLogger(NAME);

    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(CreateEurekaMod.MOD_ID);

    public static void init() {
        LOGGER.info("{} initializing! Create version: {} on platform: {}", NAME, Create.VERSION,
                CreateEurekaExpectPlatform.platformName());
        CreateEurekaBlocks.register();
        CreateEurekaBlockEntities.register();
    }

    public static ResourceLocation id(String path) {
        return new ResourceLocation(MOD_ID, path);
    }

    public static CreateRegistrate getRegistrate() {
        return REGISTRATE;
    }
}
