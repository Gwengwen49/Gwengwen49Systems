package fr.gwengwen49.ghs.core.music;

import net.minecraft.client.Minecraft;
import net.minecraft.sounds.Music;
import net.minecraft.util.RandomSource;

import java.util.ArrayList;
import java.util.List;

public interface ModMusicManager {

    RandomSource random = RandomSource.create();


    void tick();

    void startPlaying(Music music);

    void stopPlaying();

    boolean isPlayingMusic(Music music);


}
