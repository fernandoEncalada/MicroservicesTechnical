package com.microservice.account_microservice.infrastructure.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.amqp.support.converter.SimpleMessageConverter;

@Configuration
@EnableRabbit
public class RabbitMQConfig {

    private static final String EXCHANGE_NAME = "cliente-exchange";
    private static final String QUEUE_NAME = "cliente.queue";
    private static final String ROUTING_KEY = "cliente.created";

    @Bean
    public TopicExchange clienteExchange() {
        return new TopicExchange(EXCHANGE_NAME);
    }

    @Bean
    public Queue clienteQueue() {
        return new Queue(QUEUE_NAME);
    }

    @Bean
    public Binding binding(Queue clienteQueue, TopicExchange clienteExchange) {
        return BindingBuilder.bind(clienteQueue).to(clienteExchange).with(ROUTING_KEY);
    }

    @Bean
    public MessageConverter messageConverter() {
        // Use SimpleMessageConverter for handling strings
        return new SimpleMessageConverter();
    }

    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }

}
