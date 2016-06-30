package net.synthetixa.Synthetique.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.synthetixa.Synthetique.SynthMod;
import net.synthetixa.Synthetique.items.synthItems;

public class oscillator extends Block implements ITileEntityProvider{

    public static final PropertyInteger TYPE = PropertyInteger.create("type", 0, 2); // 0 = Sine, 1 = Square, 2 = LFO (no sound)
    public static boolean isPowered;
    public static SoundEvent sound;
    public static float pitch;

    public oscillator(Material material, String unlocalizedName) {
        super(material);
        this.setCreativeTab(CreativeTabs.REDSTONE);
        this.setHardness(1.0F);
        this.setUnlocalizedName(unlocalizedName);
        this.setDefaultState(this.blockState.getBaseState().withProperty(TYPE, 0));
        this.setRegistryName(SynthMod.MODID, "oscillator");
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

    @Override
    public void onNeighborChange(IBlockAccess worldIn, BlockPos pos, BlockPos neighborBlock) {

        World world = worldIn.getTileEntity(pos).getWorld();
        isPowered = world.isBlockPowered(pos);

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

            OscillatorTileEntity.changeSound(pos, world);

            if (worldIn.getBlockState(pos).getValue(TYPE).equals(0) || worldIn.getBlockState(pos).getValue(TYPE).equals(1)) {

                if (isPowered) {

                    if (blockNorth.equals(synthBlocks.speaker)) {
                        world.playSound(null, northPos, sound, SoundCategory.BLOCKS, 3.0F, oscillatorTileEntity.pitch);
                    } else if (blockSouth.equals(synthBlocks.speaker)) {
                        world.playSound(null, southPos, sound, SoundCategory.BLOCKS, 3.0F, oscillatorTileEntity.pitch);
                    } else if (blockWest.equals(synthBlocks.speaker)) {
                        world.playSound(null, westPos, sound, SoundCategory.BLOCKS, 3.0F, oscillatorTileEntity.pitch);
                    } else if (blockEast.equals(synthBlocks.speaker)) {
                        world.playSound(null, eastPos, sound, SoundCategory.BLOCKS, 3.0F, oscillatorTileEntity.pitch);
                    } else if (blockUp.equals(synthBlocks.speaker)) {
                        world.playSound(null, upPos, sound, SoundCategory.BLOCKS, 3.0F, oscillatorTileEntity.pitch);
                    } else if (blockDown.equals(synthBlocks.speaker)) {
                        world.playSound(null, downPos, sound, SoundCategory.BLOCKS, 3.0F, oscillatorTileEntity.pitch);
                    }
                }
            } else if (worldIn.getBlockState(pos).getValue(TYPE).equals(2)) {

            }
        }

    }

    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {

        if (heldItem != null) {
            if (ItemStack.areItemsEqual(new ItemStack(synthItems.screwdriver), heldItem)) {
                if (state.getValue(TYPE).equals(0)) {
                    playerIn.addChatComponentMessage(new TextComponentString("Switching oscillator state from Sine Wave to Square Wave. (this will make sound)"));
                    worldIn.setBlockState(pos, this.blockState.getBaseState().withProperty(TYPE, 1));
                } else if (state.getValue(TYPE).equals(1)) {
                    playerIn.addChatComponentMessage(new TextComponentString("Switching oscillator state from Square Wave to LFO. (this won't make sound)"));
                    worldIn.setBlockState(pos, this.blockState.getBaseState().withProperty(TYPE, 2));
                } else if (state.getValue(TYPE).equals(2)) {
                    playerIn.addChatComponentMessage(new TextComponentString("Switching oscillator state from LFO to Sine Wave. (this will make sound)"));
                    worldIn.setBlockState(pos, this.blockState.getBaseState().withProperty(TYPE, 1));
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