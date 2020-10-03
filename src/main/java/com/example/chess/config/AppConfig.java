package com.example.chess.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    public ObjectMapper objectMapper (){
        return new ObjectMapper();
    }
}
