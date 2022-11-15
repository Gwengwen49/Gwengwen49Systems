package fr.gwengwen49.ghs.core.fluid;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.FluidState;

import java.util.function.Supplier;

public class BasicContainerFluid extends ContainerFluidBlock {


    public BasicContainerFluid(Supplier<? extends FlowingFluid> p_54694_, Properties p_54695_, ResourceLocation containerTextureLocation) {
        super(p_54694_, p_54695_, containerTextureLocation);
    }
}
