package fr.gwengwen49.ghs.registry;

import fr.gwengwen49.ghs.GHS;
import fr.gwengwen49.ghs.core.music.PlayMusicPredicate;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.Music;
import java.util.ArrayList;
import java.util.List;

public class PlayMusicPredicates {
    public static final List<PlayMusicPredicate> PREDICATES = new ArrayList<>();

    public static final PlayMusicPredicate PLAY_MOON_MUSICS_PREDICATE = (mc, event) -> {

        if(mc.level.dimension() == GHS.MOON_LEVEL) {
            for (Music music : Musics.getMoonMusics()) {
                if (!event.getSound().getLocation().equals(music.getEvent().getLocation())) {
                    return true;
                }
                else if(event.getSound().getLocation().equals(music.getEvent().getLocation())) {
                    GHS.MC_INSTANCE.player.sendSystemMessage(Component.literal("SUCCESSFULLY launched Music"+music.getEvent().getLocation()));
                    return false;
                }
                else {
                    return false;
                }
            }
        }
        return false;

    };

    public static List<PlayMusicPredicate> getAll(){
        PREDICATES.add(PLAY_MOON_MUSICS_PREDICATE);
        return PREDICATES;
    }
}
