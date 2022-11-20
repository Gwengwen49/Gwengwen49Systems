package fr.gwengwen49.ghs.data.tags;

import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import org.jetbrains.annotations.Nullable;

public class ModBiomeTagsProvider extends TagsProvider<Biome> {


    public ModBiomeTagsProvider(DataGenerator p_126546_, ExistingFileHelper helper) {
        super(p_126546_, BuiltinRegistries.BIOME, "ghs", helper);

    }

    @Override
    protected void addTags() {
        this.tag(ModBiomeTags.IS_MOON).add(Biomes.DESERT);
    }
}
