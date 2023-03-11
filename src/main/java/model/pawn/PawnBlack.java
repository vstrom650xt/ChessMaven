package model.pawn;

import model.*;

import java.util.HashSet;
import java.util.Set;

public class PawnBlack extends Pawn {
    private Set<Coordinate> coordinates = new HashSet<>();

    public PawnBlack(Cell cell) {
        super(Type.BLACK_PAWN,cell);

    }

    protected void checkPawnKiller(Coordinate c) {
        Board board = getCell().getBoard();
        if ((board.getCells(c) != null) && (!board.getCells(c).isEmpty())  && (board.getCells(c).getPiece().getColor() != getColor()) )
            coordinates.add(c);
    }
    public Set<Coordinate> getNextMovements(){
        Board board = getCell().getBoard();
        Coordinate position = getCell().getCoordinate();
        Coordinate c;
        c=position;
        if (somethingToKill()){
              c = position.up().left();
             check(c);
              c = position.up().right();
              check(c);

        }else if (someWAllLeft()){
            c = position.up().left();
            check(c);



        } else if (someWAllRight()) {
            c = position.up().right();
            check(c);

        } else {
            //up
            c = position.up();
            check(c);

            //doble up
            if (position.getNumber()==7){
                c = position.up().up();
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

        if (board.getCells(c.up().left())!= null) {
            if (!board.getCells(c.up().left()).isEmpty()) {
                a1=true;
            }
        }
        if (board.getCells(c.up().right())!= null) {
            if (!board.getCells(c.up().right()).isEmpty()){
                a2= true;
            }
        }

        if (a1&&a2)
            return true;


        return false;
    }
    public boolean someWAllRight(){
        Board board = getCell().getBoard();
        Coordinate position = getCell().getCoordinate();
        Coordinate c;
        c=position;
        boolean a1 = false;

        if (board.getCells(c.up().right())!= null) {
            a1= true;
        }

        if (a1)
            return true;


        return false;
    }
    public boolean someWAllLeft(){
        Board board = getCell().getBoard();
        Coordinate position = getCell().getCoordinate();
        Coordinate c;
        c=position;
        boolean a1 = false;

        if (board.getCells(c.up().left())!= null) {
                a1=true;
        }

        if (a1)
            return true;



        return false;
    }
    public void  check(Coordinate c){
        Board board = getCell().getBoard();
        if (board.getCells(c)!= null){
            if (board.getCells(c).isEmpty() ||
                    board.getCells(c).getPiece().getShape().getColor() != getShape().getColor()){
                coordinates.add(c);
            }


        }


    }


}
