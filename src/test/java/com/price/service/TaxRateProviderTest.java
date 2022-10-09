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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@RunWith(SpringRunner.class)
public class TaxRateProviderTest {

    @InjectMocks
    private TaxRateProvider taxRateProvider;

    @Mock
    private TaxProviderRepository taxRateProviderRepository;


    @Test
    public  void testGetTaxRate() throws RateNotFoundException {
        when(taxRateProviderRepository.getTaxRate("DE")).thenReturn(new TaxRate("DE", 0.19));
        TaxRate taxRate  =  taxRateProvider.getTaxRate("DE");
        assertEquals(taxRate.getCountryISO(), "DE");

    }


    @Test(expected = RuntimeException.class)
    public  void testGetTaxRateInvalidISOCode() throws RateNotFoundException {
        when(taxRateProviderRepository.getTaxRate("OO")).thenThrow(new RuntimeException("Invalid ISO Code"));
        TaxRate taxRate  =  taxRateProvider.getTaxRate("OO");


    }





}
