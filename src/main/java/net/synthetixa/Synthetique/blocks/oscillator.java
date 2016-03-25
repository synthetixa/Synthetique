package net.synthetixa.Synthetique.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class oscillator extends Block implements ITileEntityProvider{

    public static final PropertyDirection FACING;

    public oscillator(Material material, String unlocalizedName) {
        super(material);
        this.setCreativeTab(CreativeTabs.tabRedstone);
        this.setHardness(1.0F);
        this.setUnlocalizedName(unlocalizedName);
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
    }

    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
        this.setDefaultFacing(worldIn, pos, state);
    }

    private void setDefaultFacing(World worldIn, BlockPos pos, IBlockState state) {
        if(!worldIn.isRemote) {
            IBlockState iblockstate = worldIn.getBlockState(pos.north());
            IBlockState iblockstate1 = worldIn.getBlockState(pos.south());
            IBlockState iblockstate2 = worldIn.getBlockState(pos.west());
            IBlockState iblockstate3 = worldIn.getBlockState(pos.east());
            EnumFacing enumfacing = (EnumFacing) state.getValue(FACING);
            if (enumfacing == EnumFacing.NORTH && iblockstate.isFullBlock() && !iblockstate1.isFullBlock()) {
                enumfacing = EnumFacing.SOUTH;
            } else if (enumfacing == EnumFacing.SOUTH && iblockstate1.isFullBlock() && !iblockstate.isFullBlock()) {
                enumfacing = EnumFacing.NORTH;
            } else if (enumfacing == EnumFacing.WEST && iblockstate2.isFullBlock() && !iblockstate3.isFullBlock()) {
                enumfacing = EnumFacing.EAST;
            } else if (enumfacing == EnumFacing.EAST && iblockstate3.isFullBlock() && !iblockstate2.isFullBlock()) {
                enumfacing = EnumFacing.WEST;
            }

            worldIn.setBlockState(pos, state.withProperty(FACING, enumfacing), 2);
        }

    }

    public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
        return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
    }

    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        worldIn.setBlockState(pos, state.withProperty(FACING, placer.getHorizontalFacing().getOpposite()), 2);
    }

    public IBlockState getStateFromMeta(int meta) {
        EnumFacing enumfacing = EnumFacing.getFront(meta);
        if(enumfacing.getAxis() == EnumFacing.Axis.Y) {
            enumfacing = EnumFacing.NORTH;
        }

        return this.getDefaultState().withProperty(FACING, enumfacing);
    }

    public int getMetaFromState(IBlockState state) {
        return ((EnumFacing)state.getValue(FACING)).getIndex();
    }

    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[]{FACING});
    }

    static {
        FACING = BlockHorizontal.FACING;
    }

    @Override
    public TileEntity createNewTileEntity(World world, int i) {
        return new OscillatorTileEntity();
    }

    public boolean canConnectRedstone(IBlockAccess world, BlockPos pos, EnumFacing side)
    {
        if (side == null) return false;
        if (side == EnumFacing.UP || side == EnumFacing.DOWN) return false;
        if (side == EnumFacing.NORTH) return false;

        // we can connect to three of the four side faces - if the block is facing north, then we can
        //  connect to WEST, SOUTH, or EAST.

        EnumFacing whichFaceOfOsc = side.getOpposite();
        IBlockState blockState = world.getBlockState(pos);
        EnumFacing blockFacingDirection = (EnumFacing)blockState.getValue(FACING);

        if (whichFaceOfOsc == blockFacingDirection) return false;
        return true;
    }

    public void onNeighborBlockChange(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock) {

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


        if(worldIn.isBlockPowered(pos)){
            if(blockNorth.equals(synthBlocks.speaker)){
                worldIn.playSound((EntityPlayer)null, northPos, SoundEvents.block_note_harp, SoundCategory.BLOCKS, 3.0F, 1.0F);
            }
            else if(blockSouth.equals(synthBlocks.speaker)){
                worldIn.playSound((EntityPlayer)null, southPos, SoundEvents.block_note_harp, SoundCategory.BLOCKS, 3.0F, 1.0F);
            }
            else if(blockWest.equals(synthBlocks.speaker)){
                worldIn.playSound((EntityPlayer)null, westPos, SoundEvents.block_note_harp, SoundCategory.BLOCKS, 3.0F, 1.0F);
            }
            else if(blockEast.equals(synthBlocks.speaker)){
                worldIn.playSound((EntityPlayer)null, eastPos, SoundEvents.block_note_harp, SoundCategory.BLOCKS, 3.0F, 1.0F);
            }
            else if(blockUp.equals(synthBlocks.speaker)){
                worldIn.playSound((EntityPlayer)null, upPos, SoundEvents.block_note_harp, SoundCategory.BLOCKS, 3.0F, 1.0F);
            }
            else if(blockDown.equals(synthBlocks.speaker)){
                worldIn.playSound((EntityPlayer)null, downPos, SoundEvents.block_note_harp, SoundCategory.BLOCKS, 3.0F, 1.0F);
            }
        }

    }

}
