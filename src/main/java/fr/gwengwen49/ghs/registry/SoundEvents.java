package fr.gwengwen49.ghs.registry;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SoundEvents {

    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, "ghs");

    public static final RegistryObject<SoundEvent> MOON_SOUND_ONE_EVENT = SOUND_EVENTS.register("moon_music_one", () -> new SoundEvent(new ResourceLocation("ghs", "moon_music_one")));
    public static final RegistryObject<SoundEvent> MOON_SOUND_TWO_EVENT = SOUND_EVENTS.register("moon_music_two", () -> new SoundEvent(new ResourceLocation("ghs", "moon_music_two")));
    public static final RegistryObject<SoundEvent> MOON_SOUND_THREE_EVENT = SOUND_EVENTS.register("moon_music_three", () -> new SoundEvent(new ResourceLocation("ghs", "moon_music_three")));


}
