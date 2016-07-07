package net.synthetixa.Synthetique.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class synthBlocks {

    public static Block oscillator;
    public static Block speaker;
    public static Block patchCable;

    public static void initBlocks() {

        oscillator = new oscillator(Material.IRON, "oscillator");
        speaker = new speaker(Material.IRON, "speaker");
        patchCable = new cable(Material.CLAY, "cable");

        GameRegistry.register(oscillator);
        GameRegistry.register(new ItemBlock(oscillator), oscillator.getRegistryName());
        GameRegistry.register(speaker);
        GameRegistry.register(new ItemBlock(speaker), speaker.getRegistryName());
        GameRegistry.register(patchCable);
        GameRegistry.register(new ItemBlock(patchCable), patchCable.getRegistryName());

    }

    public static void initTileEntities() {
        GameRegistry.registerTileEntity(OscillatorTileEntity.class, "oscillator");
    }

}
