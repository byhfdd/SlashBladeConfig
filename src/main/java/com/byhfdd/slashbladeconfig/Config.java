package com.byhfdd.slashbladeconfig;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class Config {

    public static int maxRepairCount = 30;

    public static void synchronizeConfiguration(File configFile) {
        Configuration configuration = new Configuration(configFile);

        maxRepairCount = configuration.getInt(
            "maxRepairCount",
            Configuration.CATEGORY_GENERAL,
            maxRepairCount,
            1,
            300,
            "Maximum forge count for slashblade");

        if (configuration.hasChanged()) {
            configuration.save();
        }
    }
}
