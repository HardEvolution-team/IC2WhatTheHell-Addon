package com.electrifiedded.icwth.items.batcells;

import com.myname.mymodid.Tags;
import ic2.api.item.ElectricItem;
import ic2.api.item.IElectricItem;
import ic2.core.IC2;
import ic2.core.item.ItemBattery;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import ic2.api.item.ElectricItem;
import ic2.api.item.IBoxable;
import ic2.core.IC2;
import ic2.core.init.Localization;
import ic2.core.item.ItemBattery;
import ic2.core.item.tool.GuiToolbox;
import ic2.core.profile.NotClassic;
import ic2.core.ref.ItemName;
import ic2.core.util.StackUtil;
import java.util.List;
import java.util.Locale;
import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;
import ic2.core.IC2;
import ic2.core.item.tool.HarvestLevel;
import ic2.core.item.tool.ItemDrill;
import ic2.core.profile.NotClassic;
import ic2.core.ref.ItemName;
import ic2.core.util.StackUtil;
import java.util.IdentityHashMap;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Enchantments;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

@NotClassic
public class ItemAtomicDrill
        extends ItemDrill {
    public ItemAtomicDrill() {
        super(null, 800, HarvestLevel.Iridium, 300000, 1000, 3, 24.0f);
    }

//    @Override
//    protected ItemStack getItemStack(double charge) {
//        ItemStack ret = super.getItemStack(charge);
//        IdentityHashMap<Enchantment, Integer> enchantmentMap = new IdentityHashMap<Enchantment, Integer>();
//        enchantmentMap.put(Enchantments.FORTUNE, 3);
//        EnchantmentHelper.setEnchantments(enchantmentMap, (ItemStack)ret);
//        return ret;
//    }
//
//    @Override
//    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
//        if (!world.isRemote && IC2.keyboard.isModeSwitchKeyDown(player)) {
//            IdentityHashMap<Enchantment, Integer> enchantmentMap = new IdentityHashMap<Enchantment, Integer>();
//            enchantmentMap.put(Enchantments.FORTUNE, 3);
//            ItemStack stack = StackUtil.get(player, hand);
//            if (EnchantmentHelper.getEnchantmentLevel((Enchantment)Enchantments.SILK_TOUCH, (ItemStack)stack) == 0) {
//                enchantmentMap.put(Enchantments.SILK_TOUCH, 1);
//                IC2.platform.messagePlayer(player, "ic2.tooltip.mode", "ic2.tooltip.mode.silkTouch");
//            } else {
//                IC2.platform.messagePlayer(player, "ic2.tooltip.mode", "ic2.tooltip.mode.normal");
//            }
//            EnchantmentHelper.setEnchantments(enchantmentMap, (ItemStack)stack);
//        }
//        return super.onItemRightClick(world, player, hand);
//    }
//
//    @Override
//    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing side, float xOffset, float yOffset, float zOffset) {
//        if (IC2.keyboard.isModeSwitchKeyDown(player)) {
//            return EnumActionResult.PASS;
//        }
//        return super.onItemUse(player, world, pos, hand, side, xOffset, yOffset, zOffset);
//    }
}