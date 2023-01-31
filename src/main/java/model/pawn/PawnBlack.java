package model.pawn;

import model.Board;
import model.Cell;
import model.Coordinate;
import model.Tools;

public class PawnBlack extends Pawn {
    private Coordinate[] coordinates;

    public PawnBlack(Cell cell) {
        super(Type.BLACK_PAWN,cell);

    }

    public Coordinate[] getNextMovements(){
        Board board = getCell().getBoard();

        coordinates = new Coordinate[0];
        Coordinate position = getCell().getCoordinate();
        Coordinate c;
        //up
        c = position.up();
        check(c);
        //doble up
        if (position.number()==7){
            c = position.up().up();
        }
        check(c);

        //kill
        c=position;
        if (board.getCells(c.up().left())!= null) {
            if (!board.getCells(c.up().left()).isEmpty()) {
                c = position.up().left();
                check(c);
            }
        }
        if (board.getCells(c.up().right())!= null) {
            if (!board.getCells(c.up().right()).isEmpty()){
                c=position.up().right();
                check(c);
            }

        }
        return coordinates;
    }
    public void  check(Coordinate c){
        Board board = getCell().getBoard();
        if (board.getCells(c)!= null){
            if (board.getCells(c).isEmpty() ||
                    board.getCells(c).getPiece().getShape().getColor() != getShape().getColor()){
                coordinates= Tools.add(coordinates,c);
            }


        }


    }
}
