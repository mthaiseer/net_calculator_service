package com.price.dto;


import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class TaxRateResponse {

    private String countryISO;
    private Double taxRate;


}
