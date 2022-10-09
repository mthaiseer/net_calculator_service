package com.price.controller;

import com.price.dto.NetPaymentResponse;
import com.price.exception.RateNotFoundException;
import com.price.service.NetPriceService;
import com.price.vo.NetPriceRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RestController
@RequestMapping("/v1/tax-rate")
public class NetPriceController {

    @Autowired
    private  NetPriceService netPriceService;

    /**
     * This method is used to calculate net price
     * @param netPriceRequest
     * @return
     * @throws RateNotFoundException
     */
    @PostMapping
    public ResponseEntity<NetPaymentResponse> getNetPrice(@Validated  @RequestBody NetPriceRequest netPriceRequest) throws RateNotFoundException {
        Double netPrice =   netPriceService
                .calculateNetPrice(
                        netPriceRequest.getGrossPrice(),
                        netPriceRequest.getCountryIso());

        return  ResponseEntity.ok(NetPaymentResponse.builder().netPrice(netPrice).build());
    }
}
