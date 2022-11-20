package fr.gwengwen49.ghs.core.music;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.Music;
import net.minecraft.world.level.Level;
import net.minecraftforge.client.event.sound.PlayStreamingSourceEvent;
import net.minecraftforge.common.util.TriPredicate;

import java.util.List;
import java.util.function.BiPredicate;

public interface PlayMusicPredicate extends BiPredicate<Minecraft, PlayStreamingSourceEvent> {

    boolean test(Minecraft mc, PlayStreamingSourceEvent event);

    default void testAndDo(Minecraft mc, PlayStreamingSourceEvent event){
        if(mc != null) {
            if (mc.level != null) {
                if (this.test(mc, event)) {
                    event.getEngine().stop(event.getSound());
                    event.getEngine().tick(true);
                    Minecraft.getInstance().player.sendSystemMessage(Component.literal("STOPPED VANILLA SOUND : " + event.getSound().getLocation()));

                }
            }
        }

    }

}
