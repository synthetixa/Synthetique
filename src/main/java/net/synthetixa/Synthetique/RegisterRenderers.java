package net.synthetixa.Synthetique;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.synthetixa.Synthetique.blocks.synthBlocks;
import net.synthetixa.Synthetique.items.synthItems;

public class RegisterRenderers {

    public static String modid = SynthMod.MODID;

    public static void registerRenderers()
    {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
                .register(Item.getItemFromBlock(synthBlocks.oscillator), 0, new ModelResourceLocation(modid + ":" + "oscillator", "inventory"));
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
                .register(Item.getItemFromBlock(synthBlocks.oscillator_sine), 0, new ModelResourceLocation(modid + ":" + "oscillator_sine", "inventory"));
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
                .register(Item.getItemFromBlock(synthBlocks.oscillator_saw), 0, new ModelResourceLocation(modid + ":" + "oscillator_saw", "inventory"));
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
                .register(Item.getItemFromBlock(synthBlocks.speaker), 0, new ModelResourceLocation(modid + ":" + "speaker", "inventory"));
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
                .register(Item.getItemFromBlock(synthBlocks.cabinet), 0, new ModelResourceLocation(modid + ":" + "cabinet", "inventory"));

        Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
                .register(synthItems.screwdriver, 0, new ModelResourceLocation(modid + ":" + "screwdriver", "inventory"));
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
                .register(synthItems.capacitor, 0, new ModelResourceLocation(modid + ":" + "capacitor", "inventory"));
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
                .register(synthItems.resistor, 0, new ModelResourceLocation(modid + ":" + "resistor", "inventory"));
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
                .register(synthItems.opamp, 0, new ModelResourceLocation(modid + ":" + "opamp", "inventory"));
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
                .register(synthItems.fivefivefive, 0, new ModelResourceLocation(modid + ":" + "555", "inventory"));
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
                .register(synthItems.tuner, 0, new ModelResourceLocation(modid + ":" + "tuner", "inventory"));
    }

}
