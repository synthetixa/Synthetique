package net.synthetixa.Synthetique.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.BlockRenderLayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.synthetixa.Synthetique.SynthMod;

public class cable extends Block {

    public cable(Material material, String unlocalizedName) {

        super(material);

        this.setUnlocalizedName(unlocalizedName);
        this.setRegistryName(SynthMod.MODID, "cable");
        this.setCreativeTab(CreativeTabs.REDSTONE);
        this.setHardness(1.0F);

    }

    @Override
    public boolean isVisuallyOpaque() {
        return false;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT;
    }


}
