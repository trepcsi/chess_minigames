package com.example.chess.jsonmagic;

import com.example.chess.Game;
import com.example.chess.table.Board;
import com.example.chess.table.Square;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class JsonSerializer {

    @Autowired
    ObjectMapper objectMapper;

    public JsonSerializer() {
    }

    public String boardAsJson(Board board) throws JsonProcessingException {
        List<Square> squareList = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            squareList.addAll(Arrays.asList(board.getChessTable()[i]).subList(0, 8));
        }
        return objectMapper.writeValueAsString(squareList);
    }

    public String statusAsJson(Game game) throws JsonProcessingException {
        return objectMapper.writeValueAsString(game);
    }
}
