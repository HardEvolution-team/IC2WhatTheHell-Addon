package com.electrifiedded.icwth.blocks.quantummfsu;
import ic2.core.IC2;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
public class BlockQuantumMFSU extends Block {
    public BlockQuantumMFSU() {
        super(Material.IRON);
        this.setTranslationKey("quantum_mfsu");
        this.setRegistryName("quantum_mfsu");
        this.setCreativeTab(IC2.tabIC2);
        this.setHardness(2.0f);
        this.setResistance(10.0f);
    }
}