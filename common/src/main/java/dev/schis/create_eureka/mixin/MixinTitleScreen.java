package dev.schis.create_eureka.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import dev.schis.create_eureka.CreateEurekaMod;
import net.minecraft.client.gui.screens.TitleScreen;

@Mixin(TitleScreen.class)
public class MixinTitleScreen {
    @Inject(at = @At("HEAD"), method = "init()V")
    private void init(CallbackInfo info) {
        CreateEurekaMod.LOGGER.info("Hello from {}!", CreateEurekaMod.class.getName());
    }
}