import model.Board;
import model.Cell;
import model.Coordinate;
import model.Piece;

import model.Board;
import model.Cell;
import model.Coordinate;
import model.Piece;

public class Prueba {
    public static void main(String[] args) {
        Coordinate c1 = new Coordinate('g',6);

        Coordinate c2 = new Coordinate('d',7);



        Board b = new Board();
        System.out.println(b);
        b.placePiece();
    //    b.highlight();
        System.out.println(b);


    }
}