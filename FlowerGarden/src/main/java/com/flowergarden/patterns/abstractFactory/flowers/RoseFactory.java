package com.flowergarden.patterns.abstractFactory.flowers;

import com.flowergarden.flowers.GeneralFlower;
import com.flowergarden.flowers.Rose;
import com.flowergarden.patterns.abstractFactory.FlowerFactory;
import com.flowergarden.properties.FreshnessInteger;

/**
 * Created by OleksiiF on 14.05.2018.
 */
public class RoseFactory extends FlowerFactory{
    @Override
    public GeneralFlower createFlowerSetFreshness5() {
        return new Rose(true, 10, 20, new FreshnessInteger(5));
    }

    @Override
    public GeneralFlower createFlowerSetFreshness10() {
        return new Rose(true, 10, 20, new FreshnessInteger(10));
    }

    @Override
    public GeneralFlower createFlowerSetFreshness15() {
        return new Rose(true, 10, 20, new FreshnessInteger(15));
    }
}
