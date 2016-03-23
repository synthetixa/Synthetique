package net.synthetixa.Synthetique.blocks;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class OscillatorTileEntity extends TileEntity implements ITickable
{

    World world = OscillatorTileEntity.this.getWorld();
    BlockPos pos = OscillatorTileEntity.this.getPos();

    @Override
    public void update() {

    }

    @Override
    public void writeToNBT(NBTTagCompound compound){
        super.writeToNBT(compound);
    }

    public void readFromNBT(NBTTagCompound compound){
        super.readFromNBT(compound);
    }

}
