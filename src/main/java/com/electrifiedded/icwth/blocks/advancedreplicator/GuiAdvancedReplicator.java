//package com.electrifiedded.icwth.advancedreplicator;
//
//import net.minecraft.client.gui.inventory.GuiContainer;
//import net.minecraft.client.renderer.GlStateManager;
//import net.minecraft.entity.player.InventoryPlayer;
//import net.minecraft.util.ResourceLocation;
//import net.minecraftforge.fluids.FluidTank;
//
//public class GuiAdvancedReplicator extends GuiContainer {
//
//    private static final ResourceLocation TEXTURE = new ResourceLocation("advancedreplicator", "textures/gui/advanced_replicator.png");
//    private final TileEntityAdvancedReplicator tileEntity;
//
//    public GuiAdvancedReplicator(InventoryPlayer playerInventory, TileEntityAdvancedReplicator tileEntity) {
//        super(new ContainerAdvancedReplicator(playerInventory, tileEntity));
//        this.tileEntity = tileEntity;
//        this.xSize = 184;
//        this.ySize = 166;
//    }
//
//
//
//
//    @Override
//    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
//        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
//        this.mc.getTextureManager().bindTexture(TEXTURE);
//        int x = (this.width - this.xSize) / 2;
//        int y = (this.height - this.ySize) / 2;
//        this.drawTexturedModalRect(x, y, 0, 0, this.xSize, this.ySize);
//
//        // Отрисовка уровня жидкости
//        FluidTank tank = tileEntity.fluidTank;
//        if (tank.getFluidAmount() > 0) {
//            int fluidHeight = (int) (50 * ((float) tank.getFluidAmount() / tank.getCapacity()));
//            this.drawTexturedModalRect(x + 27, y + 30 + (50 - fluidHeight), 184, 0, 16, fluidHeight);
//        }
//    }
//
//    @Override
//    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
//        String title = "Advanced Replicator";
//        this.fontRenderer.drawString(title, this.xSize / 2 - this.fontRenderer.getStringWidth(title) / 2, 6, 4210752);
//
//        // Отрисовка информации о процессе
//        if (tileEntity.pattern != null) {
//            String progress = String.format("Progress: %.1f%%", (tileEntity.uuProcessed / tileEntity.patternUu) * 100);
//            this.fontRenderer.drawString(progress, 50, 36, 4210752);
//        }
//    }
//}