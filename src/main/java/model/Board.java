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


    private Map<Coordinate, Cell> boardWl;


    public Board() {
        boardWl = new HashMap<>();
        inicializarTablero();
    }

    public void inicializarTablero() {

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                boardWl.put(new Coordinate((char) ('A' + j), i + 1), new Cell(this, new Coordinate((char) ('A' + j), i + 1)));
            }

        }
    }


    public Cell getCells(Coordinate coordinate) {
        return boardWl.get(coordinate);
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

        p = new PawnWhite(getCells(new Coordinate('D', 3)));
        p.putInYourPlace();
    }

    public void highlight(Set<Coordinate> coordinates) {

        for (Coordinate c : coordinates) {
            getCells(c).highlight();

        }


    }


    public void resetColor() {
        for (Cell c : boardWl.values()) {
            c.resetColor();
        }
    }


//    public Board(){
////        cells = new Cell[8][8];
////        //to create every cell
////        for (int i = 0; i < 8; i++) {
////            for (int j = 0; j < 8; j++) {
////                cells[i][j] = new Cell(this, new Coordinate((char)('A'+j),i+1));
////            }
////        }
//    }

    //revisar el getNum
//    public Cell getCells(Coordinate coordinate) {
//        if (coordinate.number()<1 || coordinate.number()>8)
//            return null;
//        if (coordinate.letter()<'A' || coordinate.letter()>'H')
//            return  null;
//        return cells[coordinate.number()-1][coordinate.letter()-'A'];
//    }

//    public  void placePiece(){
//        Piece p ;
//        char a = 'A';
//        for (int i = 0; i < cells.length; i++) {
//            for (int j = 0; j < cells[i].length; j++) {
//                   if (j==7 ){
//                       p= new PawnBlack(getCells(new Coordinate(a,7)));
//                       p.putInYourPlace();
//                       a++;
//                   }
//
//            }
//
//        }
//
//        p=new RookBlack(getCells(new Coordinate('A',8)));
//        p.putInYourPlace();
//        p=new KnightBlack(getCells(new Coordinate('B',8)));
//        p.putInYourPlace();
//        p=new BishopBlack(getCells(new Coordinate('C',8)));
//        p.putInYourPlace();
//        p=new KingBlack(getCells(new Coordinate('D',5)));
//        p.putInYourPlace();
//        p=new QueenBlack(getCells(new Coordinate('E',8)));
//        p.putInYourPlace();
//        p=new BishopBlack(getCells(new Coordinate('F',8)));
//        p.putInYourPlace();
//        p=new KnightBlack(getCells(new Coordinate('G',8)));
//        p.putInYourPlace();
//        p=new RookBlack(getCells(new Coordinate('H',8)));
//        p.putInYourPlace();
//
//        p=new PawnWhite(getCells(new Coordinate('D',3)));
//        p.putInYourPlace();
//    }

//    public  void highlight(ListCoor coordinates){
//        for (int i = 0; i <coordinates.size(); i++) {
//            getCells(coordinates.get(i)).highlight();
//
//        }
//
//    }

    //    public  void resetColor(){
//        for (Cell[] c : boardWl.keySet()){
//            for (Cell c2 : c ){
//                c2.resetColor();
//
//            }
//        }
//    }
    @Override
    public String toString() {
        String output = "   A  B  C  D  E  F  G  H\n";
        for (int i = 0; i < 8; i++) {
            output += (i + 1) + " ";
            for (int j = 0; j < 8; j++) {
                output += boardWl.get(new Coordinate((char) ('A' + j), 1 + i));
            }
            output += " " + (i + 1) + "\n";
        }

        output += "   A  B  C  D  E  F  G  H";
        return output;
    }


}