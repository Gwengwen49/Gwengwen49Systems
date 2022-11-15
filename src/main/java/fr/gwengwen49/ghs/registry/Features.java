package fr.gwengwen49.ghs.registry;

import com.google.common.base.Suppliers;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.Objects;

public class Features {
    public static final DeferredRegister<ConfiguredFeature<?, ?>> FEATURES = DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, "ghs");

    public static final RegistryObject<ConfiguredFeature<?, ?>> TUNGSTEN_ORE_FEATURE = FEATURES.register("tungsten_ore", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(Objects.requireNonNull(Suppliers.memoize(() -> List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, Blocks.TUNGSTEN_ORE.get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, Blocks.DEEPSLATE_TUNGSTEN_ORE.get().defaultBlockState()))).get()), 8)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> TITANIUM_ORE_FEATURE = FEATURES.register("titanium_ore", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(Objects.requireNonNull(Suppliers.memoize(() -> List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, Blocks.TITANIUM_ORE.get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, Blocks.DEEPSLATE_TITANIUM_ORE.get().defaultBlockState()))).get()), 8)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> TIN_ORE_FEATURE = FEATURES.register("tin_ore", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(Objects.requireNonNull(Suppliers.memoize(() -> List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, Blocks.TIN_ORE.get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, Blocks.DEEPSLATE_TIN_ORE.get().defaultBlockState()))).get()), 8)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> ALUMINIUM_ORE_FEATURE = FEATURES.register("aluminium_ore", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(Objects.requireNonNull(Suppliers.memoize(() -> List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, Blocks.ALUMINIUM_ORE.get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, Blocks.DEEPSLATE_ALUMINIUM_ORE.get().defaultBlockState()))).get()), 8)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> NICKEL_ORE_FEATURE = FEATURES.register("nickel_ore", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(Objects.requireNonNull(Suppliers.memoize(() -> List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, Blocks.NICKEL_ORE.get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, Blocks.DEEPSLATE_NICKEL_ORE.get().defaultBlockState()))).get()), 8)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> SILVER_ORE_FEATURE = FEATURES.register("silver_ore", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(Objects.requireNonNull(Suppliers.memoize(() -> List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, Blocks.SILVER_ORE.get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, Blocks.DEEPSLATE_SILVER_ORE.get().defaultBlockState()))).get()), 8)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> ZINC_ORE_FEATURE = FEATURES.register("zinc_ore", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(Objects.requireNonNull(Suppliers.memoize(() -> List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, Blocks.ZINC_ORE.get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, Blocks.DEEPSLATE_ZINC_ORE.get().defaultBlockState()))).get()), 8)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> LEAD_ORE_FEATURE = FEATURES.register("lead_ore", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(Objects.requireNonNull(Suppliers.memoize(() -> List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, Blocks.LEAD_ORE.get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, Blocks.DEEPSLATE_LEAD_ORE.get().defaultBlockState()))).get()), 8)));

}
