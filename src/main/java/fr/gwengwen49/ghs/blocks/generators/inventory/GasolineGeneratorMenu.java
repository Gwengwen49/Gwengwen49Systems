package fr.gwengwen49.ghs.blocks.generators.inventory;

import fr.gwengwen49.ghs.GHS;
import fr.gwengwen49.ghs.registry.MenuTypes;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.RecipeBookType;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.RecipeType;

public class GasolineGeneratorMenu extends AbstractGeneratorMenu
{
    public GasolineGeneratorMenu(int p_38963_, Inventory p_38964_)
    {
        super(MenuTypes.GASOLINE_GENERATOR_MENU.get(), p_38963_, p_38964_);
    }

    public GasolineGeneratorMenu(int i, Inventory inventory, Container container , ContainerData data)
    {
        super(MenuTypes.GASOLINE_GENERATOR_MENU.get(), i, inventory, container, data);
    }
}
