package com.theGuruGuru.setsail;

import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.ItemEntry;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

/**
 * Item registration. Each item overrides its model to borrow a vanilla texture, so the
 * template builds with no texture files of its own. Point the model at your own texture,
 * or remove the override and add assets/setsail/textures/item/name.png.
 */
public class AllItems {

    private static final CreateRegistrate REGISTRATE = CreateSetSail.REGISTRATE;
    public static final ItemEntry<Item> EXAMPLE_ITEM = REGISTRATE
            .item("setsail_item", Item::new)
            .model((c, p) -> p.generated(c::getEntry, ResourceLocation.withDefaultNamespace("item/amethyst_shard")))
            .register();

    /**
     * Output of the sequenced assembly and several other example recipes.
     */
    public static final ItemEntry<Item> EXAMPLE_RESULT = REGISTRATE
            .item("setsail_result", Item::new)
            .model((c, p) -> p.generated(c::getEntry, ResourceLocation.withDefaultNamespace("item/netherite_ingot")))
            .register();

    /**
     * Transitional item carried between the steps of the sequenced assembly recipe.
     */
    public static final ItemEntry<Item> INCOMPLETE_EXAMPLE = REGISTRATE
            .item("incomplete_example", Item::new)
            .model((c, p) -> p.generated(c::getEntry, ResourceLocation.withDefaultNamespace("item/brick")))
            .register();


    public static final ItemEntry<Item> SAIL = REGISTRATE
            .item("sail", Item::new)
            .model((c, p) -> p.generated(c::getEntry, ResourceLocation.parse("setsail:item/sail")))
            .register();

    public static void register() {
        // Force class loading to trigger Registrate calls
    }
}
