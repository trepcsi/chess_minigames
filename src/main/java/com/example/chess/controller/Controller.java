package com.example.chess.controller;

import com.example.chess.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    Game game;

    @GetMapping
    public String getKnight(){
        game = new Game();

        return game.getBoard().getSquare(0,0).getPiece().getClass().toString();
    }
}
