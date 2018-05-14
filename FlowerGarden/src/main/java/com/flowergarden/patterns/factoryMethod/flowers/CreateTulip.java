package com.flowergarden.patterns.factoryMethod.flowers;

import com.flowergarden.flowers.Flower;
import com.flowergarden.flowers.Tulip;
import com.flowergarden.patterns.factoryMethod.FlowerCreator;
import com.flowergarden.properties.FreshnessInteger;

/**
 * Created by OleksiiF on 14.05.2018.
 */
public class CreateTulip implements FlowerCreator {
    @Override
    public Flower createFlower(boolean spike, int lenght, float price, FreshnessInteger fresh, int petals) {
        return new Tulip();
    }
}
