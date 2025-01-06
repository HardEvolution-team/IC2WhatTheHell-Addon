package com.electrifiedded.icwth;


import com.electrifiedded.icwth.Entity.EntityThrownVillager;
import com.electrifiedded.icwth.Entity.RenderThrownVillager;
import com.electrifiedded.icwth.blocks.quantummfsu.BlockQuantumMFSU;
import com.electrifiedded.icwth.blocks.quantummfsu.TileEntityQuantumMFSU;
import com.electrifiedded.icwth.items.VillagerItemRenderer;
import com.myname.mymodid.Tags;
import mcjty.theoneprobe.proxy.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntityItemStackRenderer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.electrifiedded.icwth.blocks.ModBlocks.quantumMFSU;
import static com.myname.mymodid.Tags.MODID;

@Mod(modid = MODID, version = Tags.VERSION, name = Tags.MODNAME, acceptedMinecraftVersions = "[1.12.2]")
public class Core {
    //@SidedProxy(clientSide = "com.electrifiedded.icwth.proxy.ClientProxy", serverSide = "com.electrifiedded.icwth.proxy.CommonProxy")
    public static CommonProxy proxy;

    @Mod.Instance(MODID)
    public static Core instance;
    public static final Logger LOGGER = LogManager.getLogger(MODID);

    @EventHandler
    // preInit "Run before anything else. Read your config, create blocks, items, etc. (Remove if not needed)
    public void preInit(FMLPreInitializationEvent event) {
        // register to the event bus so that we can listen to events
        MinecraftForge.EVENT_BUS.register(this);
        LOGGER.info("I am " + Tags.MODNAME + " + at version " + Tags.VERSION);

        // Регистрация сущности
        EntityRegistry.registerModEntity(
                new ResourceLocation("mymod", "thrown_villager"), // Уникальный идентификатор
                EntityThrownVillager.class,                      // Класс сущности
                "ThrownVillager",                                // Имя сущности
                0,                                               // ID сущности
                this,                                            // Экземпляр мода
                64,                                              // Дистанция отслеживания
                1,                                               // Частота обновления
                true                                             // Отправлять ли данные о скорости
        );

        // Регистрация рендерера на клиентской стороне
        if (event.getSide() == Side.CLIENT) {
            registerEntityRenderers();
        }


    }
    @SubscribeEvent
    // Register blocks here (Remove if not needed)
    public void registerBlocks(RegistryEvent.Register<Block> event) {

    }



    @SubscribeEvent
    // Register recipes here (Remove if not needed)
    public void registerRecipes(RegistryEvent.Register<IRecipe> event) {

    }


    @SubscribeEvent
    public void registerEntities(RegistryEvent.Register<EntityEntry> event) {

    }
    @EventHandler
    // load "Do your mod setup. Build whatever data structures you care about." (Remove if not needed)
    public void init(FMLInitializationEvent event) {


    }

    @EventHandler
    // postInit "Handle interaction with other mods, complete your setup based on this." (Remove if not needed)
    public void postInit(FMLPostInitializationEvent event) {
    }

    @EventHandler
    // register server commands in this event handler (Remove if not needed)
    public void serverStarting(FMLServerStartingEvent event) {
    }
    @SideOnly(Side.CLIENT)
    private void registerEntityRenderers() {
        // Регистрация рендерера для EntityThrownVillager
        RenderingRegistry.registerEntityRenderingHandler(EntityThrownVillager.class, new RenderThrownVillager.Factory());
    }
    @SideOnly(Side.CLIENT)
    private void setCustomItemRenderer() {
        // Получаем экземпляр RenderManager
        RenderManager renderManager = Minecraft.getMinecraft().getRenderManager();
        // Устанавливаем кастомный рендерер для предмета
        TileEntityItemStackRenderer.instance = new VillagerItemRenderer();
    }


















}
