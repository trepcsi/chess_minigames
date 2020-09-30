package com.example.chess.table;

import com.example.chess.pieces.Knight;

public class Board {
    public Square[][] chessTable;

    public Board() {
        chessTable = new Square[8][8];
    }

    public void resetBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i == 0 && j == 0) {
                    chessTable[i][j] = new Square(i, j, null);
                }
                chessTable[i][j] = new Square(i, j, new Knight(false));
            }
        }
    }

    public Square getSquare(int x, int y) {
        return chessTable[x][y];
    }
}
