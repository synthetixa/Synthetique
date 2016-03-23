package net.synthetixa.Synthetique.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class synthBlocks {

    public static Block oscillator; //square wave
    public static Block oscillator_sine;
    public static Block oscillator_saw;
    public static Block speaker;

    public static void initBlocks(){

        oscillator = new oscillator(Material.iron, "oscillator");
        oscillator_sine = new oscillator(Material.iron, "oscillator_sine");
        oscillator_saw = new oscillator(Material.iron, "oscillator_saw");
        speaker = new speaker(Material.iron, "speaker");

        GameRegistry.registerBlock(oscillator, "oscillator");
        GameRegistry.registerBlock(oscillator_sine, "oscillator_sine");
        GameRegistry.registerBlock(oscillator_saw, "oscillator_saw");
        GameRegistry.registerBlock(speaker, "speaker");
    }

}
