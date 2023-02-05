package model.rook;

import model.*;
import model.bishop.Bishop;

public abstract class Rook extends Piece {
 private ListCoor coordinates;

    public Rook(Type shape, Cell cell) {
        super(shape, cell);
    }
    @Override

    public ListCoor getNextMovements(){
        return  Rook.getNextMovementsAsRook(this);

    }
    public static ListCoor getNextMovementsAsRook(Piece p) {

        ListCoor coordinates= new ListCoor();
        Cell cell = p.getCell();
        Board board= cell.getBoard();
        Piece.Color color = p.getShape().getColor();
        Coordinate position= cell.getCoordinate();
        Coordinate c;


        //up
        c = position.up();
        while(board.getCells(c)!= null && board.getCells(c).isEmpty()){
            coordinates.add(c);
            c = c.up();

        }
        if (board.getCells(c) != null && board.getCells(c).getPiece().getColor()!= color){
            coordinates.add(c);
        }
        //down
        c = position.down();
        while(board.getCells(c)!= null && board.getCells(c).isEmpty()){
            coordinates.add(c);
            c = c.down();

        }
        if (board.getCells(c) != null && board.getCells(c).getPiece().getColor()!= color){
            coordinates.add(c);
        }

        //left
        c = position.left();
        while(board.getCells(c)!= null && board.getCells(c).isEmpty()){
            coordinates.add(c);
            c = c.left();

        }
        if (board.getCells(c) != null && board.getCells(c).getPiece().getColor()!= color){
            coordinates.add(c);
        }

        //right
        c = position.right();
        while(board.getCells(c)!= null && board.getCells(c).isEmpty()){
            coordinates.add(c);
            c = c.right();

        }
        if (board.getCells(c) != null && board.getCells(c).getPiece().getColor()!= color){
            coordinates.add(c);
        }



        return coordinates;
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
