package com.electrifiedded.icwth.blocks.quantummfsu;
import ic2.api.energy.EnergyNet;
import ic2.api.energy.event.EnergyTileLoadEvent;
import ic2.api.energy.event.EnergyTileUnloadEvent;
import ic2.api.energy.tile.IEnergyAcceptor;
import ic2.api.energy.tile.IEnergyEmitter;
import ic2.api.energy.tile.IEnergySink;
import ic2.api.energy.tile.IEnergySource;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraftforge.common.MinecraftForge;
public class TileEntityQuantumMFSU extends TileEntity implements ITickable, IEnergySink, IEnergySource {

    private int energyStored = 0;
    private final int capacity = 10000000; // 10 000 000 EU
    private final int tier = 4; // Tier 4 (MFSU tier)

    private boolean addedToEnergyNet = false;

    @Override
    public void update() {
        if (!world.isRemote) {
            if (!addedToEnergyNet) {
                MinecraftForge.EVENT_BUS.post(new EnergyTileLoadEvent(this));
                addedToEnergyNet = true;
            }
        }
    }

    @Override
    public void invalidate() {
        super.invalidate();
        if (addedToEnergyNet) {
            MinecraftForge.EVENT_BUS.post(new EnergyTileUnloadEvent(this));
            addedToEnergyNet = false;
        }
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        energyStored = compound.getInteger("EnergyStored");
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        compound.setInteger("EnergyStored", energyStored);
        return compound;
    }

    // IEnergySink methods
    @Override
    public double getDemandedEnergy() {
        return Math.max(0, capacity - energyStored);
    }

    @Override
    public int getSinkTier() {
        return tier;
    }

    @Override
    public double injectEnergy(EnumFacing directionFrom, double amount, double voltage) {
        int energyToAdd = (int) Math.min(amount, capacity - energyStored);
        energyStored += energyToAdd;
        return amount - energyToAdd;
    }

    @Override
    public boolean acceptsEnergyFrom(IEnergyEmitter emitter, EnumFacing side) {
        return true;
    }

    // IEnergySource methods
    @Override
    public double getOfferedEnergy() {
        return Math.min(energyStored, EnergyNet.instance.getPowerFromTier(tier));
    }

    @Override
    public void drawEnergy(double amount) {
        energyStored = Math.max(0, energyStored - (int) amount);
    }

    @Override
    public int getSourceTier() {
        return tier;
    }

    @Override
    public boolean emitsEnergyTo(IEnergyAcceptor receiver, EnumFacing side) {
        return true;
    }
}