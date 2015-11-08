package com.cout970.magneticraft.client.itemrenderer;

import com.cout970.magneticraft.client.model.ModelPumpjack;
import com.cout970.magneticraft.client.tilerender.ModelTextures;
import com.cout970.magneticraft.util.RenderUtil;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

public class ItemRenderPumpJack implements IItemRenderer {

    public ModelPumpjack model = new ModelPumpjack();

    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type) {
        return true;
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item,
                                         ItemRendererHelper helper) {
        return true;
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
        switch (type) {
            case ENTITY: {
                render(0.0F, 0.5F, 0.0F, 0.5F, item);
                return;
            }
            case EQUIPPED: {
                render(1.0F, 0.0F, 1.0F, 0.5F, item);
                return;
            }
            case INVENTORY: {
                render(1.5F, -0.75F, 0.0F, 0.5F, item);
                return;
            }
            case EQUIPPED_FIRST_PERSON: {
                render(0.5F, 0.0F, 0.5F, 0.5F, item);
            }
        }
    }

    public void render(float x, float y, float z, float scale, ItemStack i) {
        GL11.glPushMatrix();
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glScalef(scale, scale, scale);
        GL11.glTranslatef(x, y, z);
        GL11.glRotatef(180F, 0, 0, 1);
        GL11.glRotatef(-45f, 0, 1, 0);
        GL11.glTranslatef(0, -1.5f, 0);
        RenderUtil.bindTexture(ModelTextures.PUMPJACK);
        model.render(0.0625f, 0, 0);

        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glPopMatrix();
    }

}
