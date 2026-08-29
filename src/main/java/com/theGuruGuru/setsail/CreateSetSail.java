package com.theGuruGuru.setsail;

import java.util.concurrent.CompletableFuture;

import com.theGuruGuru.setsail.content.ponder.CreateSetSailPonderPlugin;
import com.theGuruGuru.setsail.datagen.CreateSetSailCompactingRecipeGen;
import com.theGuruGuru.setsail.datagen.CreateSetSailCrushingRecipeGen;
import com.theGuruGuru.setsail.datagen.CreateSetSailCuttingRecipeGen;
import com.theGuruGuru.setsail.datagen.CreateSetSailDeployingRecipeGen;
import com.theGuruGuru.setsail.datagen.CreateSetSailEmptyingRecipeGen;
import com.theGuruGuru.setsail.datagen.CreateSetSailFillingRecipeGen;
import com.theGuruGuru.setsail.datagen.CreateSetSailLangMerger;
import com.theGuruGuru.setsail.datagen.CreateSetSailHauntingRecipeGen;
import com.theGuruGuru.setsail.datagen.CreateSetSailMillingRecipeGen;
import com.theGuruGuru.setsail.datagen.CreateSetSailMixingRecipeGen;
import com.theGuruGuru.setsail.datagen.CreateSetSailPressingRecipeGen;
import com.theGuruGuru.setsail.datagen.CreateSetSailSequencedAssemblyGen;
import com.theGuruGuru.setsail.datagen.CreateSetSailWashingRecipeGen;
import com.simibubi.create.content.kinetics.base.ShaftVisual;
import com.tterrag.registrate.providers.ProviderType;
import net.createmod.ponder.foundation.PonderIndex;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.item.ItemDescription;
import com.simibubi.create.foundation.item.KineticStats;
import com.simibubi.create.foundation.item.TooltipModifier;
import dev.engine_room.flywheel.lib.visualization.SimpleBlockEntityVisualizer;
import net.createmod.catnip.lang.FontHelper;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(CreateSetSail.ID)
public class CreateSetSail {
    public static final String ID = "setsail";
    public static final Logger LOGGER = LogManager.getLogger(ID);

    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(ID)
            .setTooltipModifierFactory(item ->
                    new ItemDescription.Modifier(item, FontHelper.Palette.STANDARD_CREATE)
                            .andThen(TooltipModifier.mapNull(KineticStats.create(item)))
            );

    public CreateSetSail(IEventBus modBus) {
        REGISTRATE.registerEventListeners(modBus);

        AllCreativeModeTabs.register();
        REGISTRATE.setCreativeTab(AllCreativeModeTabs.MAIN_TAB);
        registerLangPartials();
        registerPonderLang();
        AllItems.register();
        AllDisplaySources.register();
        AllBlocks.register();
        AllBlockEntityTypes.register();

        modBus.addListener(this::onCommonSetup);
        modBus.addListener(this::onClientSetup);
        modBus.addListener(this::onGatherData);
    }

    public static ResourceLocation asResource(String path) {
        return ResourceLocation.fromNamespaceAndPath(ID, path);
    }

    private void onCommonSetup(FMLCommonSetupEvent event) {
        LOGGER.info("Common setup...");
    }

    private void onClientSetup(FMLClientSetupEvent event) {
        LOGGER.info("Client setup...");
        event.enqueueWork(() -> {
            // Ponder is client-only
            PonderIndex.addPlugin(new CreateSetSailPonderPlugin());
        });
    }

    /**
     * Feeds the hand-authored language partials (assets/setsail/lang/default/*.json)
     * into Registrate's lang provider so runData merges them with the generated block and
     * item names into a single en_us.json. Keeps English copy out of Java, mirroring how
     * Create authors its own translations.
     */
    private void registerLangPartials() {
        REGISTRATE.addDataGenerator(ProviderType.LANG, provider ->
                CreateSetSailLangMerger.mergeInto(provider::add));
    }

    /**
     * Feeds the Ponder scenes' text (titles and captions) into Registrate's lang provider
     * so runData writes it into the same en_us.json as the block and item names. The
     * registered callback only runs during data generation, so it is safe to touch the
     * client-only PonderIndex from here.
     */
    private void registerPonderLang() {
        REGISTRATE.addDataGenerator(ProviderType.LANG, provider -> {
            PonderIndex.addPlugin(new CreateSetSailPonderPlugin());
            PonderIndex.getLangAccess().provideLang(ID, provider::add);
        });
    }

    /**
     * Registers the data generators. Running gradlew runData writes their output into
     * src/generated/resources.
     */
    private void onGatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> registries = event.getLookupProvider();

        generator.addProvider(event.includeServer(), new CreateSetSailSequencedAssemblyGen(output, registries));
        generator.addProvider(event.includeServer(), new CreateSetSailWashingRecipeGen(output, registries));
        generator.addProvider(event.includeServer(), new CreateSetSailHauntingRecipeGen(output, registries));
        generator.addProvider(event.includeServer(), new CreateSetSailCrushingRecipeGen(output, registries));
        generator.addProvider(event.includeServer(), new CreateSetSailMillingRecipeGen(output, registries));
        generator.addProvider(event.includeServer(), new CreateSetSailPressingRecipeGen(output, registries));
        generator.addProvider(event.includeServer(), new CreateSetSailCuttingRecipeGen(output, registries));
        generator.addProvider(event.includeServer(), new CreateSetSailMixingRecipeGen(output, registries));
        generator.addProvider(event.includeServer(), new CreateSetSailCompactingRecipeGen(output, registries));
        generator.addProvider(event.includeServer(), new CreateSetSailFillingRecipeGen(output, registries));
        generator.addProvider(event.includeServer(), new CreateSetSailEmptyingRecipeGen(output, registries));
        generator.addProvider(event.includeServer(), new CreateSetSailDeployingRecipeGen(output, registries));
    }
}
