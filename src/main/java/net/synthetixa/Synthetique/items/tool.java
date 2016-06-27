package net.synthetixa.Synthetique.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.synthetixa.Synthetique.SynthMod;

public class tool extends Item {

    public tool(String unlocalizedName)
    {
        super();

        this.setUnlocalizedName(unlocalizedName);
        this.setCreativeTab(CreativeTabs.tabTools);
        this.setRegistryName(SynthMod.MODID, "tool");
    }

}
