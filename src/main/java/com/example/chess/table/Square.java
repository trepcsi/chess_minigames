package com.example.chess.table;

import com.example.chess.pieces.Piece;

public class Square {
    private int x;
    private int y;

    private Piece piece;

    private boolean taken = false;

    public boolean getTaken(){
        return taken;
    }

    public void setTaken(boolean taken){
        this.taken = taken;
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
