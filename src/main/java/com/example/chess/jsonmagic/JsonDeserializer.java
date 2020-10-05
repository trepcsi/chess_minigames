package com.example.chess.jsonmagic;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JsonDeserializer {

    @Autowired
    ObjectMapper objectMapper;

    public MoveDto[] jsonToMoves(String playerMoves) throws JsonProcessingException {
        return objectMapper.readValue(playerMoves, MoveDto[].class);
    }
}
