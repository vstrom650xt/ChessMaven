package model.rook;

import model.*;
import model.bishop.Bishop;

import java.util.HashSet;
import java.util.Set;

public abstract class Rook extends Piece {
 private Set<Coordinate> coordinates=new HashSet<>();

    public Rook(Type shape, Cell cell) {
        super(shape, cell);
    }
    @Override
    public Set<Coordinate> getNextMovements(){
        return  Rook.getNextMovementsAsRook(this);

    }
    public static Set<Coordinate> getNextMovementsAsRook(Piece p) {

        Set<Coordinate> coordinates = new HashSet<>();
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
