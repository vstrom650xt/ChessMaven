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
        c=position;
        if (somethingToKill()){
            c = position.down().left();
            check(c);
            c = position.down().right();
            check(c);

        }else {
        //down
        c = position.up();
        check(c);
        //doble down
        if (position.getNumber()==7){
            c = position.down().down();
        }
        check(c);


        }
        return coordinates;
    }

    public boolean somethingToKill(){
        Board board = getCell().getBoard();
        Coordinate position = getCell().getCoordinate();
        Coordinate c;
        c=position;
        boolean a1 = false;
        boolean a2 = false;

        if (board.getCells(c.down().left())!= null) {
            if (!board.getCells(c.down().left()).isEmpty()) {
                //  c = position.up().left();
                // check(c);
                a1=true;


            }
        }
        if (board.getCells(c.down().right())!= null) {
            if (!board.getCells(c.down().right()).isEmpty()){
                //  c=position.up().right();
                // check(c);
                a2= true;
            }
        }

        if (a1&&a2)
            return true;



        return false;
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
