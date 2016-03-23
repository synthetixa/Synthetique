package net.synthetixa.Synthetique.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class speaker extends Block {

    public speaker(Material material, String unlocalizedName) {
        super(material);
        this.setCreativeTab(CreativeTabs.tabRedstone);
        this.setHardness(1.0F);
        this.setUnlocalizedName(unlocalizedName);
    }
}