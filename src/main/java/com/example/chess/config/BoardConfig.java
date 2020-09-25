package com.example.chess.config;

import com.example.chess.Knight;
import com.example.chess.Square;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BoardConfig {

    @Bean
    public Knight knight() {
        return new Knight(new Square(0,0));
    }
}
