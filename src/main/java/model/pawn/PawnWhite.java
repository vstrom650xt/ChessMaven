package model.pawn;

import model.*;

import java.util.List;
import java.util.Set;

public class PawnWhite extends Pawn {
    private Set<Coordinate> coordinates;
    public PawnWhite(Cell cell){
        super(Type.WHITE_PAWN,cell);
    }

    public Set<Coordinate> getNextMovements(){
        Board board = getCell().getBoard();
        Coordinate position = getCell().getCoordinate();
        Coordinate c;
        //down
        c = position.down();
        check(c);
        //doble down
        if (position.getNumber()==7){
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
