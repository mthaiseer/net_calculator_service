package com.price.repository;

import com.price.exception.RateNotFoundException;
import com.price.vo.TaxRate;
import org.springframework.stereotype.Repository;
import java.util.Map;

@Repository
public class TaxProviderRepository {

    private static Map<String, Double> taxRateMap = Map.of(
            "DE", 0.19,
            "FR", 0.20,
            "IT", 0.22,
            "ES", 0.21,
            "PL", 0.23
    );

    public TaxRate getTaxRate(String countryISO) throws RateNotFoundException {

        if(!taxRateMap.containsKey(countryISO)){
            throw new RateNotFoundException("Invalid Country Code");
        }

        return new TaxRate(countryISO, taxRateMap.get(countryISO));
    }
}
