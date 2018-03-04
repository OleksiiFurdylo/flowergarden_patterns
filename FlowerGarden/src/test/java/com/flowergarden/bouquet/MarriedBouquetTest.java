package com.flowergarden.bouquet;
import com.flowergarden.flowers.Chamomile;
import com.flowergarden.flowers.GeneralFlower;
import com.flowergarden.flowers.Rose;
import com.flowergarden.flowers.Tulip;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by OleksiiF on 27.02.2018.
 */
public class MarriedBouquetTest {

    private MarriedBouquet marriedBouquet;

    private Rose rose = mock(Rose.class);
    private Chamomile chamomile = mock(Chamomile.class);
    private Tulip tulip = mock(Tulip.class);

    @Before
    public void initMarriedBouqet() {
        marriedBouquet = new MarriedBouquet();
        marriedBouquet.addFlower(rose);
        marriedBouquet.addFlower(chamomile);
        marriedBouquet.addFlower(tulip);
    }

    @Test
    public void getPriceEquals135Test()  {
        marriedBouquet.setAssembledPrice(100);

        when(rose.getPrice()).thenReturn(10f);
        when(chamomile.getPrice()).thenReturn(20f);
        when(tulip.getPrice()).thenReturn(5f);

        float expected = marriedBouquet.getAssembledPrice()
                +rose.getPrice()
                +chamomile.getPrice()
                +tulip.getPrice();
        Assert.assertEquals(expected, marriedBouquet.getPrice(), 0.0);
    }

    @Test
    public void searchFlowersByLenght() {
        when(rose.getLenght()).thenReturn(26);
        when(chamomile.getLenght()).thenReturn(16);
        when(tulip.getLenght()).thenReturn(6);

        Collection<GeneralFlower> searchActualResults = marriedBouquet.searchFlowersByLenght(15, 30);

        Assert.assertEquals(Arrays.asList(rose, chamomile), searchActualResults);
        Assert.assertEquals(searchActualResults.size(), 2);
        Assert.assertTrue(searchActualResults.contains(rose));
        Assert.assertTrue(searchActualResults.contains(chamomile));
    }

    @Test
    public void searchStraightForwardFlowersByLenghtTest() {
        GeneralFlower firstFlower = new Chamomile(0, 4, 15, null);
        GeneralFlower secondFlower = new Rose(true, 7, 20, null);
        GeneralFlower thirdFlower = new Chamomile(0, 10, 20, null);

        MarriedBouquet anotherMarriedBouqet = new MarriedBouquet();
        anotherMarriedBouqet.addFlower(firstFlower);
        anotherMarriedBouqet.addFlower(secondFlower);
        anotherMarriedBouqet.addFlower(thirdFlower);

        List<GeneralFlower> expected = Arrays.asList(secondFlower, thirdFlower);
        Assert.assertEquals(expected, anotherMarriedBouqet.searchFlowersByLenght(5, 10));
    }

}