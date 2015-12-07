package com.cout970.magneticraft.client.gui;

import com.cout970.magneticraft.Magneticraft;
import com.cout970.magneticraft.client.gui.component.*;
import com.cout970.magneticraft.tileentity.multiblock.controllers.TileGrinder;
import net.minecraft.inventory.Container;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class GuiGrinder extends GuiBasic {

    public GuiGrinder(Container c, TileEntity tile) {
        super(c, tile);
    }

    @Override
    public void initComponents() {
        comp.add(new CompBackground(new ResourceLocation(Magneticraft.NAME.toLowerCase() + ":textures/gui/grinder.png")));
        comp.add(new CompEnergyBar(new ResourceLocation(Magneticraft.NAME.toLowerCase() + ":textures/gui/energybar.png"), new GuiPoint(23, 16), ((TileGrinder) tile).cond));
        comp.add(new CompProgressBar(new ResourceLocation(Magneticraft.NAME.toLowerCase() + ":textures/gui/progressbar1.png"), new GuiPoint(75, 31), ((TileGrinder) tile).getProgressBar()));
        comp.add(new CompGenericBar(new ResourceLocation(Magneticraft.NAME.toLowerCase() + ":textures/gui/efficiencybar.png"), new GuiPoint(32, 20), ((TileGrinder) tile).getConsumptionBar()));
    }
}