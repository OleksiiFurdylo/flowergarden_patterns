package com.flowergarden.DAO.impl;

import com.flowergarden.DAO.BouqetDAO;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.*;

/**
 * Created by OleksiiF on 13.03.2018.
 */
public class BouquetDAOimpl implements BouqetDAO {

    private Connection conn;

    public BouquetDAOimpl(DriverManagerDataSource dataSource) {
        try {
            this.conn = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

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
