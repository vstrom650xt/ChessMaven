package model.bishop;

import model.*;

public abstract class Bishop extends Piece {
 private Coordinate[] coordinates;

    public Bishop(Type shape, Cell cell) {
        super(shape, cell);
    }

    @Override
    public Coordinate[] getNextMovements() {

        coordinates= new Coordinate[0];
        Coordinate position= getCell().getCoordinate();
        Coordinate c;
        //up-right

        c = position.diagonalUpRight();
        check(c);

        //up-left
        c = position.diagonalUpLeft();
        check(c);

        //down-left

        c = position.diagonalDownLeft();
        check(c);

        //down-right
        c = position.diagonalDownRight();
        check(c);

        return new Coordinate[0];
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
