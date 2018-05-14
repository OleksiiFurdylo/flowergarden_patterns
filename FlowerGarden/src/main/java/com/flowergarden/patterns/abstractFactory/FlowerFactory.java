package com.flowergarden.patterns.abstractFactory;

import com.flowergarden.flowers.GeneralFlower;

/**
 * Created by OleksiiF on 14.05.2018.
 */
public abstract class FlowerFactory {
    public abstract GeneralFlower createFlowerSetFreshness5();
    public abstract GeneralFlower createFlowerSetFreshness10();
    public abstract GeneralFlower createFlowerSetFreshness15();
}
