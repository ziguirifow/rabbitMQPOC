package com.example.demo.entities;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Price {

    private String currency;

    private BigDecimal value;
}
