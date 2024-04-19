package dev.schis.create_eureka.fabric;

import dev.schis.create_eureka.CreateEurekaMod;
import io.github.fabricators_of_create.porting_lib.util.EnvExecutor;
import net.fabricmc.api.ModInitializer;

public class CreateEurekaModFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        CreateEurekaMod.init();
        CreateEurekaMod.LOGGER.info(EnvExecutor.unsafeRunForDist(
                () -> () -> "{} is accessing Porting Lib on a Fabric client!",
                () -> () -> "{} is accessing Porting Lib on a Fabric server!"
                ), CreateEurekaMod.NAME);
        // on fabric, Registrates must be explicitly finalized and registered.
        CreateEurekaMod.REGISTRATE.register();
    }
}
