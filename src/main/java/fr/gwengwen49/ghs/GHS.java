package fr.gwengwen49.ghs;

import fr.gwengwen49.ghs.clientside.inventory.screens.GasolineGeneratorScreen;
import fr.gwengwen49.ghs.clientside.render.level.WithoutAtmosphereEffect;
import fr.gwengwen49.ghs.core.music.BasicMusicManager;
import fr.gwengwen49.ghs.core.music.PlayMusicPredicate;
import fr.gwengwen49.ghs.data.tags.ModBiomeTagsProvider;
import fr.gwengwen49.ghs.handlers.TickEventsHandler;
import fr.gwengwen49.ghs.registry.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.gui.screens.multiplayer.WarningScreen;
import net.minecraft.client.gui.screens.worldselection.CreateWorldScreen;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.client.resources.sounds.Sound;
import net.minecraft.client.sounds.MusicManager;
import net.minecraft.client.sounds.SoundEngine;
import net.minecraft.client.sounds.SoundManager;
import net.minecraft.core.Registry;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.commands.StopSoundCommand;
import net.minecraft.server.packs.resources.PreparableReloadListener;
import net.minecraft.sounds.Music;
import net.minecraft.world.item.RecordItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.block.JukeboxBlock;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.client.event.RegisterDimensionSpecialEffectsEvent;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.client.event.sound.PlaySoundEvent;
import net.minecraftforge.client.event.sound.PlaySoundSourceEvent;
import net.minecraftforge.client.event.sound.PlayStreamingSourceEvent;
import net.minecraftforge.common.*;
import net.minecraftforge.common.world.BiomeSpecialEffectsBuilder;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.event.PlayLevelSoundEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("ghs")
public class GHS {


    private static final Logger LOGGER = LogManager.getLogger();
    public static Minecraft MC_INSTANCE;
    public static final ResourceKey<Level> MOON_LEVEL = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation("ghs", "moon"));
    public static final ResourceLocation MOON_EFFECTS = new ResourceLocation("ghs", "moon_effects");
    public static final BasicMusicManager MOON_MUSIC_MANAGER = new BasicMusicManager(Musics::getMoonMusics, MOON_LEVEL, Minecraft.getInstance());

    public GHS() {
        MC_INSTANCE = Minecraft.getInstance();
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::attributeCreation);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::registerDimensionSpecialEffect);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::gatherData);
        Blocks.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        Items.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        Features.FEATURES.register(FMLJavaModLoadingContext.get().getModEventBus());
        PlacedFeatures.PLACED_FEATURES.register(FMLJavaModLoadingContext.get().getModEventBus());
        EntityTypes.ENTITIES_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
        BlockEntityTypes.BLOCK_ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
        MenuTypes.MENU_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
        SoundEvents.SOUND_EVENTS.register(FMLJavaModLoadingContext.get().getModEventBus());
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(TickEventsHandler.class);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
    }

    private void clientSetup(final FMLClientSetupEvent event)
    {
        MenuScreens.register(MenuTypes.GASOLINE_GENERATOR_MENU.get(), GasolineGeneratorScreen::new);
    }

    private void registerDimensionSpecialEffect(RegisterDimensionSpecialEffectsEvent event)
    {
            event.register(MOON_EFFECTS, new WithoutAtmosphereEffect(12555555));
    }

    private void gatherData(GatherDataEvent event){
        event.getGenerator().addProvider(event.includeServer(), new ModBiomeTagsProvider(event.getGenerator(), event.getExistingFileHelper()));
    }
    private void attributeCreation(EntityAttributeCreationEvent event)
    {
        //event.put(EntityTypes.TECHNICIAN.get(), TechnicianEntity.createAttributes().build());
    }

    public static Logger getLogger() {
        return LOGGER;
    }


}
