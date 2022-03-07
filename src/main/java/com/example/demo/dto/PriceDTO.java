package com.example.demo.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PriceDTO {

    private String currency;
    private BigDecimal value;
}
