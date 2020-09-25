package com.example.chess.exceptions;

public class InvalidMoveException extends RuntimeException {

    public InvalidMoveException(String m) {
        super(m);
    }
}
