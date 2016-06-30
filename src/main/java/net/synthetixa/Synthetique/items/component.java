package net.synthetixa.Synthetique.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.synthetixa.Synthetique.SynthMod;

public class component extends Item {

    public component(String unlocalizedName)
    {
        super();

        this.setUnlocalizedName(unlocalizedName);
        this.setCreativeTab(CreativeTabs.REDSTONE);
        this.setRegistryName(SynthMod.MODID, "component_" + unlocalizedName);
    }

}