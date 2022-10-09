package com.price.controller;

import com.price.dto.TaxRateResponse;
import com.price.exception.RateNotFoundException;
import com.price.service.TaxRateProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This controller is used to get tax rate
 */
@RestController
@RequestMapping("/v1/tax-rate")
public class TaxRateController {


    @Autowired
    private TaxRateProvider taxRateProvider;

    Logger logger = LoggerFactory.getLogger(TaxRateController.class);

    /**
     * This method is used to get tax rate
     * @param countryIso
     * @return
     * @throws RateNotFoundException
     */
    @GetMapping("/{isoCountryCode}")
    public ResponseEntity<TaxRateResponse> getTaxRate(@PathVariable("isoCountryCode") String isoCountryCode) {

        try {

            if(isoCountryCode == null || isoCountryCode.isEmpty()) {
                return ResponseEntity
                        .badRequest()
                        .build();
            }

            return ResponseEntity.ok(
                    taxRateProvider
                            .getTaxRate(isoCountryCode.toUpperCase())
                            .to());
        } catch (RateNotFoundException e) {
            logger.error(e.getLocalizedMessage());
           return ResponseEntity
                   .notFound()
                   .build();
        }
    }


}
