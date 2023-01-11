import model.Board;
import model.Cell;
import model.Coordinate;
import model.Piece;

public class Prueba {
    public static void main(String[] args) {
        Coordinate c1 = new Coordinate('g',6);

        Piece cb= new Piece(Piece.Type.BLACK_KNIGHT,new Cell(new Board(),c1));
        Piece cb2= new Piece(Piece.Type.WHITE_KNIGHT,new Cell(new Board(),c1));

        System.out.println(cb);
        System.out.println(cb2);


    }
}
