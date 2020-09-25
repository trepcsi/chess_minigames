package com.example.chess;


import static java.lang.Math.abs;

public class Knight {

    Square currentPosition;

    public Knight(Square s) {
        this.currentPosition = s;
    }

    public Square getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(Square currentPosition) {
        this.currentPosition = currentPosition;
    }

    public boolean isMovePossible(Square newPosition){
        return ((abs(currentPosition.getX()-newPosition.getX())==2 && abs(currentPosition.getY()-newPosition.getY())==1) ||
                (abs(currentPosition.getX()-newPosition.getX())==1 && abs(currentPosition.getY()-newPosition.getY())==2));
    }

}
