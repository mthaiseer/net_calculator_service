package com.price.dto;

import lombok.*;
import org.springframework.stereotype.Service;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NetPaymentResponse {

    private Double netPrice;


}
