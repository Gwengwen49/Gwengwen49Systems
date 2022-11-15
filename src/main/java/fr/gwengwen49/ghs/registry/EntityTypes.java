package fr.gwengwen49.ghs.registry;

import fr.gwengwen49.ghs.entities.TechnicianEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.client.model.renderable.IRenderable;
import net.minecraftforge.common.extensions.IForgeEntity;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EntityTypes
{
    public static final DeferredRegister<EntityType<?>> ENTITIES_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, "ghs");
    public static final RegistryObject<EntityType<TechnicianEntity>> TECHNICIAN = ENTITIES_TYPES.register("technician", () -> EntityType.Builder.of(TechnicianEntity::new, MobCategory.MISC).clientTrackingRange(16).build("technician"));



}
