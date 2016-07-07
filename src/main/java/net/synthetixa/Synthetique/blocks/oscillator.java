package net.synthetixa.Synthetique.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.synthetixa.Synthetique.SynthMod;
import net.synthetixa.Synthetique.items.synthItems;

public class oscillator extends Block implements ITileEntityProvider{

    public oscillator(Material material, String unlocalizedName) {
        super(material);
        this.setCreativeTab(CreativeTabs.REDSTONE);
        this.setHardness(1.0F);
        this.setUnlocalizedName(unlocalizedName);
        this.setRegistryName(SynthMod.MODID, "oscillator");
    }

    @Override
    public TileEntity createNewTileEntity(World world, int i) {
        return new OscillatorTileEntity();
    }

    @Override
    public void neighborChanged(IBlockState state, World world, BlockPos pos, Block block) {
        TileEntity te = world.getTileEntity(pos);

        Block up = world.getBlockState(pos.up()).getBlock();
        Block down = world.getBlockState(pos.down()).getBlock();
        Block east = world.getBlockState(pos.east()).getBlock();
        Block west = world.getBlockState(pos.west()).getBlock();
        Block north = world.getBlockState(pos.north()).getBlock();
        Block south = world.getBlockState(pos.south()).getBlock();

        if (te instanceof TileEntity) {
            OscillatorTileEntity ote = (OscillatorTileEntity) te;

            if (world.isBlockPowered(pos) && ote.type == 0) {
                if (up == synthBlocks.speaker || down == synthBlocks.speaker || east == synthBlocks.speaker || west == synthBlocks.speaker || north == synthBlocks.speaker || south == synthBlocks.speaker) {
                }
            }
            if (world.isBlockPowered(pos) && ote.type == 1) {
                if (up == synthBlocks.speaker || down == synthBlocks.speaker || east == synthBlocks.speaker || west == synthBlocks.speaker || north == synthBlocks.speaker || south == synthBlocks.speaker) {
                }
            }
        }
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {

        if (heldItem != null) {

            TileEntity tileentity = worldIn.getTileEntity(pos);

            if (ItemStack.areItemsEqual(new ItemStack(synthItems.screwdriver), heldItem)) {
                if (tileentity instanceof TileEntity) {

                    OscillatorTileEntity oscillatorTileEntity = (OscillatorTileEntity) tileentity;
                    if (oscillatorTileEntity.type == 0) { //type is sine wave
                        oscillatorTileEntity.changeType(1); //change to saw wave
                    } else if (oscillatorTileEntity.type == 1) { //type is saw wave
                        oscillatorTileEntity.changeType(2); //change to LFO
                    } else if (oscillatorTileEntity.type == 2) {//type is LFO
                        oscillatorTileEntity.changeType(0); //change to sine wave
                    }
                }

                return true;
            } else if (ItemStack.areItemsEqual(new ItemStack(synthItems.tuner), heldItem)) {

                if (tileentity instanceof TileEntity) {
                    OscillatorTileEntity oscillatorTileEntity = (OscillatorTileEntity) tileentity;

                }
            }

            return true;
        }

        return false;

    }

}