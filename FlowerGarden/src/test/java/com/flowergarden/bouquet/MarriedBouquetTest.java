package com.flowergarden.bouquet;
import com.flowergarden.flowers.Chamomile;
import com.flowergarden.flowers.GeneralFlower;
import com.flowergarden.flowers.Rose;
import com.flowergarden.flowers.Tulip;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by OleksiiF on 27.02.2018.
 */
public class MarriedBouquetTest {

    private MarriedBouquet marriedBouquet;
    private GeneralFlower firstFlower = new Chamomile(0, 4, 15, null);
    private GeneralFlower secondFlower = new Rose(true, 7, 20, null);
    private GeneralFlower thirdFlower = new Chamomile(0, 10, 20, null);

    @Before
    public void initMarriedBouqet() {
        marriedBouquet = new MarriedBouquet();
        marriedBouquet.addFlower(firstFlower);
        marriedBouquet.addFlower(secondFlower);
        marriedBouquet.addFlower(thirdFlower);
    }

    @Test
    public void getPriceTest()  {
        marriedBouquet.setAssembledPrice(120);
        float expected = marriedBouquet.getAssembledPrice()
                +firstFlower.getPrice()
                +secondFlower.getPrice()
                +thirdFlower.getPrice();

        Assert.assertEquals(expected, marriedBouquet.getPrice(), 0.0);
    }

    @Test
    public void searchFlowersByLenghtTest() {
        List<GeneralFlower> expected = Arrays.asList(secondFlower, thirdFlower);
        Assert.assertEquals(expected, marriedBouquet.searchFlowersByLenght(5, 10));
    }

    @Test
    public void getPriceEquals135WithMockTest() {
        Rose rose = mock(Rose.class);
        Chamomile chamomile = mock(Chamomile.class);
        Tulip tulip = mock(Tulip.class);

        MarriedBouquet anotherMarriedBouqet = new MarriedBouquet();
        anotherMarriedBouqet.setAssembledPrice(100);
        anotherMarriedBouqet.addFlower(rose);
        anotherMarriedBouqet.addFlower(chamomile);
        anotherMarriedBouqet.addFlower(tulip);

        when(rose.getPrice()).thenReturn(10f);
        when(chamomile.getPrice()).thenReturn(20f);
        when(tulip.getPrice()).thenReturn(5f);

        float expected = anotherMarriedBouqet.getAssembledPrice()
                +rose.getPrice()
                +chamomile.getPrice()
                +tulip.getPrice();
        Assert.assertEquals(expected, anotherMarriedBouqet.getPrice(), 0.0);
    }

}