package com.example.chess.controller;

import com.example.chess.Game;
import com.example.chess.Move;
import com.example.chess.table.MoveDto;
import com.example.chess.table.Square;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    Game game;

    @PostMapping("/start")
    @CrossOrigin("*")
    public String getKnight() throws JsonProcessingException {
        game = new Game();
        return game.getBoard().boardAsJson();
    }



    @PostMapping("/move")
    @CrossOrigin("*")
    public String move(@RequestBody String moves) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        MoveDto[] m = objectMapper.readValue(moves, MoveDto[].class);
        game.playerMove(m[0].getX(),m[0].getY(),m[1].getX(),m[1].getY());
        return game.getBoard().boardAsJson();

    }
}
