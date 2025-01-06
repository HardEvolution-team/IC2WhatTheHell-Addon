package com.electrifiedded.icwth.proxy;

import com.electrifiedded.icwth.blocks.quantummfsu.BlockQuantumMFSU;
import com.electrifiedded.icwth.blocks.quantummfsu.TileEntityQuantumMFSU;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Objects;

import static com.electrifiedded.icwth.items.ModItems.throwableVillager;
import static com.myname.mymodid.Tags.MODID;

public class ClientProxy extends CommonProxy {
    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        registerItemModel(throwableVillager);
    }
    @SideOnly(Side.CLIENT)
    private static void registerItemModel(Item item) {
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(Objects.requireNonNull(item.getRegistryName()), "inventory"));
    }
    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
    }


}
