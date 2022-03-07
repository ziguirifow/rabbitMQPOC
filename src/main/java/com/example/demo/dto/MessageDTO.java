package com.example.demo.dto;

import lombok.Data;

@Data
public class MessageDTO {

    private ProductDTO product;
    private PriceDTO price;
    private MediaDTO media;
}
