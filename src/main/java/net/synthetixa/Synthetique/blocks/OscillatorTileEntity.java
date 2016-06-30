package net.synthetixa.Synthetique.blocks;

import net.minecraft.init.SoundEvents;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class OscillatorTileEntity extends TileEntity
{

    public float pitch = 0.1F;

    public static void changeSound(BlockPos pos, World worldIn) {

        if (worldIn.getBlockState(pos).getValue(oscillator.TYPE).equals(0)) {
            oscillator.sound = SoundEvents.BLOCK_NOTE_PLING;
        } else if (worldIn.getBlockState(pos).getValue(oscillator.TYPE).equals(1)) {
            oscillator.sound = SoundEvents.BLOCK_NOTE_SNARE;
        } else if (worldIn.getBlockState(pos).getValue(oscillator.TYPE).equals(2)) {
            oscillator.sound = null;
        }

    }

    public void changePitch() {

        worldObj.markChunkDirty(pos, this);
        if (pitch == 2.0F) {
            pitch = 0.1F;
        } else {
            pitch = pitch + 0.1F;
        }
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);

        compound.setFloat("pitch", pitch);

        return compound;
    }

    @Override
    public void readFromNBT(NBTTagCompound compound){
        super.readFromNBT(compound);

        pitch = compound.getFloat("pitch");
    }

}
