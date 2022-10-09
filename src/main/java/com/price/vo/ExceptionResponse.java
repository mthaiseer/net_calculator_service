package com.price.vo;

import lombok.*;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExceptionResponse {
    private Date timestamp;
    private String message;
    private String details;

}
