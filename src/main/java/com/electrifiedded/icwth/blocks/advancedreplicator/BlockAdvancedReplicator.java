//package com.electrifiedded.icwth.advancedreplicator;
//
//import com.electrifiedded.icwth.GuiHandler;
//import com.electrifiedded.icwth.MyMod;
//import ic2.core.block.BlockBase;
//import net.minecraft.block.Block;
//import net.minecraft.block.material.Material;
//import net.minecraft.block.state.IBlockState;
//import net.minecraft.entity.player.EntityPlayer;
//import net.minecraft.tileentity.TileEntity;
//import net.minecraft.util.EnumFacing;
//import net.minecraft.util.EnumHand;
//import net.minecraft.util.math.BlockPos;
//import net.minecraft.world.World;
//import net.minecraftforge.fml.common.registry.GameRegistry;
//
//import javax.annotation.Nullable;
//import javax.annotation.ParametersAreNonnullByDefault;
//import java.util.Objects;
//
//public class BlockAdvancedReplicator extends BlockBase {
//    public BlockAdvancedReplicator() {
//        super(null, Material.ANVIL);
//
//        setTranslationKey("advrep");
//        setRegistryName("advrep");
//    }
//
//    public void registerTileEntity() {
//
//        GameRegistry.registerTileEntity(TileEntityAdvancedReplicator.class, Objects.requireNonNull(getRegistryName()));
//    }
//    @Override
//    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
//        if (!world.isRemote) {
//            player.openGui(MyMod.instance, GuiHandler.ADVANCED_REPLICATOR_GUI, world, pos.getX(), pos.getY(), pos.getZ());
//        }
//        return true;
//    }
//
//}