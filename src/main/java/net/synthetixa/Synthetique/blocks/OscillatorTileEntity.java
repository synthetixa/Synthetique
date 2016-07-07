package net.synthetixa.Synthetique.blocks;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class OscillatorTileEntity extends TileEntity
{
    public float pitch = 0;
    public int type = 0;

    public void changeType(int type) {
        this.type = type;

        this.markDirty();
    }

    public void changePitch(float pitch) {
        this.pitch = pitch;

        this.markDirty();
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);

        compound.setInteger("type", type);
        compound.setFloat("pitch", pitch);

        return compound;
    }

    @Override
    public void readFromNBT(NBTTagCompound compound){
        super.readFromNBT(compound);

        pitch = compound.getFloat("pitch");
        type = compound.getInteger("type");
    }

}
