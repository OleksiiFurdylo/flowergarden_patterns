package com.flowergarden.DAO.impl;

import com.flowergarden.DAO.FlowerDAO;
import java.sql.*;
import java.util.ArrayList;

/**
 * Created by OleksiiF on 13.03.2018.
 */
public class FlowerDAOimpl implements FlowerDAO {

    private Connection conn;
    private ArrayList<Float> resultArrayListWithPricesForBouqet = new ArrayList<>();

    @Override
    public ArrayList<Float> getFlowerPricesForBouqet(int bouqetId) {

        try {
            PreparedStatement st = conn.prepareStatement("SELECT price FROM flower WHERE flower.bouquet_id = ?");
            st.setInt(1, bouqetId);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                resultArrayListWithPricesForBouqet.add(rs.getFloat("price"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultArrayListWithPricesForBouqet;
    }

    @Override
    public void setConnection(Connection conn) {
        this.conn = conn;
    }
}
