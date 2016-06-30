package net.synthetixa.Synthetique.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.synthetixa.Synthetique.SynthMod;

public class IC extends Item {

    public IC(String unlocalizedName)
    {
        super();

        this.setUnlocalizedName(unlocalizedName);
        this.setCreativeTab(CreativeTabs.REDSTONE);
        this.setRegistryName(SynthMod.MODID, "integrated_circuit_" + unlocalizedName);
    }

}
