package net.synthetixa.Synthetique.client;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.synthetixa.Synthetique.common.CommonProxy;

public class ClientProxy extends CommonProxy{

    @Override
    public void preInit(FMLPreInitializationEvent event)
    {
        super.preInit(event);
    }
    @Override
    public void init(FMLInitializationEvent event)
    {
        super.init(event);

        RegisterRenderers.registerRenderers();
    }
    @Override
    public void postInit(FMLPostInitializationEvent event)
    {
        super.postInit(event);
    }

}
