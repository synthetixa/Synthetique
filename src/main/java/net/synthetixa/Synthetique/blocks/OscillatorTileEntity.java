package net.synthetixa.Synthetique.blocks;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;

public class OscillatorTileEntity extends TileEntity implements ITickable
{

    @Override
    public void update() {

    }

    @Override
    public void writeToNBT(NBTTagCompound compound){
        super.writeToNBT(compound);
        float pitch = oscillator.getPitch();
    }

    @Override
    public void readFromNBT(NBTTagCompound compound){
        super.readFromNBT(compound);
    }

}
