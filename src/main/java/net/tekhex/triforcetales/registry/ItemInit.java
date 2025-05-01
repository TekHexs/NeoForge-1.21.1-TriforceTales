package net.tekhex.triforcetales.registry;

import net.tekhex.triforcetales.TriforceTalesMod;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ItemInit {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TriforceTalesMod.MOD_ID);


    //currency items
    public static final DeferredItem<Item> GREENRUPEE = ITEMS.register("greenrupee",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> BLUERUPEE = ITEMS.register("bluerupee",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> REDRUPEE = ITEMS.register("redrupee",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> PURPLERUPEE = ITEMS.register("purplerupee",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> SILVERRUPEE = ITEMS.register("silverrupee",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> GOLDENRUPEE = ITEMS.register("goldenrupee",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RUPOOR = ITEMS.register("rupoor",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
