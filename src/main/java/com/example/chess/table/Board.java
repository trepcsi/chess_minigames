package com.example.chess.table;

import com.example.chess.pieces.Knight;

public class Board {

    private final int START_X = 0;
    private final int START_Y = 0;

    private Square[][] chessTable;


    public Board() {
        chessTable = new Square[8][8];
    }

    public void resetBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                chessTable[i][j] = new Square(i, j);
                chessTable[i][j].setPiece(null);
            }
        }
        chessTable[START_X][START_Y].setPiece(new Knight(true));
    }

    public Square getSquare(int x, int y) {
        return chessTable[x][y];
    }

    public Square[][] getChessTable() {
        return chessTable;
    }

    public int numberOfMissing() {
        int result = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessTable[i][j].isFree()) {
                    result++;
                }
            }
        }
        return result;
    }
}
