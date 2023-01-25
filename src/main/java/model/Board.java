package model;

import model.bishop.BishopBlack;
import model.knight.KnightBlack;
import model.knight.KnightWhite;
import model.pawn.PawnBlack;
import model.pawn.PawnWhite;
import model.queen.QueenBlack;
import model.rook.RookBlack;

public class Board {

    private Cell[][] cells;

    public Board(){
        cells = new Cell[8][8];
        //to create every cell
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                cells[i][j] = new Cell(this, new Coordinate((char)('A'+j),i+1));
            }
        }
    }

    //revisar el getNum
    public Cell getCells(Coordinate coordinate) {
        if (coordinate.getNumber()<1 || coordinate.getNumber()>8)
            return null;
        if (coordinate.getLetter()<'A' || coordinate.getLetter()>'H')
            return  null;
        return cells[coordinate.getNumber()-1][coordinate.getLetter()-'A'];
    }

    public  void placePiece(){
        Piece p ;
        char a = 'A';
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                   if (j==7 ){
                       p= new PawnBlack(getCells(new Coordinate(a,7)));
                       p.putInYourPlace();
                       a++;
                   }

            }

        }
        p=new PawnBlack(getCells(new Coordinate('A',6)));
        p.putInYourPlace();
        p=new RookBlack(getCells(new Coordinate('A',8)));
        p.putInYourPlace();
        p=new KnightBlack(getCells(new Coordinate('B',8)));
        p.putInYourPlace();
        p=new BishopBlack(getCells(new Coordinate('C',8)));
        p.putInYourPlace();
        p=new KnightBlack(getCells(new Coordinate('D',8)));
        p.putInYourPlace();
        p=new QueenBlack(getCells(new Coordinate('E',8)));
        p.putInYourPlace();
        p=new BishopBlack(getCells(new Coordinate('F',8)));
        p.putInYourPlace();
        p=new KnightBlack(getCells(new Coordinate('G',8)));
        p.putInYourPlace();
        p=new RookBlack(getCells(new Coordinate('H',8)));
        p.putInYourPlace();

        p=new PawnWhite(getCells(new Coordinate('B',5)));
        p.putInYourPlace();
    }

    public  void highlight(Coordinate... coordinates){
        for (Coordinate c : coordinates){
            getCells(c).highlight();
        }
    }

    public  void resetColor(){
        for (Cell[] c : cells){
            for (Cell c2 : c ){
                c2.resetColor();

            }
        }
    }
        @Override
    public String toString() {
        String output = "   A  B  C  D  E  F  G  H\n";
        for (int i = 0; i < 8; i++) {
            output += (i+1) + " ";
            for (int j = 0; j < 8; j++) {
                output += cells[i][j];
            }
            output += " " + (i+1) + "\n";
        }

        output += "   A  B  C  D  E  F  G  H";
        return output;
    }
}