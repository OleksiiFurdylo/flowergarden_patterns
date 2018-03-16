package com.flowergarden.run;

import com.flowergarden.DAO.impl.FlowerDAOimpl;
import com.flowergarden.flowers.GeneralFlower;
import com.flowergarden.services.BouqetService;
import java.io.IOException;

public class Run {

	public static void main(String[] args) throws IOException {

	    int bouquetIdToFindPrice = 1;

        System.out.println(new BouqetService()
                .getBouqetPriceService(bouquetIdToFindPrice)+" <---bouquet price with id:"+bouquetIdToFindPrice);


	}

}
