package com.flowergarden.services;

import com.flowergarden.DAO.impl.BouqetDAOimpl;
import com.flowergarden.DAO.impl.FlowerDAOimpl;
import com.flowergarden.flowers.Rose;
import com.flowergarden.properties.FreshnessInteger;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by OleksiiF on 13.03.2018.
 */
public class BouqetService {

    private File file = new File("flowergarden.db");
    private String url = "jdbc:sqlite:"+file.getCanonicalFile().toURI();
    private Connection conn;

    public BouqetService() throws IOException {
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public float getBouqetPriceService(int bouqetId){

        FlowerDAOimpl flowerDAOimpl = new FlowerDAOimpl();
        BouqetDAOimpl bouqetDAOimpl = new BouqetDAOimpl();
        float priceOfFlowersTogeather = 0.0f;
        float assemblePrice = 0.0f;

        //get flower prices
        flowerDAOimpl.setConnection(conn);
        ArrayList<Float> flowerPrices = flowerDAOimpl.getFlowerPricesForBouqet(bouqetId);
        for (Float flowerPrice: flowerPrices){
            priceOfFlowersTogeather += flowerPrice;
        }

        //get assemble price
        bouqetDAOimpl.setConnection(conn);
        assemblePrice = bouqetDAOimpl.getAssemblePriceForBouqet(bouqetId);

        /*Rose rose = new Rose(true, 19, 12, new FreshnessInteger(1));
        rose.setBouquetId(2);
        flowerDAOimpl.addFlower(rose);*/

        return priceOfFlowersTogeather + assemblePrice;
    }
}
