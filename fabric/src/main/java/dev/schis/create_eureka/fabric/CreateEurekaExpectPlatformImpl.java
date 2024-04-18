package dev.schis.create_eureka.fabric;

import net.fabricmc.loader.api.FabricLoader;

public class CreateEurekaExpectPlatformImpl {
	public static String platformName() {
		return FabricLoader.getInstance().isModLoaded("quilt_loader") ? "Quilt" : "Fabric";
	}
}
