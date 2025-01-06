package com.electrifiedded.icwth.items.rotor;


import ic2.api.item.IKineticRotor;
import ic2.core.IC2;
import ic2.core.item.ItemGradualInt;
import ic2.core.ref.ItemName;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class ItemIridiumRotor extends ItemGradualInt implements IKineticRotor {
    private final int maxWindStrength;
    private final int minWindStrength;
    private final int radius;
    private final float efficiency;
    private final ResourceLocation renderTexture;
    private final boolean water;
    public ItemIridiumRotor(int Radius, int maxDamage, float efficiency, int minWindStrength, int maxWindStrength, ResourceLocation RenderTexture) {
        super(null, maxDamage);
        setTranslationKey("iridium_rotor");
        setRegistryName("iridium_rotor");
        setCreativeTab(IC2.tabIC2); // Указываем вкладку IC2
        this.radius = Radius;
        this.efficiency = efficiency;
        this.renderTexture = RenderTexture;
        this.minWindStrength = minWindStrength;
        this.maxWindStrength = maxWindStrength;
        this.water = false;
    }

    @Override
    public int getDiameter(ItemStack itemStack) {
        return 12;
    }

    @Override
    public ResourceLocation getRotorRenderTexture(ItemStack itemStack) {
        return this.renderTexture;
    }

    @Override
    public float getEfficiency(ItemStack itemStack) {
        return 10;
    }

    @Override
    public int getMinWindStrength(ItemStack itemStack) {
        return 1;
    }

    @Override
    public int getMaxWindStrength(ItemStack itemStack) {
        return 200;
    }

    @Override
    public boolean isAcceptedType(ItemStack stack, IKineticRotor.GearboxType type) {
        return type == GearboxType.WIND || type == GearboxType.WATER;
    }
}
