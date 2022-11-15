package fr.gwengwen49.ghs.clientside.inventory.screens;

import fr.gwengwen49.ghs.blocks.generators.inventory.GasolineGeneratorMenu;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class GasolineGeneratorScreen extends AbstractGeneratorScreen<GasolineGeneratorMenu>
{
    private static final ResourceLocation TEXTURE = new ResourceLocation("ghs","textures/gui/container/gasoline_generator.png");

    public GasolineGeneratorScreen(GasolineGeneratorMenu p_98776_, Inventory p_98777_, Component p_98778_)
    {
        super(p_98776_, p_98777_, p_98778_, TEXTURE);
    }

}
