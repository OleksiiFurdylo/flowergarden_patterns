package com.flowergarden.DAO.impl;

import com.flowergarden.DAO.FlowerDAO;
import com.flowergarden.flowers.*;
import com.flowergarden.properties.FreshnessInteger;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by OleksiiF on 13.03.2018.
 */
public class FlowerDAOimpl implements FlowerDAO {

    private Connection conn;
    private ArrayList<Float> resultArrayListWithPricesForBouqet = new ArrayList<>();

    @Override
    public ArrayList<Flower> getAllFlowers() {
        ArrayList<Flower> allFlowers = new ArrayList<>();
        FlowerWrapper flower = new FlowerWrapper();

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM flower");
            while (rs.next()) {
                flower.setId(rs.getInt("id"));
                flower.setName(rs.getString("name"));
                flower.setLength(rs.getInt("lenght"));//as named in db
                flower.setFreshness(new FreshnessInteger(rs.getInt("freshness")));
                flower.setPrice(rs.getFloat("price"));
                flower.setPetals(rs.getInt("petals"));
                flower.setSpike(rs.getInt("spike"));
                flower.setBouquetId(rs.getInt("bouquet_id"));

                allFlowers.add(flower);
            }

            st.close();
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allFlowers;
    }

    @Override
    public GeneralFlower getFlower(int id) {
        FlowerWrapper flowerWrapper = new FlowerWrapper();


        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM flower WHERE id= " + id);
            flowerWrapper.setId(rs.getInt("id"));
            flowerWrapper.setName(rs.getString("name"));
            flowerWrapper.setLength(rs.getInt("lenght"));//as named in db
            flowerWrapper.setFreshness(new FreshnessInteger(rs.getInt("freshness")));
            flowerWrapper.setPrice(rs.getFloat("price"));
            flowerWrapper.setPetals(rs.getInt("petals"));
            flowerWrapper.setSpike(rs.getInt("spike"));
            flowerWrapper.setBouquetId(rs.getInt("bouquet_id"));

            st.close();
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return flowerWrapper;
    }

    @Override
    public void updateFlower(Flower flower) {
        try {
            //PreparedStatement st = conn.prepareStatement("UPDATE flower SET bouquet_id = 11, lenght = 122 WHERE id = 2");
            PreparedStatement st = conn.prepareStatement("UPDATE flower SET lenght = ?, " +
                    "freshness = ?, price = ?, petals = ?, spike = ?, bouquet_id = ?  WHERE id =?");
            st.setFloat(1, flower.getLenght());
            st.setInt(2, (Integer) flower.getFreshness().getFreshness());
            st.setInt(2, ((GeneralFlower)flower).getFreshness().getFreshness());
            st.setFloat(3, flower.getPrice());
            st.setInt(6, ((GeneralFlower) flower).getBouquetId());
            st.setInt(6, ((FlowerWrapper) flower).getBouquetId());
            st.setInt(7, ((FlowerWrapper) flower).getId());
            if(flower instanceof Rose) {st.setBoolean(5, ((Rose) flower).getSpike());}
            if(flower instanceof Chamomile) {st.setInt(4, ((Chamomile) flower).getPetals());}

            st.executeUpdate();


            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteFlower(Flower flower) {
        int id = ((GeneralFlower) flower).getFlowerId();
        try {
            Statement st = conn.createStatement();
            st.execute("DELETE FROM flowers WHERE id = "+ id);

            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void addFlower(Flower flower) {
        try {
            PreparedStatement st = conn.prepareStatement(
                    "INSERT INTO flower (name, lenght, price, freshness, petals, spike, bouquet_id) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?)");

            st.setFloat(2, flower.getLenght());
            st.setFloat(3, flower.getPrice());
            st.setFloat(4, (Integer)flower.getFreshness().getFreshness());
            st.setInt(7, ((GeneralFlower)flower).getBouquetId());
            if (flower instanceof Rose){
                st.setString(1, "rose");
                st.setBoolean(6, ((Rose) flower).getSpike());
                //st.setNull(5, Integer.parseInt(null));
            } else if (flower instanceof Chamomile) {
                st.setString(1, "chamomile");
                st.setInt(5, ((Chamomile) flower).getPetals());
                //st.setNull(6, Integer.parseInt(null));
            } else if (flower instanceof Tulip) {
                st.setString(1, "tulip");
            }

            st.executeUpdate();
            st.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Float> getFlowerPricesForBouqet(int bouqetId) {

        try {
            //PreparedStatement st = conn.prepareStatement("SELECT price FROM flower WHERE flower.bouquet_id = ?");
            PreparedStatement st = conn.prepareStatement("SELECT * FROM flower WHERE flower.bouquet_id = ?");
            st.setInt(1, bouqetId);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                resultArrayListWithPricesForBouqet.add(rs.getFloat("price"));
            }

            st.close();
            rs.close();
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
