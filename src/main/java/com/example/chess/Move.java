package com.example.chess;

import com.example.chess.pieces.Piece;
import com.example.chess.table.Square;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Move {
    private Square start;
    private Square end;
    private Piece pieceMoved;
    private Piece pieceKilled;
    private boolean castlingMove = false;

    public Move(){}

    public Move(Square start, Square end)
    {
        this.start = start;
        this.end = end;
        this.pieceMoved = start.getPiece();
    }

    public boolean isCastlingMove()
    {
        return this.castlingMove;
    }

    public void setCastlingMove(boolean castlingMove)
    {
        this.castlingMove = castlingMove;
    }

    public Square getStart() {
        return start;
    }

    public Square getEnd() {
        return end;
    }
}