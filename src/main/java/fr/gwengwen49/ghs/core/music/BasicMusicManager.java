package fr.gwengwen49.ghs.core.music;

import fr.gwengwen49.ghs.GHS;
import fr.gwengwen49.ghs.registry.SoundEvents;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.client.sounds.MusicManager;
import net.minecraft.client.sounds.SoundManager;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.Music;
import net.minecraft.sounds.Musics;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.sound.SoundEngineLoadEvent;

import javax.annotation.Nullable;
import java.util.function.Supplier;

@OnlyIn(Dist.CLIENT)
public class BasicMusicManager implements ModMusicManager{

    @Nullable
    private SoundInstance currentMusic;
    private int nextSongDelay = 100;
    private Supplier<Music[]> musics;
    private ResourceKey<Level> dimension;
    private Minecraft minecraft;
    public BasicMusicManager(Supplier<Music[]> musics, ResourceKey<Level> dimension, Minecraft minecraft) {
    this.musics = musics;
    this.dimension = dimension;
    this.minecraft = minecraft;
    }
    public void tick() {
            if (minecraft.level != null) {
                if (minecraft.level.dimension().equals(this.dimension)) {
                    Music music = musics.get()[random.nextInt(musics.get().length)];
                    if (this.currentMusic != null) {
                        if (!music.getEvent().getLocation().equals(this.currentMusic.getLocation()) && music.replaceCurrentMusic()) {
                            this.minecraft.getSoundManager().stop(this.currentMusic);
                            this.nextSongDelay = Mth.nextInt(this.random, 0, music.getMinDelay() / 2);
                        }

                        if (!this.minecraft.getSoundManager().isActive(this.currentMusic)) {
                            this.currentMusic = null;
                            this.nextSongDelay = Math.min(this.nextSongDelay, Mth.nextInt(this.random, music.getMinDelay(), music.getMaxDelay()));
                        }
                    }

                    this.nextSongDelay = Math.min(this.nextSongDelay, music.getMaxDelay());
                    if (this.currentMusic == null && this.nextSongDelay-- <= 0) {
                        this.startPlaying(music);
                    }
                }
                else {
                }
            }
    }
    public void startPlaying(Music p_120185_) {
        this.currentMusic = SimpleSoundInstance.forMusic(p_120185_.getEvent());
        if (this.currentMusic.getSound() != SoundManager.EMPTY_SOUND) {
            this.minecraft.getSoundManager().play(this.currentMusic);
        }

        this.nextSongDelay = Integer.MAX_VALUE;
    }

    public void stopPlaying() {
        if (this.currentMusic != null) {
            this.minecraft.getSoundManager().stop(this.currentMusic);
            this.currentMusic = null;
        }

        this.nextSongDelay += 100;
    }

    public boolean isPlayingMusic(Music p_120188_) {
        return this.currentMusic == null ? false : p_120188_.getEvent().getLocation().equals(this.currentMusic.getLocation());
    }

    public ResourceKey<Level> getDimension() {
        return dimension;
    }

    public Supplier<Music[]> getMusics() {
        return musics;
    }
}
