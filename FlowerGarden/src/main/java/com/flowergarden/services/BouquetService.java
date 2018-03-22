package com.flowergarden.services;

import com.flowergarden.DAO.impl.BouquetDAOimpl;
import com.flowergarden.DAO.impl.FlowerDAOimpl;
import java.util.ArrayList;

/**
 * Created by OleksiiF on 13.03.2018.
 */
public class BouquetService {

    private FlowerDAOimpl flowerDAOimpl;
    private BouquetDAOimpl bouquetDAOimpl;

    public void setFlowerDAOimpl(FlowerDAOimpl flowerDAOimpl) {
        this.flowerDAOimpl = flowerDAOimpl;
    }

    public void setBouquetDAOimpl(BouquetDAOimpl bouquetDAOimpl) {
        this.bouquetDAOimpl = bouquetDAOimpl;
    }

    public float getBouqetPriceService(int bouqetId){
        float priceOfFlowersTogeather = 0.0f;

        ArrayList<Float> flowerPrices = flowerDAOimpl.getFlowerPricesForBouqet(bouqetId);
        for (Float flowerPrice: flowerPrices){
            priceOfFlowersTogeather += flowerPrice;
        }

        return priceOfFlowersTogeather + bouquetDAOimpl.getAssemblePriceForBouqet(bouqetId);
    }
}
