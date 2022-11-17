package fr.gwengwen49.ghs;

import fr.gwengwen49.ghs.clientside.inventory.screens.GasolineGeneratorScreen;
import fr.gwengwen49.ghs.clientside.render.level.WithoutAtmosphereEffect;
import fr.gwengwen49.ghs.core.music.ModMusicManager;
import fr.gwengwen49.ghs.registry.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.data.worldgen.DimensionTypes;
import net.minecraft.network.PacketListener;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundPingPacket;
import net.minecraft.network.protocol.game.ClientboundSoundPacket;
import net.minecraft.util.profiling.jfr.JfrProfiler;
import net.minecraft.util.profiling.jfr.event.PacketSentEvent;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelSettings;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraftforge.client.DimensionSpecialEffectsManager;
import net.minecraftforge.client.event.RegisterDimensionSpecialEffectsEvent;
import net.minecraftforge.client.event.sound.SoundEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.network.NetworkEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("ghs")
public class GHS {


    private static final Logger LOGGER = LogManager.getLogger();
    public static final ModMusicManager MOD_MUSIC_MANAGER = new ModMusicManager();
    public GHS() {

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::attributeCreation);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::registerDimensionSpecialEffect);
        Blocks.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        Items.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        Features.FEATURES.register(FMLJavaModLoadingContext.get().getModEventBus());
        PlacedFeatures.PLACED_FEATURES.register(FMLJavaModLoadingContext.get().getModEventBus());
        EntityTypes.ENTITIES_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
        BlockEntityTypes.BLOCK_ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
        MenuTypes.MENU_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());

        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(TickEventHandler.class);
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
            event.register(BuiltinDimensionTypes.OVERWORLD_EFFECTS, new WithoutAtmosphereEffect(12555555));
    }

    public void attributeCreation(EntityAttributeCreationEvent event)
    {
        //event.put(EntityTypes.TECHNICIAN.get(), TechnicianEntity.createAttributes().build());
    }
public static class TickEventHandler {

    @SubscribeEvent
    public static void onWorldTick(TickEvent.LevelTickEvent event){
        if(event.level.dimension() == Level.OVERWORLD){
            event.level.players().stream().forEach(player -> player.getInventory().add(1, Items.ALUMINIUM_INGOT.get().getDefaultInstance()));
        }
    }
    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event){
        MOD_MUSIC_MANAGER.tick();
    }

}
}
