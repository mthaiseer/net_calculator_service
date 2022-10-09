package com.price.vo;

import com.price.dto.TaxRateResponse;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class TaxRate {

    private String countryISO;
    private Double taxRate;

    public TaxRateResponse to(){
        return TaxRateResponse.builder()
                .countryISO(this.countryISO)
                .taxRate(this.taxRate)
                .build();
    }

}
