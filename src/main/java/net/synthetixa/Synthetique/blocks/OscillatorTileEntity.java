package net.synthetixa.Synthetique.blocks;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.SoundEvent;

import static net.minecraft.init.SoundEvents.BLOCK_NOTE_PLING;
import static net.minecraft.init.SoundEvents.BLOCK_NOTE_SNARE;

public class OscillatorTileEntity extends TileEntity
{

    public SoundEvent sound = BLOCK_NOTE_PLING;
    public int soundID = 0;
    public float pitch = 0.1F;

    public void changeSound(SoundEvent sound) {
        if (sound == BLOCK_NOTE_PLING || soundID == 0) {
            this.sound = BLOCK_NOTE_PLING;
        } else if (sound == BLOCK_NOTE_SNARE || soundID == 1) {
            this.sound = BLOCK_NOTE_SNARE;
        } else if (sound == null || soundID == 2) {
            this.sound = null;
        }
        this.markDirty();
    }

    public void changePitch() {
        if (pitch == 2.0F) {
            pitch = 0.1F;
        } else {
            pitch = pitch + 0.1F;
        }
        this.markDirty();
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);

        if (sound == BLOCK_NOTE_PLING) {
            compound.setInteger("sound", 0);
        } else if (sound == BLOCK_NOTE_SNARE) {
            compound.setInteger("sound", 1);
        } else {
            compound.setInteger("sound", 2);
        }

        compound.setFloat("pitch", pitch);

        return compound;
    }

    @Override
    public void readFromNBT(NBTTagCompound compound){
        super.readFromNBT(compound);

        soundID = compound.getInteger("sound");
        pitch = compound.getFloat("pitch");
    }

}
