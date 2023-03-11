import model.*;

import model.Board;
import model.Cell;
import model.Coordinate;
import model.Piece;
import model.pawn.Pawn;
import model.pawn.PawnBlack;
import model.rook.RookBlack;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Prueba {
    public static void main(String[] args) {

        Board board = new Board();
        board.placePiece();
        System.out.println(board);

       Set<Coordinate> coordinateSet ;
        coordinateSet=board.getCells(new Coordinate('E',7)).getPiece().getNextMovements();
        board.highlight(coordinateSet);




//        System.out.println(board);
//

    }
}