package fr.gwengwen49.ghs.registry;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.client.gui.screens.Overlay;
import net.minecraft.client.gui.screens.inventory.EffectRenderingInventoryScreen;
import net.minecraft.core.Registry;
import net.minecraft.sounds.Musics;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.client.event.RegisterGuiOverlaysEvent;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class PlacedFeatures {

    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES = DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, "ghs");
    public static final RegistryObject<PlacedFeature> TUNGSTEN_ORE_PLACED_FEATURE = PLACED_FEATURES.register("tungsten_ore_placed", () -> new PlacedFeature(Features.TUNGSTEN_ORE_FEATURE.getHolder().get(), commonOrePlacement(7, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(30)))));
    public static final RegistryObject<PlacedFeature> TITANIUM_ORE_PLACED_FEATURE = PLACED_FEATURES.register("titanium_ore_placed", () -> new PlacedFeature(Features.TITANIUM_ORE_FEATURE.getHolder().get(), commonOrePlacement(7, HeightRangePlacement.triangle(VerticalAnchor.absolute(-30), VerticalAnchor.absolute(41)))));
    public static final RegistryObject<PlacedFeature> TIN_ORE_PLACED_FEATURE = PLACED_FEATURES.register("tin_ore_placed", () -> new PlacedFeature(Features.TIN_ORE_FEATURE.getHolder().get(), commonOrePlacement(7, HeightRangePlacement.triangle(VerticalAnchor.absolute(-30), VerticalAnchor.absolute(41)))));
    public static final RegistryObject<PlacedFeature> ALUMINIUM_ORE_PLACED_FEATURE = PLACED_FEATURES.register("aluminium_ore_placed", () -> new PlacedFeature(Features.ALUMINIUM_ORE_FEATURE.getHolder().get(), commonOrePlacement(7, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(30)))));
    public static final RegistryObject<PlacedFeature> NICKEL_ORE_PLACED_FEATURE = PLACED_FEATURES.register("nickel_ore_placed", () -> new PlacedFeature(Features.NICKEL_ORE_FEATURE.getHolder().get(), commonOrePlacement(7, HeightRangePlacement.triangle(VerticalAnchor.absolute(-30), VerticalAnchor.absolute(41)))));
    public static final RegistryObject<PlacedFeature> SILVER_ORE_PLACED_FEATURE = PLACED_FEATURES.register("silver_ore_placed", () -> new PlacedFeature(Features.SILVER_ORE_FEATURE.getHolder().get(), commonOrePlacement(7, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(30)))));
    public static final RegistryObject<PlacedFeature> ZINC_ORE_PLACED_FEATURE = PLACED_FEATURES.register("zinc_ore_placed", () -> new PlacedFeature(Features.ZINC_ORE_FEATURE.getHolder().get(), commonOrePlacement(7, HeightRangePlacement.triangle(VerticalAnchor.absolute(-30), VerticalAnchor.absolute(41)))));
    public static final RegistryObject<PlacedFeature> LEAD_ORE_PLACED_FEATURE = PLACED_FEATURES.register("lead_ore_placed", () -> new PlacedFeature(Features.LEAD_ORE_FEATURE.getHolder().get(), commonOrePlacement(7, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(30)))));

    private static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
        return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
    }

    private static List<PlacementModifier> commonOrePlacement(int p_195344_, PlacementModifier p_195345_) {
        return orePlacement(CountPlacement.of(p_195344_), p_195345_);
    }

    private static List<PlacementModifier> rareOrePlacement(int p_195350_, PlacementModifier p_195351_) {
        return orePlacement(RarityFilter.onAverageOnceEvery(p_195350_), p_195351_);
    }

}
