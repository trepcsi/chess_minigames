package com.example.chess.solve;

import com.example.chess.pieces.Knight;
import com.example.chess.pieces.Piece;
import com.example.chess.table.Board;
import com.example.chess.table.Square;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BoardGraph {

    private final int sumV;
    private final int missingV;
    private final int[] path;
    private final int[][] graph = new int[64][64];
    private int pathCount;

    List<Square> moves = new ArrayList<>();

    public BoardGraph(Board board) {
        missingV = board.numberOfMissing();
        path = new int[missingV];
        Arrays.fill(path, -1);
        sumV = 64;
        for (int i = 0; i < 64; i++) {

            int fromX = i % 8;
            int fromY = i / 8;
            if (board.getSquare(fromX, fromY).getPiece() != null) {
                path[0] = i;
            }

            for (int j = 0; j < 64; j++) {
                int toX = j % 8;
                int toY = j / 8;
                Piece knight = new Knight(false);
                if (board.getSquare(toX, toY).isFree()) {
                    if (knight.canMove(board, board.getSquare(fromX, fromY), board.getSquare(toX, toY))) {
                        graph[i][j] = 1;
                    }
                } else {
                    graph[i][j] = 0;
                }
            }
        }
    }

    public boolean findHamiltonianPath() throws Exception {
        pathCount = 1;
        return solve(path[0]);

    }

    public boolean solve(int vertex) throws Exception {
        //done
        if (pathCount == missingV) {
            return true;
        }

        for (int v = 0; v < sumV; v++) {
            //can jump
            if (graph[vertex][v] == 1) {
                //add to path
                path[pathCount++] = v;
                graph[vertex][v] = 0;
                graph[v][vertex] = 0;

                //if OK solve recursively
                if (!isPresent(v)) {
                    if (solve(v)) {
                        return true;
                    }
                }

                //if NOK remove from path
                graph[vertex][v] = 1;
                graph[v][vertex] = 1;
                path[--pathCount] = -1;
            }
        }
        //no solution
        return false;
    }

    public List<Square> getMoves() {
        for (int value : path) {
            Square from = new Square(value % 8, value / 8);
            moves.add(from);
        }
        return moves;
    }

    public boolean isPresent(int v) {
        for (int i = 0; i < pathCount - 1; i++)
            if (path[i] == v) {
                return true;
            }
        return false;
    }

}

