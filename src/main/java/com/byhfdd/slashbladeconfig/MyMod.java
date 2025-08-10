package com.byhfdd.slashbladeconfig;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;

@Mod(
    modid = MyMod.MODID,
    version = Tags.VERSION,
    name = "SlashBladeConfig",
    dependencies = MyMod.dependencies,
    acceptedMinecraftVersions = "[1.7.10]")
public class MyMod {

    public static final String MODID = "slashbladeconfig";
    public static final Logger LOG = LogManager.getLogger(MODID);
    public static final String dependencies = "required-after:flammpfeil.slashblade";
    @SidedProxy(
        clientSide = "com.byhfdd.slashbladeconfig.ClientProxy",
        serverSide = "com.byhfdd.slashbladeconfig.CommonProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler

    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }

    @Mod.EventHandler
    public void serverStarting(FMLServerStartingEvent event) {
        proxy.serverStarting(event);
    }
}
