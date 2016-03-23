package net.synthetixa.Synthetique.items;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class synthItems {
    public static Item capacitor;
    public static Item opamp;
    public static Item fivefivefive;
    public static Item resistor;

    public static void initItems()
    {
        capacitor = new component("capacitor");
        resistor = new component("resistor");
        opamp = new IC("opamp");
        fivefivefive = new IC("555");

        GameRegistry.registerItem(capacitor, "capacitor");
        GameRegistry.registerItem(resistor, "resistor");
        GameRegistry.registerItem(opamp, "opamp");
        GameRegistry.registerItem(fivefivefive, "555");
    }

}
