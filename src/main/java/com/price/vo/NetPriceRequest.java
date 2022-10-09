package com.price.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class NetPriceRequest {

//    @NotEmpty(message = "Gross price is mandatory")
    private Double grossPrice;

//    @NotEmpty(message = "Country ISO is mandatory")
    private String countryIso;
}
