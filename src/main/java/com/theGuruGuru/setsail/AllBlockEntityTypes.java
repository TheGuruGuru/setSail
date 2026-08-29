package com.theGuruGuru.setsail;

import com.theGuruGuru.setsail.content.kinetics.CreateSetSailGeneratorBlockEntity;
import com.theGuruGuru.setsail.content.kinetics.CreateSetSailKineticBlockEntity;
import com.theGuruGuru.setsail.content.kinetics.CreateSetSailShaftRenderer;
import com.simibubi.create.content.kinetics.base.ShaftVisual;
import com.tterrag.registrate.util.entry.BlockEntityEntry;

/**
 * Block entity type registration.
 */
public class AllBlockEntityTypes {

    /**
     * Block entity for EXAMPLE_KINETIC_BLOCK, rendered with CreateSetSailShaftRenderer so a
     * shaft visibly spins through the casing.
     */
    public static final BlockEntityEntry<CreateSetSailKineticBlockEntity> EXAMPLE_KINETIC = CreateSetSail.REGISTRATE
            .blockEntity("setsail_kinetic", CreateSetSailKineticBlockEntity::new)
            // visual for flywheel renderer
            .visual(() -> ShaftVisual::new)
            .validBlock(AllBlocks.EXAMPLE_KINETIC_BLOCK)
            // fallback renderer if flywheel is not available
            .renderer(() -> CreateSetSailShaftRenderer::new)
            .register();

    /**
     * Block entity for EXAMPLE_GENERATOR_BLOCK, also rendered with CreateSetSailShaftRenderer.
     */
    public static final BlockEntityEntry<CreateSetSailGeneratorBlockEntity> EXAMPLE_GENERATOR = CreateSetSail.REGISTRATE
            .blockEntity("setsail_generator", CreateSetSailGeneratorBlockEntity::new)
            .visual(() -> ShaftVisual::new)
            .validBlock(AllBlocks.EXAMPLE_GENERATOR_BLOCK)
            .renderer(() -> CreateSetSailShaftRenderer::new)
            .register();

    public static void register() {
        // Force class loading to trigger Registrate calls
    }
}
