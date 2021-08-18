package com.bwhome.register.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class DirectRabbitConfig {

    @Bean
    public Queue sendMessageQueue(){
        return new Queue("sendMessageQueue");
    }

    @Bean
    public DirectExchange sendMessageExchange(){
        return new DirectExchange("sendMessageExchange", true, false);
    }

    @Bean
    Binding bindingDirect(){
        return BindingBuilder.bind(sendMessageQueue()).to(sendMessageExchange()).with("sendMessageRouting");
    }

    @Bean
    DirectExchange lonelyDirectExchange(){
        return new DirectExchange("lonelyDirectExchange");
    }
}
