package net.synthetixa.Synthetique.crafting;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.synthetixa.Synthetique.blocks.synthBlocks;
import net.synthetixa.Synthetique.items.synthItems;

public class synthCrafting {

    public static void initCrafting() {
        GameRegistry.addRecipe(new ItemStack(synthItems.screwdriver), " # ", " $ ", " $ ", '#', Items.IRON_INGOT, '$', Blocks.HARDENED_CLAY);
        GameRegistry.addRecipe(new ItemStack(synthItems.resistor), "   ", "#I#", "   ", '#', Items.IRON_INGOT, 'I', Blocks.HARDENED_CLAY);
        GameRegistry.addRecipe(new ItemStack(synthItems.capacitor), "   ", " I ", " # ", '#', Items.IRON_INGOT, 'I', Blocks.HARDENED_CLAY);
        GameRegistry.addRecipe(new ItemStack(synthItems.opamp), "###", "+I+", "###", '#', Blocks.STONE, 'I', Items.REDSTONE, '+', synthItems.capacitor);
        GameRegistry.addRecipe(new ItemStack(synthItems.fivefivefive), "###", "+I+", "###", '#', Blocks.STONE, 'I', Items.REDSTONE, '+', synthItems.resistor);
        GameRegistry.addRecipe(new ItemStack(synthBlocks.oscillator), "###", "-I-", "###", '#', Blocks.STONE, 'I', synthItems.fivefivefive, '-', synthItems.resistor);
        GameRegistry.addRecipe(new ItemStack(synthBlocks.speaker), "###", "+I+", "###", '#', Blocks.STONE, 'I', synthItems.opamp, '+', synthItems.capacitor);
        GameRegistry.addRecipe(new ItemStack(synthItems.tuner), "###", "$@$", "###", '#', Items.IRON_INGOT, '$', Blocks.UNPOWERED_REPEATER, '@', Items.REDSTONE);
    }

}
