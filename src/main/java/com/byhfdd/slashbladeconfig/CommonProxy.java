package com.byhfdd.slashbladeconfig;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import mods.flammpfeil.slashblade.SlashBlade;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class CommonProxy {


    // preInit "Run before anything else. Read your config, create blocks, items, etc, and register them with the
    // GameRegistry." (Remove if not needed)
    public void preInit(FMLPreInitializationEvent event) {
        Config.synchronizeConfiguration(event.getSuggestedConfigurationFile());
        MyMod.LOG.info(Config.greeting);
        MyMod.LOG.info("SBMMMcompat at version " + Tags.VERSION);
    }

    // load "Do your mod setup. Build whatever data structures you care about. Register recipes." (Remove if not needed)
    public void init(FMLInitializationEvent event) {
        GameRegistry.addRecipe(new RecipeCopyBladeNBT());
        GameRegistry.addShapedRecipe(new ItemStack(SlashBlade.bladeNamed),
            "DAD",
            "DBD",
            "DDD",
            'A', new ItemStack(SlashBlade.bladeNamed),
            'B', new ItemStack(SlashBlade.bladeNamed),
            'D', Items.diamond
        );
    }

    // postInit "Handle interaction with other mods, complete your setup based on this." (Remove if not needed)
    public void postInit(FMLPostInitializationEvent event) {}

    // register server commands in this event handler (Remove if not needed)
    public void serverStarting(FMLServerStartingEvent event) {}
}
