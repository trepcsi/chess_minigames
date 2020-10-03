package com.example.chess;

import com.example.chess.table.Square;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Move {
    private Square start;
    private Square end;

    public Move() {
    }

    public Move(Square start, Square end) {
        this.start = start;
        this.end = end;
    }

    public Square getStart() {
        return start;
    }

    public Square getEnd() {
        return end;
    }
}