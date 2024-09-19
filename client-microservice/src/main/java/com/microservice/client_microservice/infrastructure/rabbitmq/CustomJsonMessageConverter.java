package com.microservice.client_microservice.infrastructure.rabbitmq;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservice.client_microservice.infrastructure.adapter.in.rest.dto.out.ClientResponseDto;
import org.springframework.amqp.support.converter.MessageConversionException;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.stereotype.Component;

@Component
public class CustomJsonMessageConverter implements MessageConverter {

    private final ObjectMapper objectMapper;

    public CustomJsonMessageConverter() {
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public Message toMessage(Object object, MessageProperties messageProperties) throws MessageConversionException {
        try {
            byte[] bytes = objectMapper.writeValueAsBytes(object);
            messageProperties.setContentType(MessageProperties.CONTENT_TYPE_JSON);
            return new Message(bytes, messageProperties);
        } catch (Exception e) {
            throw new MessageConversionException("Error converting to JSON", e);
        }
    }

    @Override
    public Object fromMessage(Message message) throws MessageConversionException {
        try {
            return objectMapper.readValue(message.getBody(), ClientResponseDto.class);
        } catch (Exception e) {
            throw new MessageConversionException("Error converting from JSON", e);
        }
    }
}
