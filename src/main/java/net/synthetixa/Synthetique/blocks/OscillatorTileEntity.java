package net.synthetixa.Synthetique.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityNote;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;

public class OscillatorTileEntity extends TileEntity implements ITickable
{


    @Override
    public void update() {

    }

    @Override
    public void writeToNBT(NBTTagCompound compound){
        super.writeToNBT(compound);
    }

    @Override
    public void readFromNBT(NBTTagCompound compound){
        super.readFromNBT(compound);
    }

}
