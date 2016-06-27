package net.synthetixa.Synthetique.common;

import com.google.common.base.Optional;
import net.minecraft.block.properties.PropertyHelper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by ben on 6/27/16.
 */
public class PropertyFloat extends PropertyHelper<Float> {

    private List<Float> allowedValues = new ArrayList<Float>();
    private String nameVal;

    public PropertyFloat(String name, float min, float max) {
        super(name, Float.class);
        nameVal = name;

        if (min < 0) {
            throw new IllegalArgumentException("Min value of " + name + " must be 0 or greater");
        } else if (max <= min) {
            throw new IllegalArgumentException("Max value of " + name + " must be greater than min (" + min + ")");
        }

        for (Float i = min; i <= max; i++) {
            allowedValues.add(i);
        }

    }

    public static PropertyFloat create(String name, Float min, Float max) {
        return new PropertyFloat(name, min, max);
    }

    @Override
    public Collection getAllowedValues() {
        return allowedValues;
    }

    @Override
    public Class getValueClass() {
        return Float.class;
    }

    @Override
    public Optional<Float> parseValue(String value) {
        try {
            Float aFloat = Float.valueOf(value);
            return this.allowedValues.contains(aFloat) ? Optional.of(aFloat) : Optional.<Float>absent();
        } catch (NumberFormatException var3) {
            return Optional.absent();
        }
    }

    @Override
    public String getName(Float value) {
        return this.nameVal;
    }
}
