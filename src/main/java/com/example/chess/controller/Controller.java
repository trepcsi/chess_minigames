package com.example.chess.controller;

import com.example.chess.Game;
import com.example.chess.jsonmagic.JsonSerializer;
import com.example.chess.jsonmagic.JsonDeserializer;
import com.example.chess.jsonmagic.MoveDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    @Autowired
    Game game;

    @Autowired
    JsonSerializer jsonSerializer;

    @Autowired
    JsonDeserializer jsonDeserializer;

    @PostMapping("/start")
    @CrossOrigin("*")
    public String start() throws JsonProcessingException {
        game.init();
        return jsonSerializer.boardAsJson(game.getBoard());
    }


    @PostMapping("/move")
    @CrossOrigin("*")
    public String move(@RequestBody String playerMoves) throws JsonProcessingException {
        MoveDto[] m = jsonDeserializer.jsonToMoves(playerMoves);
        game.playerMove(m[0].getX(), m[0].getY(), m[1].getX(), m[1].getY());
        return jsonSerializer.boardAsJson(game.getBoard());

    }

    @GetMapping("/status")
    @CrossOrigin("*")
    public String getStatus() throws JsonProcessingException {
        return jsonSerializer.statusAsJson(game.getStatus());
    }

    @PostMapping("/back")
    @CrossOrigin("*")
    public String moveBack() throws JsonProcessingException {
        game.backMove();
        return jsonSerializer.boardAsJson(game.getBoard());
    }
}
