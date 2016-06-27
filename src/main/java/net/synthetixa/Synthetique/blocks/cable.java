package net.synthetixa.Synthetique.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.synthetixa.Synthetique.SynthMod;
import net.synthetixa.Synthetique.common.PropertyFloat;

public class cable extends Block {

    public PropertyFloat PITCH = PropertyFloat.create("pitch", 0.1F, 2.0F);

    public cable(Material material, String unlocalizedName) {

        super(material);

        this.setUnlocalizedName(unlocalizedName);
        this.setRegistryName(SynthMod.MODID, "cable");
        this.setCreativeTab(CreativeTabs.tabRedstone);
        this.setHardness(1.0F);
        this.setDefaultState(this.blockState.getBaseState().withProperty(PITCH, 0.1F));

    }

    public IBlockState getStateFromMeta(int meta) {
        return getDefaultState().withProperty(PITCH, Float.valueOf(meta));
    }

    public int getMetaFromState(IBlockState state) {
        return state.getValue(PITCH).intValue();
    }

    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, PITCH);
    }

}
