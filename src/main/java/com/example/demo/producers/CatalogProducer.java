package com.example.demo.producers;

import com.example.demo.config.RabbitMQConfig;
import com.example.demo.dto.MessageDTO;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CatalogProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(CatalogProducer.class);

    @Autowired
    private RabbitMQConfig rabbitMQConfig;

    @Autowired
    private ModelMapper modelMapper;

    @Value("${spring.rabbitmq.exchange}")
    private String exchange;

    @Value("${spring.rabbitmq.routing-key}")
    private String routingKey;

    public MessageDTO sendMessage(MessageDTO messageDTO) {
        rabbitMQConfig.rabbitTemplate().convertAndSend(exchange, routingKey, messageDTO);

        LOGGER.info("Message: {} sent to the exchange: {} with routing key: {}", messageDTO, exchange, routingKey);
        return messageDTO;
    }
}
