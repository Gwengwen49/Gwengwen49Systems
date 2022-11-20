package fr.gwengwen49.ghs.registry;

import net.minecraft.sounds.Music;

public class Musics {
    public static final Music MOON_MUSIC_ONE = new Music(SoundEvents.MOON_SOUND_ONE_EVENT.get(), 6000, 24000, false);
    public static final Music MOON_MUSIC_TWO = new Music(SoundEvents.MOON_SOUND_TWO_EVENT.get(), 6000, 24000, false);
    public static final Music MOON_MUSIC_THREE = new Music(SoundEvents.MOON_SOUND_THREE_EVENT.get(), 6000, 24000, false);

    public static Music[] getMoonMusics(){
        return new Music[]{
                MOON_MUSIC_ONE,
                MOON_MUSIC_TWO,
                MOON_MUSIC_THREE
        };
    }
}
