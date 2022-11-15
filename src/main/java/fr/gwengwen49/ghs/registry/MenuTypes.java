package fr.gwengwen49.ghs.registry;

import fr.gwengwen49.ghs.blocks.generators.blockentity.GasolineGeneratorBlockEntity;
import fr.gwengwen49.ghs.blocks.generators.inventory.GasolineGeneratorMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.common.extensions.IForgeEntity;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryObject;

public class MenuTypes
{
public static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(ForgeRegistries.MENU_TYPES, "ghs");
public static final RegistryObject<MenuType<GasolineGeneratorMenu>> GASOLINE_GENERATOR_MENU = MENU_TYPES.register("gasoline_generator",() -> new MenuType<>(GasolineGeneratorMenu::new));




}
