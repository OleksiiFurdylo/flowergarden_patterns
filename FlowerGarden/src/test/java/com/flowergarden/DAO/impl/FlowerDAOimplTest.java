package com.flowergarden.DAO.impl;

import com.flowergarden.flowers.*;
import com.flowergarden.properties.FreshnessInteger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.*;
import java.util.ArrayList;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * Created by OleksiiF on 16.03.2018.
 */
@RunWith(MockitoJUnitRunner.class)
public class FlowerDAOimplTest {

    @InjectMocks
    private FlowerDAOimpl flowerDAOimpl = new FlowerDAOimpl();;

    @Mock
    private Connection conn;

    @Mock
    private PreparedStatement prst;

    @Mock
    private Statement st;

    @Mock
    private ResultSet rs;

    private FlowerWrapper flowerRose;
    private int testID = 6;


    @Before
    public void initFlowerDao() throws SQLException {
        flowerDAOimpl.setConnection(conn);
        when(conn.prepareStatement(any(String.class))).thenReturn(prst);
        when(conn.createStatement()).thenReturn(prst);
        when(st.executeQuery(any(String.class))).thenReturn(rs);

        flowerRose = new FlowerWrapper();
        flowerRose.setBouquetId(1);
        flowerRose.setId(testID);
        flowerRose.setName("rose");
        flowerRose.setLength(121);
        flowerRose.setFreshness(new FreshnessInteger(1));
        flowerRose.setPrice(15.6f);
        flowerRose.setSpike(1);

        when(rs.getInt("bouquet_id")).thenReturn(flowerRose.getBouquetId());
        when(rs.getInt("id")).thenReturn(flowerRose.getId());
        when(rs.getString("name")).thenReturn(flowerRose.getName());
        when(rs.getInt("lenght")).thenReturn(flowerRose.getLength());
        when(rs.getInt("freshness")).thenReturn(flowerRose.getFreshness().getFreshness());
        when(rs.getFloat("price")).thenReturn(flowerRose.getPrice());
        when(rs.getInt("petals")).thenReturn(flowerRose.getPetals());
        when(rs.getInt("spike")).thenReturn(flowerRose.getSpike());

        when(rs.next()).thenReturn(true).thenReturn(false);

        when(prst.executeQuery()).thenReturn(rs);
        when(prst.executeUpdate()).thenReturn(1);
    }


    @Test
    public void updateFlower() throws Exception { // test not working not updating, but is it have to?
        flowerDAOimpl.addFlower(flowerRose);
        flowerRose.setPrice(23);
        flowerDAOimpl.updateFlower(flowerRose);

        Assert.assertEquals(flowerRose.getPrice(), flowerDAOimpl.getFlower(2).getPrice(), 0.0);

    }

    @Test
    public void addFlower() throws Exception {
        flowerDAOimpl.addFlower(flowerRose);
        Assert.assertEquals(flowerRose.getLenght(), flowerDAOimpl.getFlower(testID).getLenght());

    }

    @Test
    public void getFlowerPricesForBouqet() throws Exception {

        ArrayList<Float> flowerPrices = flowerDAOimpl.getFlowerPricesForBouqet(1);
        float price = 0;

        for (Float f: flowerPrices) {price += f;}
        Assert.assertEquals(15.6f, price, 0.1); // one flower in bouquet and assemble price added in service

    }

    @Test
    public void setConnection() throws Exception {
        flowerDAOimpl.setConnection(conn);
        Assert.assertEquals(false, conn.isClosed());
    }

}