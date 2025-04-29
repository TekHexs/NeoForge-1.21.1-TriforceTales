package net.TekHex.triforcetalesmod.item;

import net.TekHex.triforcetalesmod.TriforceTalesMod;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TriforceTalesMod.MOD_ID);

    public static final DeferredItem<Item> GREENRUPEE = ITEMS.register("greenrupee",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
