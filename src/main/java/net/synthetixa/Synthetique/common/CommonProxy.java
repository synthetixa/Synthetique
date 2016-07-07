package net.synthetixa.Synthetique.common;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.synthetixa.Synthetique.blocks.synthBlocks;
import net.synthetixa.Synthetique.crafting.synthCrafting;
import net.synthetixa.Synthetique.items.synthItems;

public class CommonProxy {

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        synthBlocks.initBlocks();
        synthItems.initItems();
    }
    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        synthCrafting.initCrafting();
        synthBlocks.initTileEntities();
    }
    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {

    }

}
