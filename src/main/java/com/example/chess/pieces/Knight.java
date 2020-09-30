package com.example.chess.pieces;

import com.example.chess.table.Board;
import com.example.chess.table.Square;

public class Knight extends Piece {

    public Knight(boolean white) {
        super(white);
    }

    @Override
    public boolean canMove(Board board, Square start, Square end) {
        int x = Math.abs(start.getX() - end.getX());
        int y = Math.abs(start.getY() - end.getY());
        return x * y == 2;
    }
}
