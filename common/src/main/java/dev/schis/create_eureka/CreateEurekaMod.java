package dev.schis.create_eureka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.simibubi.create.Create;

import net.minecraft.resources.ResourceLocation;

public class CreateEurekaMod {
    public static final String MOD_ID = "create_eureka";
    public static final String NAME = "Create: Eureka!";
    public static final Logger LOGGER = LoggerFactory.getLogger(NAME);


    public static void init() {
        LOGGER.info("{} initializing! Create version: {} on platform: {}", NAME, Create.VERSION, CreateEurekaExpectPlatform.platformName());
        CreateEurekaBlocks.init(); // hold registrate in a separate class to avoid loading early on forge
    }

    public static ResourceLocation id(String path) {
        return new ResourceLocation(MOD_ID, path);
    }
}
