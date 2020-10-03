package com.example.chess.controller;

import com.example.chess.Game;
import com.example.chess.jsonmagic.JsonDeserializer;
import com.example.chess.jsonmagic.JsonSerializer;
import com.example.chess.table.MoveDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    Game game;

    @Autowired
    JsonDeserializer jsonDeserializer;

    @Autowired
    JsonSerializer jsonSerializer;

    @PostMapping("/start")
    @CrossOrigin("*")
    public String getKnight() throws JsonProcessingException {
        game = new Game();
        return jsonDeserializer.boardAsJson(game.getBoard());
    }



    @PostMapping("/move")
    @CrossOrigin("*")
    public String move(@RequestBody String playerMoves) throws JsonProcessingException {
        MoveDto[] m = jsonSerializer.jsonToMoves(playerMoves);
        game.playerMove(m[0].getX(),m[0].getY(),m[1].getX(),m[1].getY());
        return jsonDeserializer.boardAsJson(game.getBoard());

    }
}
