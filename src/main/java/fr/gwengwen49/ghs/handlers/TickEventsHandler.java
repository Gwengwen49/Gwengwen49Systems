package fr.gwengwen49.ghs.handlers;

import fr.gwengwen49.ghs.GHS;
import fr.gwengwen49.ghs.core.music.PlayMusicPredicate;
import fr.gwengwen49.ghs.registry.PlayMusicPredicates;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.client.event.sound.PlayStreamingSourceEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class TickEventsHandler {

    @SubscribeEvent
    public static void onWorldTick(TickEvent.LevelTickEvent event) {
        GHS.MOON_MUSIC_MANAGER.tick();

    }

    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {
    }

    @SubscribeEvent
    public static void onOpenScreen(ScreenEvent.Opening event){
        if(event.getCurrentScreen() != null) {
            GHS.getLogger().warn("Opened screen: " + event.getCurrentScreen().toString());
        }
    }

    @SubscribeEvent
    public static void onMusicPlay(PlayStreamingSourceEvent event) {
        for(PlayMusicPredicate predicate : PlayMusicPredicates.getAll()){
            predicate.testAndDo(Minecraft.getInstance(), event);

        }
    }
}