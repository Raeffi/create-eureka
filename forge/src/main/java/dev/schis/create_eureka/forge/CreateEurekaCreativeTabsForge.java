package dev.schis.create_eureka.forge;

import java.util.List;

import org.jetbrains.annotations.NotNull;

import com.simibubi.create.AllCreativeModeTabs;
import com.tterrag.registrate.util.entry.ItemProviderEntry;

import dev.schis.create_eureka.CreateEurekaBlocks;
import dev.schis.create_eureka.CreateEurekaMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class CreateEurekaCreativeTabsForge {
    private static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister
            .create(Registries.CREATIVE_MODE_TAB, CreateEurekaMod.MOD_ID);

    public static final List<ItemProviderEntry<?>> ITEMS = List.of(
            CreateEurekaBlocks.ROTATION_ENGINE);

    public static final RegistryObject<CreativeModeTab> MAIN = CREATIVE_MODE_TABS.register("main",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.create_eureka.main"))
                    .withTabsBefore(AllCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
                    .icon(CreateEurekaBlocks.ROTATION_ENGINE::asStack)
                    .displayItems(new DisplayItemsGenerator(ITEMS))
                    .build());

    public static void register(IEventBus modEventBus) {
        CREATIVE_MODE_TABS.register(modEventBus);
    }

    private record DisplayItemsGenerator(
            List<ItemProviderEntry<?>> items) implements CreativeModeTab.DisplayItemsGenerator {
        @Override
        public void accept(@NotNull CreativeModeTab.ItemDisplayParameters params,
                @NotNull CreativeModeTab.Output output) {
            for (ItemProviderEntry<?> item : items) {
                output.accept(item);
            }
        }
    }
}
