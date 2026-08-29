package com.theGuruGuru.setsail.datagen;

import java.util.concurrent.CompletableFuture;

import com.theGuruGuru.setsail.AllItems;
import com.theGuruGuru.setsail.CreateSetSail;
import com.simibubi.create.api.data.recipe.BaseRecipeProvider.GeneratedRecipe;
import com.simibubi.create.api.data.recipe.HauntingRecipeGen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;

/**
 * Haunting recipe generator. The convert helper is shorthand for a single-input,
 * single-output recipe.
 */
public class CreateSetSailHauntingRecipeGen extends HauntingRecipeGen {

    GeneratedRecipe EXAMPLE = convert(AllItems.EXAMPLE_ITEM.get(), AllItems.EXAMPLE_RESULT.get());

    public CreateSetSailHauntingRecipeGen(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, CreateSetSail.ID);
    }
}
