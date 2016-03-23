package net.synthetixa.Synthetique;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.synthetixa.Synthetique.blocks.synthBlocks;

public class RegisterRenderers {

    public static String modid = SynthMod.MODID;

    public static void registerRenderers()
    {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
                .register(Item.getItemFromBlock(synthBlocks.oscillator), 0, new ModelResourceLocation(modid + ":" + "oscillator", "inventory"));
    }

}
