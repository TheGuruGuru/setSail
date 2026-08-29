package com.theGuruGuru.setsail.datagen;

import java.util.concurrent.CompletableFuture;

import com.theGuruGuru.setsail.AllItems;
import com.theGuruGuru.setsail.CreateSetSail;
import com.simibubi.create.api.data.recipe.BaseRecipeProvider.GeneratedRecipe;
import com.simibubi.create.api.data.recipe.WashingRecipeGen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Items;

/**
 * Splashing recipe generator.
 */
public class CreateSetSailWashingRecipeGen extends WashingRecipeGen {

    GeneratedRecipe EXAMPLE = create("setsail_washing",
            b -> b.require(Items.DIRT).output(AllItems.EXAMPLE_ITEM.get()));

    public CreateSetSailWashingRecipeGen(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, CreateSetSail.ID);
    }
}
