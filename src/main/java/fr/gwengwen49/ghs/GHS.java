package fr.gwengwen49.ghs;

import fr.gwengwen49.ghs.clientside.inventory.screens.GasolineGeneratorScreen;
import fr.gwengwen49.ghs.registry.*;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.client.event.RegisterDimensionSpecialEffectsEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("ghs")
public class GHS {


    private static final Logger LOGGER = LogManager.getLogger();

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
        //event.register(BuiltinDimensionTypes.OVERWORLD_EFFECTS, new PlanetEffects());
    }


    public void attributeCreation(EntityAttributeCreationEvent event)
    {
        //event.put(EntityTypes.TECHNICIAN.get(), TechnicianEntity.createAttributes().build());
    }

}
