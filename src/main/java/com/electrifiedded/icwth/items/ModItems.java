package com.electrifiedded.icwth.items;

import com.electrifiedded.icwth.items.rotor.ItemIridiumRotor;
import com.electrifiedded.icwth.items.upgrades.ItemImproovedOverclocker;

import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems {
    @GameRegistry.ObjectHolder("icwth:iridium_rotor")
    public static ItemIridiumRotor iridiumRotor;

    @GameRegistry.ObjectHolder("icwth:throwable_villager")
    public static ThrowableVillager throwableVillager;

    @GameRegistry.ObjectHolder("icwth:improoved_overclocker")
    public static ItemImproovedOverclocker itemOverclocker;



}
