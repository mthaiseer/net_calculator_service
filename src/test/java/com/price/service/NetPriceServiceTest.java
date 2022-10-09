package com.price.service;

import com.price.exception.RateNotFoundException;
import com.price.repository.TaxProviderRepository;
import com.price.vo.TaxRate;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@RunWith(SpringRunner.class)
public class NetPriceServiceTest {


    @InjectMocks
    private NetPriceService netPriceService;

    @Mock
    private TaxRateProvider taxRateProvider;


    @Test
    public void testGetNetPriceDE() throws RateNotFoundException {

        //Get tax rate from TaxRateProvider
        when(taxRateProvider.getTaxRate("DE")).thenReturn(new TaxRate("DE", 0.19));

        //calculate net price
        Double netPrice  =  netPriceService.calculateNetPrice(100.0, "DE");
        assertEquals(netPrice, Double.valueOf(81.0));



    }

    @Test
    public void testGetNetPriceFR() throws RateNotFoundException {

        //Get tax rate from TaxRateProvider
        when(taxRateProvider.getTaxRate("FR")).thenReturn(new TaxRate("FR", 0.20));

        //calculate net price
        Double netPrice  =  netPriceService.calculateNetPrice(1.99, "FR");
        assertEquals(netPrice, Double.valueOf(1.59));



    }



}
