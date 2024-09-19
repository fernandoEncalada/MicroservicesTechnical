package com.microservice.account_microservice.infrastructure.rabbitmq;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservice.account_microservice.application.service.CuentaService;
import com.microservice.account_microservice.infrastructure.adapter.in.rest.dto.in.ClientResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccountEventListener {

    private final CuentaService cuentaService;
    private final ObjectMapper objectMapper;

    @RabbitListener(queues = "cliente.queue")
    public void handleClienteCreated(String cliente) {
        ClientResponseDto clientResponseDto;
        try {
            clientResponseDto = objectMapper.readValue(cliente, ClientResponseDto.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        log.info("Mensaje recibido!!!!!!!: " + clientResponseDto.toString());
        cuentaService.asociarClienteConCuenta(clientResponseDto);
    }

}
