package net.tekhex.triforcetales;

import net.minecraft.world.level.ItemLike;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.tekhex.triforcetales.registry.ItemInit;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class TriforceTalesCreativeTab {
    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TriforceTalesMod.MOD_ID);

    public static final List<Supplier<? extends ItemLike>> CURRENCY_TAB_ITEMS = new ArrayList<>();

    public static final Supplier<CreativeModeTab> CURRENCY_TAB = TABS.register("currency_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.literal("Currency"))
                    .icon(() -> new ItemStack(ItemInit.GREENRUPEE.get()))
                    .displayItems((displayParams, output) ->
                            CURRENCY_TAB_ITEMS.forEach(itemLike -> output.accept(itemLike.get())))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ItemInit.GREENRUPEE);
                        output.accept(ItemInit.BLUERUPEE);
                        output.accept(ItemInit.REDRUPEE);
                        output.accept(ItemInit.PURPLERUPEE);
                        output.accept(ItemInit.SILVERRUPEE);
                        output.accept(ItemInit.GOLDENRUPEE);
                        output.accept(ItemInit.RUPOOR);
                    }).build()
    );

    public static void register(IEventBus eventBus) {
        TABS.register(eventBus);
    }
}