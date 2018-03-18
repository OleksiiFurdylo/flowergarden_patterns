package com.flowergarden.flowers;

import com.flowergarden.properties.FreshnessInteger;

/**
 * Created by OleksiiF on 16.03.2018.
 */
public class FlowerWrapper extends GeneralFlower {

    private int id;
    private String name;
    private int length;
    private FreshnessInteger freshness;
    private float price;
    private int petals;
    private int spike;
    private int bouquetId;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setFreshness(FreshnessInteger freshness) {
        this.freshness = freshness;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setPetals(int petals) {
        this.petals = petals;
    }

    public void setSpike(int spike) {
        this.spike = spike;
    }

    public void setBouquetId(int bouquetId) {
        this.bouquetId = bouquetId;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getLength() {
        return length;
    }

    @Override
    public FreshnessInteger getFreshness() {
        return freshness;
    }

    @Override
    public float getPrice() {
        return price;
    }

    public int getPetals() {
        return petals;
    }

    public int getSpike() {
        return spike;
    }

    @Override
    public int getBouquetId() {
        return bouquetId;
    }
}
