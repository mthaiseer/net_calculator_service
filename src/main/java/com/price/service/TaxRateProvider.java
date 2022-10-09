package com.price.service;

import com.price.exception.RateNotFoundException;
import com.price.repository.TaxProviderRepository;
import com.price.vo.TaxRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaxRateProvider {

    @Autowired
    private TaxProviderRepository taxRateProviderRepository;

    public TaxRate getTaxRate(String countryISO) throws RateNotFoundException {
        return taxRateProviderRepository.getTaxRate(countryISO);
    }

}
