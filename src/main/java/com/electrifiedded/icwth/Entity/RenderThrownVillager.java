package com.electrifiedded.icwth.Entity;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderVillager;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderThrownVillager extends Render<EntityThrownVillager> {

    private final RenderVillager villagerRenderer;

    public RenderThrownVillager(RenderManager renderManager) {
        super(renderManager);
        this.villagerRenderer = new RenderVillager(renderManager);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityThrownVillager entity) {
        // Возвращаем текстуру Villager
        return new ResourceLocation("textures/entity/villager/villager.png");
    }

    @Override
    public void doRender(EntityThrownVillager entity, double x, double y, double z, float entityYaw, float partialTicks) {
        // Рендерим модель Villager
        villagerRenderer.doRender(new EntityVillager(entity.world), x, y, z, entityYaw, partialTicks);
    }

    public static class Factory implements IRenderFactory<EntityThrownVillager> {
        @Override
        public Render<? super EntityThrownVillager> createRenderFor(RenderManager manager) {
            return new RenderThrownVillager(manager);
        }
    }
}
