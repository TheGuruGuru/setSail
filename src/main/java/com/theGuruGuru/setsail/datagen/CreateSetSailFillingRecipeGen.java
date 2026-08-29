package com.theGuruGuru.setsail.datagen;

import java.util.concurrent.CompletableFuture;

import com.theGuruGuru.setsail.CreateSetSail;
import com.simibubi.create.api.data.recipe.BaseRecipeProvider.GeneratedRecipe;
import com.simibubi.create.api.data.recipe.FillingRecipeGen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.material.Fluids;

/**
 * Filling recipe generator. Shows an item combined with a fluid ingredient; the amount
 * is in millibuckets (1000 mB is one bucket).
 */
public class CreateSetSailFillingRecipeGen extends FillingRecipeGen {

    GeneratedRecipe EXAMPLE = create("setsail_filling", b -> b
            .require(Items.BUCKET)
            .require(Fluids.WATER, 1000)
            .output(Items.WATER_BUCKET));

    public CreateSetSailFillingRecipeGen(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, CreateSetSail.ID);
    }
}
