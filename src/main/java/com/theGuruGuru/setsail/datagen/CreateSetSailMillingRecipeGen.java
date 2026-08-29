package com.theGuruGuru.setsail.datagen;

import java.util.concurrent.CompletableFuture;

import com.theGuruGuru.setsail.CreateSetSail;
import com.simibubi.create.api.data.recipe.BaseRecipeProvider.GeneratedRecipe;
import com.simibubi.create.api.data.recipe.MillingRecipeGen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Items;

/**
 * Milling recipe generator.
 */
public class CreateSetSailMillingRecipeGen extends MillingRecipeGen {

    GeneratedRecipe EXAMPLE = create("setsail_milling", b -> b
            .require(Items.COBBLESTONE)
            .output(Items.SAND)
            .duration(100));

    public CreateSetSailMillingRecipeGen(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, CreateSetSail.ID);
    }
}
