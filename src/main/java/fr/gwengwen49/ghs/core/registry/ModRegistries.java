package fr.gwengwen49.ghs.core.registry;

import fr.gwengwen49.ghs.core.space.GravitySource;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.sounds.SoundEventRegistration;
import net.minecraft.client.resources.sounds.SoundEventRegistrationSerializer;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.Musics;
import net.minecraft.sounds.SoundEvents;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistry;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryManager;

public class ModRegistries {

    public static final IForgeRegistry<GravitySource<?>> GRAVITY_SOURCES = RegistryManager.ACTIVE.getRegistry(ModKeys.GRAVITY_SOURCE_KEY);


public static class ModKeys {

        public static final ResourceKey<Registry<GravitySource<?>>> GRAVITY_SOURCE_KEY = key("ghs:gravity_source");
    private static <T> ResourceKey<Registry<T>> key(String name)
    {
        return ResourceKey.createRegistryKey(new ResourceLocation(name));
    }

}
}
