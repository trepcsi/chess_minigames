package com.example.chess;

import com.example.chess.exceptions.InvalidMoveException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ChessTable {

    Cell[][] board = new Cell[8][8];

    @Autowired
    Knight knight;

    public ChessTable() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = Cell.FREE;
            }
        }
        board[0][0] = Cell.CURRENT;
    }

    public void moveKnight(Square newPos) {
        if (board[newPos.getX()][newPos.getY()] == Cell.USED || !knight.isMovePossible(newPos)) {
            throw new InvalidMoveException("Bad Move");
        }
        board[knight.currentPosition.getX()][knight.currentPosition.getY()] = Cell.USED;
        knight.currentPosition.setX(newPos.getX());
        knight.currentPosition.setY(newPos.getY());
        board[newPos.getX()][newPos.getY()] = Cell.CURRENT;
    }

    public String print() {
        String result = "{\"board\":{";
        for (int i = 0; i < 8; i++) {
            result += "\"" + i + "\":[" + getRow(i) + "]";
            if (i < 7) result += ",";
        }
        result += "}}";
        return result;
    }

    public String getRow(int n) {
        String result = "{";
        for (int i = 0; i < board[n].length; i++) {
            result += "\"" + i + "\":\"" + board[n][i] + "\"";
            if (i < 7) result += ",";
        }
        return result + "}";
    }

    public enum Cell {
        FREE,
        USED,
        CURRENT
    }
}
