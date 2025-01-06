package com.electrifiedded.icwth.proxy;

import com.electrifiedded.icwth.blocks.ModBlocks;
import com.electrifiedded.icwth.items.ThrowableVillager;
import com.electrifiedded.icwth.items.batcells.ItemAtomicDrill;
import com.electrifiedded.icwth.items.rotor.ItemIridiumRotor;
import com.electrifiedded.icwth.items.upgrades.ItemImproovedOverclocker;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.tileentity.TileEntityItemStackRenderer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Objects;

import static com.electrifiedded.icwth.blocks.ModBlocks.quantumMFSU;

@Mod.EventBusSubscriber
public class CommonProxy {

    public static Item itemVillagerModel;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {

    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
//        event.getRegistry().register(new ItemAtomicDrill());

        event.getRegistry().register(new ItemIridiumRotor(11, 604800, 1.75F, 17, 110, new ResourceLocation("icwth", "textures/items/nanorotor_model.png")));

        event.getRegistry().register(new ThrowableVillager());
        event.getRegistry().register(new ItemImproovedOverclocker());

//        event.getRegistry().register(new ItemBlock(quantumMFSU).setRegistryName(Objects.requireNonNull(quantumMFSU.getRegistryName())));
    }

    @SubscribeEvent
    public void registerBlocks(RegistryEvent.Register<Block> event) {
    }
    @SideOnly(Side.CLIENT)
    public void registerItemRenderer() {
        TileEntityItemStackRenderer.instance = new ThrowableVillager().getTileEntityItemStackRenderer();
    }


}
