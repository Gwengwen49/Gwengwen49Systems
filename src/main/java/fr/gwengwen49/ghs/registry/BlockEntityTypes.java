package fr.gwengwen49.ghs.registry;

import fr.gwengwen49.ghs.blocks.generators.blockentity.GasolineGeneratorBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockEntityTypes
{
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, "ghs");


    public static final RegistryObject<BlockEntityType<GasolineGeneratorBlockEntity>> GASOLINE_GENERATOR_BLOCK_ENTITY = BLOCK_ENTITIES.register("gasoline_generator", () -> BlockEntityType.Builder.of(GasolineGeneratorBlockEntity::new, Blocks.GASOLINE_GENERATOR.get()).build(null));









}
