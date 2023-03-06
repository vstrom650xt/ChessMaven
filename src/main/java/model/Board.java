package model;

import model.bishop.BishopBlack;
import model.king.KingBlack;
import model.knight.KnightBlack;
import model.pawn.PawnBlack;
import model.pawn.PawnWhite;
import model.queen.QueenBlack;
import model.rook.RookBlack;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Board {

    private Map<Coordinate, Cell> board;




    public Board() {
        board = new HashMap<>();
        inicializarTablero();
        placePiece();
    }

    public void inicializarTablero() {

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board.put(new Coordinate((char) ('A' + j), i + 1), new Cell(this, new Coordinate((char) ('A' + j), i + 1)));
            }

        }
    }

    public Map<Coordinate, Cell> getBoard() {
        return board;
    }

    public Cell getCells(Coordinate coordinate) {
        return board.get(coordinate);
    }

    public void placePiece() {
        Piece p;
        char a = 'A';
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (j == 7) {
                    p = new PawnBlack(getCells(new Coordinate(a, 7)));
                    p.putInYourPlace();
                    a++;
                }

            }

        }

        p = new RookBlack(getCells(new Coordinate('A', 8)));

        p.putInYourPlace();
        p = new KnightBlack(getCells(new Coordinate('B', 8)));
        p.putInYourPlace();
        p = new BishopBlack(getCells(new Coordinate('C', 8)));
        p.putInYourPlace();
        p = new KingBlack(getCells(new Coordinate('D', 8)));
        p.putInYourPlace();
        p = new QueenBlack(getCells(new Coordinate('E', 8)));
        p.putInYourPlace();
        p = new BishopBlack(getCells(new Coordinate('F', 8)));
        p.putInYourPlace();
        p = new KnightBlack(getCells(new Coordinate('G', 8)));
        p.putInYourPlace();
        p = new RookBlack(getCells(new Coordinate('H', 8)));
        p.putInYourPlace();


        p = new PawnWhite(getCells(new Coordinate('D', 2)));
        p.putInYourPlace();
    }

    public void highlight(Set<Coordinate> coordinates) {

        for (Coordinate c : coordinates) {
            getCells(c).highlight();

        }


    }


    public void resetColor() {
        for (Cell c : board.values()) {
            c.resetColor();
        }
    }


    @Override
    public String toString() {
        String output = "   A  B  C  D  E  F  G  H\n";
        for (int i = 0; i < 8; i++) {
            output += (i + 1) + " ";
            for (int j = 0; j < 8; j++) {
                output += board.get(new Coordinate((char) ('A' + j), 1 + i));
            }
            output += " " + (i + 1) + "\n";
        }

        output += "   A  B  C  D  E  F  G  H";
        return output;
    }


}