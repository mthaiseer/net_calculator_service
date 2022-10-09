package com.price.service;

import com.price.exception.RateNotFoundException;
import com.price.vo.TaxRate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NetPriceService {

    @Autowired
    private TaxRateProvider taxRateProvider;

    Logger logger = LoggerFactory.getLogger(NetPriceService.class);

    public double calculateNetPrice(double grossPrice, String countryISO) throws RateNotFoundException {

        TaxRate taxRate = taxRateProvider.getTaxRate(countryISO);
        Double netPriceAfterVat  = grossPrice - (grossPrice * taxRate.getTaxRate());
        logger.debug("Net price after tax is: " + netPriceAfterVat);
        return Math.round(netPriceAfterVat * 100.0)/100.0;


    }

}
