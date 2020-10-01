package com.example.chess.table;

import com.example.chess.pieces.Knight;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class Board {
    public Square[][] chessTable;

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
        chessTable[0][0].setPiece(new Knight(true));
    }

    public Square getSquare(int x, int y) {
        return chessTable[x][y];
    }

    public String boardAsJson() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Square> squareList = new ArrayList<>();
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                squareList.add(chessTable[i][j]);
            }
        }
        return objectMapper.writeValueAsString(squareList);
    }
}
