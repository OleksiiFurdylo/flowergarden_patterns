package com.flowergarden.bouquet;

import com.flowergarden.flowers.Chamomile;
import com.flowergarden.flowers.GeneralFlower;
import com.flowergarden.flowers.Rose;
import com.flowergarden.flowers.Tulip;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by OleksiiF on 27.02.2018.
 */
public class MarriedBouquetTest {

    private MarriedBouquet marriedBouquet;

    @Before
    public void initMarriedBouqet() {
        marriedBouquet = new MarriedBouquet();

        marriedBouquet.addFlower(new Chamomile(0, 4, 15, null));
        marriedBouquet.addFlower(new Rose(true, 7, 20, null));
        marriedBouquet.addFlower(new Chamomile(0, 11, 20, null));

    }

    @Test
    public void getPriceTest()  {



        float expected = marriedBouquet.getPrice();
        Assert.assertEquals(expected, 120+15+20+20, 0.0);
    }

    @Test
    public void searchFlowersByLenghtTest() {

        List<GeneralFlower> expected = Arrays.asList();
        Assert.assertEquals(expected, marriedBouquet.searchFlowersByLenght(5, 10));
    }

}