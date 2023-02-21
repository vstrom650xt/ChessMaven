import model.*;

import model.Board;
import model.Cell;
import model.Coordinate;
import model.Piece;

public class Prueba {
    public static void main(String[] args) {

        Board board = new Board();
        board.placePiece();
        ListCoor p ;
      //  p=board.getCells(new Coordinate('D',5)).getPiece().getNextMovements();
        board.highlight(p);
        System.out.println(board);
//

    }
}