package com.flowergarden.DAO;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

/**
 * Created by OleksiiF on 13.03.2018.
 */
public interface FlowerDAO {

    ArrayList<Float> getFlowerPricesForBouqet(int bouqetId) throws IOException;
    void setConnection(Connection conn);

}
