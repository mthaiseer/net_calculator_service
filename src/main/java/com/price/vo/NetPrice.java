package com.price.vo;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class NetPrice {

    private Double grossPrice;
    private Double vatRate;

}
