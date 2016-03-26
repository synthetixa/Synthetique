package net.synthetixa.Synthetique;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.synthetixa.Synthetique.common.CommonProxy;

@Mod(modid = SynthMod.MODID, version = SynthMod.VERSION)
public class SynthMod
{
    public static final String MODID = "synthetique";
    public static final String VERSION = "0.0.4";

    @SidedProxy(clientSide = "net.synthetixa.Synthetique.client.ClientProxy", serverSide = "net.synthetixa.Synthetique.server.ServerProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        this.proxy.preInit(event);
    }
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        this.proxy.init(event);
    }
    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        this.proxy.postInit(event);
    }
}
