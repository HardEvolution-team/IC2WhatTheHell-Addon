package com.electrifiedded.icwth.items;

import com.electrifiedded.icwth.models.ModelThrowableVillager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.tileentity.TileEntityItemStackRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class VillagerItemRenderer extends TileEntityItemStackRenderer {

    protected ModelThrowableVillager model = new ModelThrowableVillager(0.0f);

    @Override
    public void renderByItem(ItemStack itemStackIn, float partialTicks) {
        this.renderItem(itemStackIn, ItemCameraTransforms.TransformType.NONE);
    }

    public void renderItem(ItemStack item, ItemCameraTransforms.TransformType type) {
        switch (type) {
            case FIRST_PERSON_LEFT_HAND:
            case FIRST_PERSON_RIGHT_HAND:
            case THIRD_PERSON_LEFT_HAND:
            case THIRD_PERSON_RIGHT_HAND:
            case GROUND:
            case HEAD:
            case FIXED: {
                GlStateManager.pushMatrix();
                Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("weirdthingsmod:textures/entity/villager/farmer.png"));
                GlStateManager.scale(1.5f, 1.5f, 1.5f);
                GlStateManager.rotate(180.0f, 2.0f, 0.0f, 2.0f);
                this.model.render((Entity) null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0625f);
                GlStateManager.popMatrix();
                break;
            }
            default:
                break;
        }
    }
}