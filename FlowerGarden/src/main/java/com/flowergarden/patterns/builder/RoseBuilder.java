package com.flowergarden.patterns.builder;

import com.flowergarden.flowers.Rose;
import com.flowergarden.properties.FreshnessInteger;

/**
 * Created by OleksiiF on 14.05.2018.
 */
public class RoseBuilder {

    private FreshnessInteger freshness;
    private boolean spike;
    private int lenght;
    private float price;



    public RoseBuilder setLenght(int lenght) {
        this.lenght = lenght;
        return this;
    }

    public RoseBuilder setPrice(float price) {
        this.price = price;
        return this;
    }

    public RoseBuilder setFreshness(FreshnessInteger freshness) {
        this.freshness = freshness;
        return this;
    }

    public RoseBuilder setSpike(boolean spike) {
        this.spike = spike;
        return this;
    }

    public Rose build(){
        return new Rose(spike, lenght,  price, freshness);
    }
}
