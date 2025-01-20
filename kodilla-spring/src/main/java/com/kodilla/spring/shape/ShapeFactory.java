package com.kodilla.spring.shape;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@Scope("singleton")
public class ShapeFactory {

    @Bean
    public Square createSquare() {
        return new Square();
    }
}
