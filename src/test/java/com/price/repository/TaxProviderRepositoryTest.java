package com.price.repository;

import com.price.exception.RateNotFoundException;
import com.price.vo.TaxRate;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@RunWith(SpringRunner.class)
public class TaxProviderRepositoryTest {

    @Autowired
    private TaxProviderRepository taxProviderRepository;

    @Test
    public void testGetTaxRateSuccess() throws RateNotFoundException {
        TaxRate deTaxrate = taxProviderRepository.getTaxRate("DE");
        assertEquals(deTaxrate.getCountryISO(), "DE");
    }

    @Test(expected = RateNotFoundException.class)
    public void testGetTaxRateInvalidCountryCode() throws RateNotFoundException {
        TaxRate deTaxrate = taxProviderRepository.getTaxRate("OO");
        assertEquals(deTaxrate.getCountryISO(), "OO");
    }



}
