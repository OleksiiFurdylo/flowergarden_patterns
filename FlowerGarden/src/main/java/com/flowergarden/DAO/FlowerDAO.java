package com.flowergarden.DAO;

import com.flowergarden.flowers.Flower;
import com.flowergarden.flowers.FlowerWrapper;
import com.flowergarden.flowers.GeneralFlower;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

/**
 * Created by OleksiiF on 13.03.2018.
 */
public interface FlowerDAO {

    ArrayList<Flower> getAllFlowers();
    GeneralFlower getFlower(int id);
    void updateFlower(Flower flower);
    void deleteFlower(Flower flower);
    void addFlower(Flower flower);

    ArrayList<Float> getFlowerPricesForBouqet(int bouqetId) throws IOException;
    void setConnection(Connection conn);

}