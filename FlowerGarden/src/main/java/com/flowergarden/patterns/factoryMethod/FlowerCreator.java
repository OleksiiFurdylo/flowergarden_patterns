package com.flowergarden.patterns.factoryMethod;

import com.flowergarden.flowers.Flower;
import com.flowergarden.properties.FreshnessInteger;

/**
 * Created by OleksiiF on 14.05.2018.
 */
public interface FlowerCreator {
    Flower createFlower(boolean spike, int lenght, float price, FreshnessInteger fresh, int petals);
}
