package com.example.chess.pieces;

import com.example.chess.table.Board;
import com.example.chess.table.Square;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


@JsonTypeInfo(include= JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
public abstract class Piece {

    private boolean killed = false;
    private boolean white = false;

    public Piece(boolean white) {
        this.white = white;
    }

    public boolean isKilled() {
        return killed;
    }

    public boolean isWhite() {
        return white;
    }

    public void setKilled(boolean killed) {
        this.killed = killed;
    }

    public void setWhite(boolean white) {
        this.white = white;
    }

    public abstract boolean canMove(Board board, Square start, Square end);
}
