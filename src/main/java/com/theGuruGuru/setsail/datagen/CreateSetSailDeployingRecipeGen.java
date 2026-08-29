package com.theGuruGuru.setsail.datagen;

import java.util.concurrent.CompletableFuture;

import com.theGuruGuru.setsail.AllItems;
import com.theGuruGuru.setsail.CreateSetSail;
import com.simibubi.create.api.data.recipe.BaseRecipeProvider.GeneratedRecipe;
import com.simibubi.create.api.data.recipe.DeployingRecipeGen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Items;

/**
 * Deploying recipe generator. A single standalone step, unlike the multi-step
 * sequenced assembly example.
 */
public class CreateSetSailDeployingRecipeGen extends DeployingRecipeGen {

    GeneratedRecipe EXAMPLE = create("setsail_deploying", b -> b
            .require(Items.IRON_INGOT)
            .require(Items.COPPER_INGOT)
            .output(AllItems.EXAMPLE_RESULT.get()));

    public CreateSetSailDeployingRecipeGen(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, CreateSetSail.ID);
    }
}
