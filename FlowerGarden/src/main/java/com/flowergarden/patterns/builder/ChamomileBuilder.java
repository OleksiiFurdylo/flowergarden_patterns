package com.flowergarden.patterns.builder;

import com.flowergarden.flowers.Chamomile;
import com.flowergarden.properties.FreshnessInteger;

/**
 * Created by OleksiiF on 14.05.2018.
 */

public class ChamomileBuilder {

    private FreshnessInteger freshness;
    private int petals;
    private int lenght;
    private float price;



    public ChamomileBuilder setLenght(int lenght) {
        this.lenght = lenght;
        return this;
    }

    public ChamomileBuilder setPrice(float price) {
        this.price = price;
        return this;
    }

    public ChamomileBuilder setFreshness(FreshnessInteger freshness) {
        this.freshness = freshness;
        return this;
    }

    public ChamomileBuilder setPetals(int petals) {
        this.petals = petals;
        return this;
    }

    public Chamomile build(){
        return new Chamomile(petals, lenght,  price, freshness);
    }
}
