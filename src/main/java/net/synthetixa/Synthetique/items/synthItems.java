package net.synthetixa.Synthetique.items;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class synthItems {
    public static Item screwdriver;
    public static Item capacitor;
    public static Item opamp;
    public static Item fivefivefive;
    public static Item resistor;
    public static Item tuner;

    public static void initItems()
    {
        screwdriver = new tool("screwdriver");
        capacitor = new component("capacitor");
        resistor = new component("resistor");
        opamp = new IC("opamp");
        fivefivefive = new IC("555");
        tuner = new tool("tuner");

        GameRegistry.register(screwdriver);
        GameRegistry.register(capacitor);
        GameRegistry.register(resistor);
        GameRegistry.register(opamp);
        GameRegistry.register(fivefivefive);
        GameRegistry.register(tuner);
    }

}
