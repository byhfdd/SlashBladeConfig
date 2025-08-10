package com.byhfdd.slashbladeconfig;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;

import com.byhfdd.slashbladeconfig.event.AnvilLimit;
import com.byhfdd.slashbladeconfig.event.RecipeCopyBladeNBT;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import mods.flammpfeil.slashblade.SlashBlade;

public class CommonProxy {

    public void preInit(FMLPreInitializationEvent event) {
        Config.synchronizeConfiguration(event.getSuggestedConfigurationFile());
    }

    public void init(FMLInitializationEvent event) {
        GameRegistry.addRecipe(new RecipeCopyBladeNBT());
        GameRegistry.addShapedRecipe(
            new ItemStack(SlashBlade.bladeNamed),
            "DAD",
            "DBD",
            "DDD",
            'A',
            new ItemStack(SlashBlade.bladeNamed),
            'B',
            new ItemStack(SlashBlade.bladeNamed),
            'D',
            Items.diamond);
        MinecraftForge.EVENT_BUS.register(new AnvilLimit());
    }

    public void postInit(FMLPostInitializationEvent event) {}

    public void serverStarting(FMLServerStartingEvent event) {}
}
