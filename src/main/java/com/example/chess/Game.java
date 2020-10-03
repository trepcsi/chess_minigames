package com.example.chess;

import com.example.chess.pieces.Piece;
import com.example.chess.table.Board;
import com.example.chess.table.Square;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class Game {

    @Autowired
    private Board board;

    private List<Move> movesPlayed;

    public Game() {
        board = new Board();
        movesPlayed = new ArrayList<>();
        init();
    }

    private void init() {
        board.resetBoard();
        movesPlayed.clear();
    }

    public boolean playerMove(int fromX, int fromY, int toX, int toY) {
        Square start = (board.getSquare(fromX, fromY));
        Square end = (board.getSquare(toX, toY));
        Move move = new Move(start, end);
        return this.makeMove(move);
    }

    private boolean makeMove(Move move) {
        Piece sourcePiece = move.getStart().getPiece();

        if (sourcePiece == null) return false;

        if (!move.getEnd().isFree()) return false;

        if (!sourcePiece.canMove(board, move.getStart(), move.getEnd())) {
            return false;
        }

        movesPlayed.add(move);
        move.getEnd().setPiece(sourcePiece);
        move.getEnd().setFree(false);
        move.getStart().setPiece(null);
        return true;
    }

    public Board getBoard() {
        return board;
    }
}
