package com.theGuruGuru.setsail.content.ponder;

import com.theGuruGuru.setsail.AllBlocks;
import com.theGuruGuru.setsail.CreateSetSail;

import net.createmod.ponder.api.registration.PonderPlugin;
import net.createmod.ponder.api.registration.PonderSceneRegistrationHelper;
import net.minecraft.resources.ResourceLocation;

/**
 * Ponder plugin for the addon, registered client-side in CreateSetSail. registerScenes
 * associates a storyboard with one or more items. Each scene has two parts: a schematic
 * saved as an nbt file under assets/setsail/ponder, whose name matches the id passed
 * to addStoryBoard, and the storyboard code in CreateSetSailPonderScenes.
 */
public class CreateSetSailPonderPlugin implements PonderPlugin {

    @Override
    public String getModId() {
        return CreateSetSail.ID;
    }

    @Override
    public void registerScenes(PonderSceneRegistrationHelper<ResourceLocation> helper) {
        helper.forComponents(AllBlocks.EXAMPLE_KINETIC_BLOCK.getId())
                .addStoryBoard("setsail_ponder", CreateSetSailPonderScenes::examplePonder);

        helper.forComponents(com.simibubi.create.AllBlocks.DESK_BELL.getId())
                .addStoryBoard("desk_bell", DeskbellScenes::intro);
    }
}
