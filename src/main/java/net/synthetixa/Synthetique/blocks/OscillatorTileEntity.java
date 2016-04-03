package net.synthetixa.Synthetique.blocks;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;

public class OscillatorTileEntity extends TileEntity implements ITickable
{

    public float pitch = 0.1F;

    @Override
    public void update() {

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
    public void writeToNBT(NBTTagCompound compound){
        super.writeToNBT(compound);

        compound.setFloat("pitch", pitch);
    }

    @Override
    public void readFromNBT(NBTTagCompound compound){
        super.readFromNBT(compound);

        pitch = compound.getFloat("pitch");
    }

}
