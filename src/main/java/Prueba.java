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

        Board b = new Board();
//
  //      System.out.println(b);
        b.placePiece();
        Coordinate[] coordinates = b.getCells(new Coordinate('A',6)).getPiece().getNextMovements();

        b.highlight(coordinates);
        System.out.println(b);
//

    }
}