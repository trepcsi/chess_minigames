package com.example.chess;

import com.example.chess.exceptions.InvalidMoveException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class KnightController {

    @Autowired
    Game game;

    @RequestMapping(value = "/board", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getBoard() {
        return ResponseEntity.ok(game.printBoard());
    }

    @RequestMapping(value = "/move", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> move(@RequestBody Square targetSquare) {
        try {
            game.move(targetSquare);
        }catch (InvalidMoveException e){
            return ResponseEntity.badRequest().body("Invalid move!");
        }

        return ResponseEntity.ok(game.printBoard());
    }
}
