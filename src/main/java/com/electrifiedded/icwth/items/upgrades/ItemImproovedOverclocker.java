package com.electrifiedded.icwth.items.upgrades;

import ic2.api.item.IItemHudInfo;
import ic2.api.upgrade.IProcessingUpgrade;
import ic2.api.upgrade.IUpgradableBlock;
import ic2.api.upgrade.IUpgradeItem;
import ic2.api.upgrade.UpgradableProperty;
import ic2.api.upgrade.UpgradeRegistry;
import ic2.core.IC2;
import ic2.core.item.ItemIC2;
import morph.avaritia.api.IHaloRenderItem;
import morph.avaritia.init.AvaritiaTextures;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class ItemImproovedOverclocker extends Item implements IHaloRenderItem, IProcessingUpgrade, IUpgradeItem, IItemHudInfo {



    private final double EnergyMultiplier = 0.7;
    private final double ProcessTimeMultiplier = 0.7;



    private final double TooltipTImeMultiplier = (1 - ProcessTimeMultiplier) * 100;
    private final double ToolTipEnergyMultiplier = (1 - EnergyMultiplier) * 100;



    public ItemImproovedOverclocker() {
        this.setCreativeTab(IC2.tabIC2); // Используем вкладку IC2
        this.setTranslationKey("improoved_overclocker"); // Устанавливаем ключ перевода
        this.setRegistryName(new ResourceLocation("icwth", "improoved_overclocker")); // Регистрируем предмет
        UpgradeRegistry.register(new ItemStack(this)); // Регистрируем апгрейд
    }

    @Override
    public List<String> getHudInfo(ItemStack itemStack, boolean b) {
        return Collections.singletonList("Overclocker Upgrade"); // Информация на HUD
    }

    @Override
    public boolean isSuitableFor(ItemStack stack, Set<UpgradableProperty> types) {
        return types.contains(UpgradableProperty.Processing); // Подходит для машин с обработкой
    }

    @Override
    public boolean onTick(ItemStack stack, IUpgradableBlock upgradableBlock) {
        return false; // Не требует обработки каждый тик
    }

    @Override
    public int getExtraProcessTime(ItemStack itemStack, IUpgradableBlock upgradableBlock) {
        return 0; // No extra processing time added
    }

    @Override
    public Collection<ItemStack> onProcessEnd(ItemStack itemStack, IUpgradableBlock iUpgradableBlock, Collection<ItemStack> collection) {
        return collection; // Return the original output collection
    }

    @Override
    public double getProcessTimeMultiplier(ItemStack itemStack, IUpgradableBlock upgradableBlock) {
        return ProcessTimeMultiplier; // Minimal processing time, adjust as needed
    }
    @Override
    public int getExtraEnergyDemand(ItemStack itemStack, IUpgradableBlock iUpgradableBlock) {
        return 0;
    }

    @Override
    public double getEnergyDemandMultiplier(ItemStack itemStack, IUpgradableBlock upgradableBlock) {
        return 1.7; // Увеличивает энергопотребление на 70%
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, tooltip, flagIn);
        tooltip.add(("Increases speed by ") + (int)TooltipTImeMultiplier + ("%"));
        tooltip.add(("Increases energy consumption by ") + (int)ToolTipEnergyMultiplier + ("%"));
    }



    @Override
    public boolean shouldDrawHalo(ItemStack itemStack) {
        return true;
    }

    @Override
    public TextureAtlasSprite getHaloTexture(ItemStack itemStack) {
        return AvaritiaTextures.HALO;
    }
    @Override
    @SideOnly (Side.CLIENT)
    public int getHaloColour(ItemStack stack) {
        return 0xFF000000;
    }


    @Override
    @SideOnly (Side.CLIENT)
    public int getHaloSize(ItemStack stack) {
        return 4;
    }


    @Override
    @SideOnly (Side.CLIENT)
    public boolean shouldDrawPulse(ItemStack stack) {
        return false;
    }
}