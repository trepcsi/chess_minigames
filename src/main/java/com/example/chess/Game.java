package com.example.chess;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Game {

    @Autowired
    ChessTable board;

    public Game(ChessTable board){
        this.board = board;
    }

    public String printBoard() {
        return board.print();
    }

    public void move(Square s) {
        board.moveKnight(s);
    }
}
