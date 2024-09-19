package com.microservice.client_microservice.infrastructure.rabbitmq;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservice.client_microservice.infrastructure.adapter.in.rest.dto.out.ClientResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ClienteEventPublisher {

    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper;

    private static final String EXCHANGE_NAME = "cliente-exchange";
    private static final String ROUTING_KEY = "cliente.created";

    public void publishClienteCreated(ClientResponseDto client) {
        String payload;
        try {
            payload = objectMapper.writeValueAsString(client);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        log.info("Cliente a mandar!!!!!: {}", payload);
        rabbitTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY, payload);
    }
}
