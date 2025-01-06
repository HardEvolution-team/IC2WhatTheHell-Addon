//package com.electrifiedded.icwth;
//
//
//import net.minecraft.entity.player.EntityPlayer;
//import net.minecraft.util.math.BlockPos;
//import net.minecraft.world.World;
//import net.minecraftforge.fml.common.network.IGuiHandler;
//
//public class GuiHandler implements IGuiHandler {
//
//    public static final int ADVANCED_REPLICATOR_GUI = 0;
//
//    @Override
//    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
//        if (ID == ADVANCED_REPLICATOR_GUI) {
//            TileEntityAdvancedReplicator tileEntity = (TileEntityAdvancedReplicator) world.getTileEntity(new BlockPos(x, y, z));
//            return new ContainerAdvancedReplicator(player.inventory, tileEntity);
//        }
//        return null;
//    }
//
//    @Override
//    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
//        if (ID == ADVANCED_REPLICATOR_GUI) {
//            TileEntityAdvancedReplicator tileEntity = (TileEntityAdvancedReplicator) world.getTileEntity(new BlockPos(x, y, z));
//            return new GuiAdvancedReplicator(new ContainerAdvancedReplicator(player.inventory, tileEntity));
//        }
//        return null;
//    }
//}
