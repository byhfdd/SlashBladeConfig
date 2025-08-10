package com.byhfdd.slashbladeconfig.event;

import net.minecraftforge.event.AnvilUpdateEvent;

import com.byhfdd.slashbladeconfig.Config;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import mods.flammpfeil.slashblade.ItemSlashBlade;

public class AnvilLimit {

    private static final int MAX_REPAIR_COUNT = Config.maxRepairCount;

    @SubscribeEvent
    public void onAnvilForgeLimit(AnvilUpdateEvent event) {
        if (event.left != null && event.left.getItem() instanceof ItemSlashBlade) {
            int repairCount = ItemSlashBlade.RepairCount.get(ItemSlashBlade.getItemTagCompound(event.left));

            if (repairCount >= MAX_REPAIR_COUNT) {
                event.output = null;
                return;
            }
        }
    }
}
