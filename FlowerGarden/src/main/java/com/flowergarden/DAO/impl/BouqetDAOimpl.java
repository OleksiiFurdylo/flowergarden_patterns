package com.flowergarden.DAO.impl;

import com.flowergarden.DAO.BouqetDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by OleksiiF on 13.03.2018.
 */
public class BouqetDAOimpl implements BouqetDAO {

    private Connection conn;

    @Override
    public float getAssemblePriceForBouqet(int bouqetId) {
        float assemblePrice = 0.0f;

        try {
            PreparedStatement st = conn.prepareStatement("SELECT assemble_price FROM bouquet WHERE bouquet.id = ?");
            st.setInt(1, bouqetId);
            ResultSet rs = st.executeQuery();
            assemblePrice = rs.getFloat("assemble_price");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return assemblePrice;
    }

    @Override
    public void setConnection(Connection conn) {
        this.conn = conn;
    }


}
