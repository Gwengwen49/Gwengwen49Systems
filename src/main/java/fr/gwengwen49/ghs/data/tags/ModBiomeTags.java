package fr.gwengwen49.ghs.data.tags;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;

public class ModBiomeTags {

    public static final TagKey<Biome> IS_MOON = create("is_moon");
    private static TagKey<Biome> create(String key) {
        return TagKey.create(Registry.BIOME_REGISTRY, new ResourceLocation("ghs", key));
    }
}
