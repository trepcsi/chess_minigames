package com.example.chess;

import com.example.chess.pieces.Piece;
import com.example.chess.table.Board;
import com.example.chess.table.Square;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Game {

    private GameStatus status;

    private Board board;

    private List<Move> movesPlayed;

    public Game() {
        board = new Board();
        movesPlayed = new ArrayList<>();
    }

    public void init() {
        board.resetBoard();
        movesPlayed.clear();
        status = GameStatus.IN_GAME;
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
        move.getStart().setFree(false);
        move.getStart().setPiece(null);

        System.out.println(movesPlayed.size());
        refreshStatus(move.getEnd());
        return true;
    }

    private void refreshStatus(Square fromSquare) {
        if (movesPlayed.size() == 64 - 1) {
            status = GameStatus.WON;
            return;
        }
        if (!hasLegalMove(fromSquare)) {
            status = GameStatus.LOST;
        }
    }

    private boolean hasLegalMove(Square fromSquare) {
        for (int i = 0; i < board.getChessTable().length; i++) {
            for (int j = 0; j < board.getChessTable()[0].length; j++) {
                Square toSquare = board.getSquare(i, j);
                if (toSquare.isFree()) {
                    if (fromSquare.getPiece().canMove(board, fromSquare, toSquare)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public Board getBoard() {
        return board;
    }

    public String getStatus() {
        return status.toString();
    }

    private enum GameStatus {
        IN_GAME,
        LOST,
        WON
    }
}
