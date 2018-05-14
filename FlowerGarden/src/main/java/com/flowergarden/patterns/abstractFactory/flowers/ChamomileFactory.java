package com.flowergarden.patterns.abstractFactory.flowers;

import com.flowergarden.flowers.Chamomile;
import com.flowergarden.flowers.GeneralFlower;
import com.flowergarden.patterns.abstractFactory.FlowerFactory;
import com.flowergarden.properties.FreshnessInteger;

/**
 * Created by OleksiiF on 14.05.2018.
 */
public class ChamomileFactory extends FlowerFactory {
    @Override
    public GeneralFlower createFlowerSetFreshness5() {
        return new Chamomile(6, 15, 30, new FreshnessInteger(5));
    }

    @Override
    public GeneralFlower createFlowerSetFreshness10() {
        return new Chamomile(6, 15, 30, new FreshnessInteger(10));
    }

    @Override
    public GeneralFlower createFlowerSetFreshness15() {
        return new Chamomile(6, 15, 30, new FreshnessInteger(15));
    }
}
