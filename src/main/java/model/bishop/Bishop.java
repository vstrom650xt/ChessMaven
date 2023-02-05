package model.bishop;

import model.*;

public abstract class Bishop extends Piece {
 //private ListCoor coordinates;

    public Bishop(Type shape, Cell cell) {
        super(shape, cell);
    }

    @Override
    public ListCoor getNextMovements(){

        return  Bishop.getNextMovementsAsBishop(this);
    }
    public static ListCoor getNextMovementsAsBishop(Piece p) {

        ListCoor coordinates= new ListCoor();
        Cell cell = p.getCell();
        Board board= cell.getBoard();
        Piece.Color color = p.getShape().getColor();
        Coordinate position= cell.getCoordinate();
        Coordinate c;


        //up-right
        c = position.diagonalUpRight();
        while(board.getCells(c)!= null && board.getCells(c).isEmpty()){
            coordinates.add(c);
            c = c.diagonalUpRight();

        }
        if (board.getCells(c) != null && board.getCells(c).getPiece().getColor()!= color){
            coordinates.add(c);
        }



        //up-left
        c = position.diagonalUpLeft();
        while(board.getCells(c)!= null && board.getCells(c).isEmpty()){
            coordinates.add(c);
            c = c.diagonalUpLeft();

        }
        if (board.getCells(c) != null && board.getCells(c).getPiece().getColor()!= color){
            coordinates.add(c);
        }



        //down-left

        c = position.diagonalDownLeft();
        while(board.getCells(c)!= null && board.getCells(c).isEmpty()){
            coordinates.add(c);
            c = c.diagonalDownLeft();

        }
        if (board.getCells(c) != null && board.getCells(c).getPiece().getColor()!= color){
            coordinates.add(c);
        }


        //down-right


        c = position.diagonalDownRight();
        while(board.getCells(c)!= null && board.getCells(c).isEmpty()){
            coordinates.add(c);
            c = c.diagonalDownRight();

        }
        if (board.getCells(c) != null && board.getCells(c).getPiece().getColor()!= color){
            coordinates.add(c);
        }


        return coordinates;
    }
    public void  check(Coordinate c, ListCoor coordinates){
        Board board = getCell().getBoard();
        if (board.getCells(c)!= null){
            if (board.getCells(c).isEmpty() ||
                    board.getCells(c).getPiece().getShape().getColor() != getShape().getColor()){
                coordinates.add(c);

            }



        }


    }

}
