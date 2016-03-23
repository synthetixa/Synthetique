package net.synthetixa.Synthetique.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class oscillator extends Block {
    public oscillator(Material material) {
        super(material);
        this.setCreativeTab(CreativeTabs.tabRedstone);
        this.setHardness(1.0F);
        this.setUnlocalizedName("oscillator");
    }
}
