package com.example.chess.table;

import com.example.chess.pieces.Piece;

public class Square {
    private int x;
    private int y;

    private Piece piece;

    private boolean free = true;

    public boolean isFree(){
        return free;
    }

    public void setFree(boolean free){
        this.free = free;
    }

    public Square() {
    }

    public Square(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

}
