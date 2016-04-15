package net.synthetixa.Synthetique.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.synthetixa.Synthetique.items.synthItems;

import java.util.List;

public class oscillator extends Block implements ITileEntityProvider{

    public static final PropertyInteger TYPE = PropertyInteger.create("type", 0, 2); // 0 = audio, 1 = lfo, 2 = push

    public oscillator(Material material, String unlocalizedName) {
        super(material);
        this.setCreativeTab(CreativeTabs.tabRedstone);
        this.setHardness(1.0F);
        this.setUnlocalizedName(unlocalizedName);
        this.setDefaultState(this.blockState.getBaseState().withProperty(TYPE, 0));
    }

    public IBlockState getStateFromMeta(int meta) {
        return getDefaultState().withProperty(TYPE, Integer.valueOf(meta));
    }

    public int getMetaFromState(IBlockState state){
        return state.getValue(TYPE).intValue();
    }

    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, TYPE);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int i) {
        return new OscillatorTileEntity();
    }

    public boolean canConnectRedstone(IBlockAccess world, BlockPos pos, EnumFacing side)
    {
        return true;
    }

    public void onNeighborBlockChange(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock) {

        TileEntity tileentity = worldIn.getTileEntity(pos);

        if (tileentity instanceof TileEntity) {

            OscillatorTileEntity oscillatorTileEntity = (OscillatorTileEntity) tileentity;

            BlockPos northPos = pos.north();
            BlockPos southPos = pos.south();
            BlockPos westPos = pos.west();
            BlockPos eastPos = pos.east();
            BlockPos upPos = pos.up();
            BlockPos downPos = pos.down();

            Block blockNorth = worldIn.getBlockState(northPos).getBlock();
            Block blockSouth = worldIn.getBlockState(southPos).getBlock();
            Block blockWest = worldIn.getBlockState(westPos).getBlock();
            Block blockEast = worldIn.getBlockState(eastPos).getBlock();
            Block blockUp = worldIn.getBlockState(upPos).getBlock();
            Block blockDown = worldIn.getBlockState(downPos).getBlock();

            if (worldIn.getBlockState(pos).getValue(TYPE).equals(0)) {
                if (worldIn.isBlockPowered(pos)) {

                    if (blockNorth.equals(synthBlocks.speaker)) {
                        worldIn.playSound(null, northPos, SoundEvents.block_note_harp, SoundCategory.BLOCKS, 3.0F, oscillatorTileEntity.pitch);
                    } else if (blockSouth.equals(synthBlocks.speaker)) {
                        worldIn.playSound(null, southPos, SoundEvents.block_note_harp, SoundCategory.BLOCKS, 3.0F, oscillatorTileEntity.pitch);
                    } else if (blockWest.equals(synthBlocks.speaker)) {
                        worldIn.playSound(null, westPos, SoundEvents.block_note_harp, SoundCategory.BLOCKS, 3.0F, oscillatorTileEntity.pitch);
                    } else if (blockEast.equals(synthBlocks.speaker)) {
                        worldIn.playSound(null, eastPos, SoundEvents.block_note_harp, SoundCategory.BLOCKS, 3.0F, oscillatorTileEntity.pitch);
                    } else if (blockUp.equals(synthBlocks.speaker)) {
                        worldIn.playSound(null, upPos, SoundEvents.block_note_harp, SoundCategory.BLOCKS, 3.0F, oscillatorTileEntity.pitch);
                    } else if (blockDown.equals(synthBlocks.speaker)) {
                        worldIn.playSound(null, downPos, SoundEvents.block_note_harp, SoundCategory.BLOCKS, 3.0F, oscillatorTileEntity.pitch);
                    }
                }
            } else if (worldIn.getBlockState(pos).getValue(TYPE).equals(1)) {
                if (worldIn.isBlockPowered(pos)) {
                }
            } else if (worldIn.getBlockState(pos).getValue(TYPE).equals(2)) {
                if (worldIn.isBlockPowered(pos)) {

                    double x1 = pos.east(5).north(2).getX();
                    double y1 = pos.east(5).north(2).getY();
                    double z1 = pos.east(5).north(2).getZ();

                    double x2 = pos.west(5).south(2).getX();
                    double y2 = pos.west(5).south(2).getY();
                    double z2 = pos.west(5).south(2).getZ();

                    List entitiesInBB = worldIn.getEntitiesWithinAABB(EntityLiving.class, new AxisAlignedBB(x1, y1, z1, x2, y2, z2));

                }
            }
        }

    }

    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {

        if (heldItem != null) {
            if (ItemStack.areItemsEqual(new ItemStack(synthItems.screwdriver), heldItem)) {
                if (state.getValue(TYPE).equals(0)) {
                    playerIn.addChatComponentMessage(new TextComponentString("Switching oscillator state from audio to LFO. (this won't make sound)"));
                    worldIn.setBlockState(pos, this.blockState.getBaseState().withProperty(TYPE, 1));
                } else if (state.getValue(TYPE).equals(1)) {
                    playerIn.addChatComponentMessage(new TextComponentString("Switching oscillator state from LFO to push. (this won't make sound)"));
                    worldIn.setBlockState(pos, this.blockState.getBaseState().withProperty(TYPE, 2));
                } else if (state.getValue(TYPE).equals(2)) {
                    playerIn.addChatComponentMessage(new TextComponentString("Switching oscillator state from push to audio. (this will make sound)"));
                    worldIn.setBlockState(pos, this.blockState.getBaseState().withProperty(TYPE, 0));
                }
            } else if (ItemStack.areItemsEqual(new ItemStack(synthItems.tuner), heldItem)) {
                TileEntity tileentity = worldIn.getTileEntity(pos);

                if (tileentity instanceof TileEntity) {

                    OscillatorTileEntity oscillatorTileEntity = (OscillatorTileEntity) tileentity;

                    oscillatorTileEntity.changePitch();
                }
            }
        }

        return false;

    }

}