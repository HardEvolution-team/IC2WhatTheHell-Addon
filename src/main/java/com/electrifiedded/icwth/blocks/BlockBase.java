package com.electrifiedded.icwth.blocks;

import com.myname.mymodid.Tags;
import ic2.core.IC2;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Random;

public abstract class BlockBase extends Block {
    private static final Random rand = new Random();

    public BlockBase(String id) {
        this(id, Material.IRON);
    }

    public BlockBase(String id, Material material) {
        super(material);
        this.setRegistryName(id);
        this.setTranslationKey(Tags.MODID + "." + id);
        this.setCreativeTab(IC2.tabIC2);
        this.setHardness(1f);
    }

    public void registerTileEntity() {
    }

    private static double randCoordOffset(int coord){
        return (rand.nextInt() % 32 - 16) / 82.0 + 0.5 + coord;
    }



    @Override
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
        TileEntity te = worldIn.getTileEntity(pos);
        if(!(te instanceof TileBase)) return;
        TileBase tb = (TileBase) te;
        ArrayList<ItemStack> drops = new ArrayList<>();
        super.breakBlock(worldIn, pos, state);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return 0;
    }
}

