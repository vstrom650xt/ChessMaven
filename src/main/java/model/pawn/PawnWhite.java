package model.pawn;

import model.*;

import java.util.List;

public class PawnWhite extends Pawn {
    private ListCoor coordinates;
    public PawnWhite(Cell cell){
        super(Type.WHITE_PAWN,cell);
    }

    public ListCoor getNextMovements(){
        Board board = getCell().getBoard();

        coordinates = new ListCoor();
        Coordinate position = getCell().getCoordinate();
        Coordinate c;
        //down
        c = position.down();
        check(c);
        //doble down
        if (position.number()==7){
            c = position.down().down();
        }
        check(c);

        //kill
        c=position;
        if (board.getCells(c.down().left())!= null) {
            if (!board.getCells(c.down().left()).isEmpty()) {
                c = position.down().left();
                check(c);
            }
        }
        if (board.getCells(c.down().right())!= null) {
            if (!board.getCells(c.down().right()).isEmpty()){
                c=position.down().right();
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
                //       coordinates= Tools.add(coordinates,c);
                coordinates.add(c);
            }


        }


    }
}
