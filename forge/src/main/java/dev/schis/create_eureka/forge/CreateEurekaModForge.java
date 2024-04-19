package dev.schis.create_eureka.forge;

import dev.schis.create_eureka.CreateEurekaMod;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(CreateEurekaMod.MOD_ID)
public class CreateEurekaModForge {
    public CreateEurekaModForge() {
        // registrate must be given the mod event bus on forge before registration
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        CreateEurekaMod.REGISTRATE.registerEventListeners(eventBus);
        CreateEurekaMod.init();
    }
}
