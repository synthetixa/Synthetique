package net.synthetixa.Synthetique.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.world.World;
import net.synthetixa.Synthetique.SynthMod;

public class cable extends Block implements ITileEntityProvider {

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

    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT;
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return null;
    }
}
