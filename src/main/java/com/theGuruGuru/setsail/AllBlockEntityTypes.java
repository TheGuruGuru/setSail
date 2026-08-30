package com.theGuruGuru.setsail;

import com.simibubi.create.foundation.data.CreateRegistrate;
import com.theGuruGuru.setsail.content.blocks.ropeRelay.RopeRelayBlockEntity;
import com.theGuruGuru.setsail.content.blocks.ropeRelay.RopeRelayRenderer;
import com.theGuruGuru.setsail.content.kinetics.CreateSetSailGeneratorBlockEntity;
import com.theGuruGuru.setsail.content.kinetics.CreateSetSailKineticBlockEntity;
import com.theGuruGuru.setsail.content.kinetics.CreateSetSailShaftRenderer;
import com.simibubi.create.content.kinetics.base.ShaftVisual;
import com.tterrag.registrate.util.entry.BlockEntityEntry;
import dev.simulated_team.simulated.content.blocks.rope.rope_winch.RopeWinchBlockEntity;
import dev.simulated_team.simulated.content.blocks.rope.rope_winch.RopeWinchRenderer;
import dev.simulated_team.simulated.index.SimBlocks;

/**
 * Block entity type registration.
 */
public class AllBlockEntityTypes {

    public static final CreateRegistrate REGISTRATE = CreateSetSail.REGISTRATE;

    public static final BlockEntityEntry<RopeRelayBlockEntity> ROPE_RELAY = REGISTRATE
            .blockEntity("rope_relay", RopeRelayBlockEntity::new)
            .validBlocks(AllBlocks.ROPE_RELAY)
            .renderer(() -> RopeRelayRenderer::new)
            .register();

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
