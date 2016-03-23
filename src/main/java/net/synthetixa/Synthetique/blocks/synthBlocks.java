package net.synthetixa.Synthetique.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class synthBlocks {

    public static Block oscillator;

    public static void initBlocks(){

        oscillator = new oscillator(Material.iron);

        GameRegistry.registerBlock(oscillator, "oscillator");

    }

}
