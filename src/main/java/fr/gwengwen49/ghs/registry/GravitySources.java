package fr.gwengwen49.ghs.registry;

import fr.gwengwen49.ghs.core.registry.ModRegistries;
import fr.gwengwen49.ghs.core.space.GravitySource;
import fr.gwengwen49.ghs.core.space.SpaceObject;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class GravitySources {

    public static final DeferredRegister<GravitySource<?>> GRAVITY_SOURCES = DeferredRegister.create(ModRegistries.GRAVITY_SOURCES, "ghs");
}
