package net.synthetixa.Synthetique.crafting;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.synthetixa.Synthetique.blocks.synthBlocks;
import net.synthetixa.Synthetique.items.synthItems;

public class synthCrafting {

    public static void initCrafting() {
        GameRegistry.addRecipe(new ItemStack(synthItems.screwdriver), new Object[]{" # ", " $ ", " $ ", '#', Items.iron_ingot, '$', Blocks.hardened_clay});
        GameRegistry.addRecipe(new ItemStack(synthItems.resistor), new Object[]{"   ", "#I#", "   ", '#', Items.iron_ingot, 'I', Blocks.hardened_clay});
        GameRegistry.addRecipe(new ItemStack(synthItems.capacitor), new Object[]{"   ", " I ", " # ", '#', Items.iron_ingot, 'I', Blocks.hardened_clay});
        GameRegistry.addRecipe(new ItemStack(synthItems.opamp), new Object[]{"###", "+I+", "###", '#', Blocks.stone, 'I', Items.redstone, '+', synthItems.capacitor});
        GameRegistry.addRecipe(new ItemStack(synthItems.fivefivefive), new Object[]{"###", "+I+", "###", '#', Blocks.stone, 'I', Items.redstone, '+', synthItems.resistor});
        GameRegistry.addRecipe(new ItemStack(synthBlocks.oscillator_sine), new Object[]{"###", "-I-", "###", '#', Blocks.stone, 'I', synthItems.fivefivefive, '-', synthItems.resistor});
        GameRegistry.addRecipe(new ItemStack(synthBlocks.speaker), new Object[]{"###", "+I+", "###", '#', Blocks.stone, 'I', synthItems.opamp, '+', synthItems.capacitor});
        GameRegistry.addRecipe(new ItemStack(synthItems.tuner), new Object[]{"###", "$@$", "###", '#', Items.iron_ingot, '$', Blocks.unpowered_repeater, '@', Items.redstone});
    }

}
