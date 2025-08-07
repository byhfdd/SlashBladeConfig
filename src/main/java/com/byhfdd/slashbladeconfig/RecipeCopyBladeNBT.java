package com.byhfdd.slashbladeconfig;

import mods.flammpfeil.slashblade.ItemSlashBlade;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class RecipeCopyBladeNBT implements IRecipe {
    public static final String[] keysToCopy = new String[] {
        "killCount",         // 杀敌数
        "ProudSoul",         // 荣耀值
        "RepairCounter",     // 锻造次数
        "SpecialAttackType", // SA
        "SB.SEffect",        // SE
        "isNoScabbard",      // 是否无刀鞘
        "isBroken",          // 是否损坏
        "SummonedSwordColor",// 颜色
        "TextureName",       // 贴图
        "ModelName",         // 模型
        "display",           // 名称
        "ench"               // 附魔
    };

@Override
public boolean matches(InventoryCrafting inv, World world) {
    ItemStack source = inv.getStackInSlot(1);
    if (source == null || !(source.getItem() instanceof ItemSlashBlade)) {
        return false;
    }

    ItemStack target = inv.getStackInSlot(7);
    if (target == null || !(target.getItem() instanceof ItemSlashBlade)) {
        return false;
    }

    int diamondCount = 0;
    for (int i = 0; i < inv.getSizeInventory(); i++) {
        if (i == 1 || i == 7) {
            continue;
        }

        ItemStack stack = inv.getStackInSlot(i);
        if (stack == null) continue;

        if (stack.getItem() == Items.diamond) {
            diamondCount++;
        } else {
            return false;
        }
    }

    return diamondCount == 7;
}
    @Override
    public ItemStack getCraftingResult(InventoryCrafting inv) {
        ItemStack bladeA = inv.getStackInSlot(1);
        ItemStack bladeB = inv.getStackInSlot(7);

        if (bladeA == null || bladeB == null) return null;

        NBTTagCompound ATag = ItemSlashBlade.getItemTagCompound(bladeA);
        NBTTagCompound BTag = ItemSlashBlade.getItemTagCompound(bladeB);

        if (BTag == null) {
            BTag = new NBTTagCompound();
        } else {
            BTag = (NBTTagCompound) BTag.copy();
        }



        for (String key : keysToCopy) {
            if (ATag.hasKey(key)) {
                BTag.setTag(key, ATag.getTag(key));
            }
        }

        ItemStack result = bladeB.copy();
        result.stackSize = 1;
        result.setTagCompound(BTag);

        return result;
    }

    @Override
    public int getRecipeSize() {
        return 9;
    }

    @Override
    public ItemStack getRecipeOutput() {
        return null;
    }
}
