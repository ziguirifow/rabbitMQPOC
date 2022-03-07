package com.example.demo.controller;

import com.example.demo.dto.MessageDTO;
import com.example.demo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("message")
public class MessageController {

    @Autowired
    private ProductService productService;

    @GetMapping("getMessage")
    public MessageDTO getMessage() {
        return productService.getMessageDTO();
    }

}
