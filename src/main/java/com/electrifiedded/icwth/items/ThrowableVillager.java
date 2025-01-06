/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.creativetab.CreativeTabs
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.world.World
 */
package com.electrifiedded.icwth.items;


import com.electrifiedded.icwth.Entity.EntityThrownVillager;
import com.electrifiedded.icwth.models.ModelThrowableVillager;
import net.minecraft.client.model.ModelBase;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ThrowableVillager extends Item {

    public static ModelRegistryEvent throwableVillager;

    public ThrowableVillager() {
        this.setCreativeTab(CreativeTabs.COMBAT);
        this.setTranslationKey("throwable_villager");
        this.setRegistryName("throwable_villager");

    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        ItemStack itemstack = player.getHeldItem(hand);

        if (!player.capabilities.isCreativeMode) {
            itemstack.shrink(1);
        }

        world.playSound(null, player.posX, player.posY, player.posZ, net.minecraft.init.SoundEvents.ENTITY_VILLAGER_AMBIENT, SoundCategory.NEUTRAL, 0.7F, 0.8F);

        if (!world.isRemote) {
            EntityThrownVillager thrownVillager = new EntityThrownVillager(world, player);
            world.spawnEntity(thrownVillager);
        }

        return new ActionResult<>(EnumActionResult.SUCCESS, itemstack);
    }
    @SideOnly(Side.CLIENT)
    public ModelBase getModel() {
        return new ModelThrowableVillager(0.0F);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack) {
        return true;
    }
}
