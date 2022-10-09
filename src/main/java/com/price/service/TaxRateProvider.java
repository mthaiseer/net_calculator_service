package com.price.service;

import com.price.exception.RateNotFoundException;
import com.price.repository.TaxProviderRepository;
import com.price.vo.TaxRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This service is used to get tax rate
 */
@Service
public class TaxRateProvider {

    @Autowired
    private TaxProviderRepository taxRateProviderRepository;

    /**
     * This method is used to get tax rate
     * @param countryIso
     * @return
     * @throws RateNotFoundException
     */
    public TaxRate getTaxRate(String countryISO) throws RateNotFoundException {
        return taxRateProviderRepository.getTaxRate(countryISO);
    }

}
