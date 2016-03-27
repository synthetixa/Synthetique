package net.synthetixa.Synthetique.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class tool extends Item {

    public tool(String unlocalizedName)
    {
        super();

        this.setUnlocalizedName(unlocalizedName);
        this.setCreativeTab(CreativeTabs.tabTools);
    }

}
