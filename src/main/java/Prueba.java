import model.*;

import model.Board;
import model.Cell;
import model.Coordinate;
import model.Piece;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Prueba {
    public static void main(String[] args) {

        Board board = new Board();
        board.placePiece();
        System.out.println(board);

       Set<Coordinate> p ;
        p=board.getCells(new Coordinate('D',7)).getPiece().getNextMovements();
//        board.highlight(p);
//        System.out.println(board);
//

    }
}