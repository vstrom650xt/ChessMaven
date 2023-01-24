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
        //up
        c = position.up().up().left();
        check(c);
        c = position.up().up().right();
        check(c);
        //down
        c = position.up().up().left();
        check(c);
        c = position.up().up().right();
        check(c);

        //left

        c = position.left().left().up();
        check(c);
        c = position.left().left().down();
        check(c);
        //right
        c = position.right().right().up();
        check(c);
        c = position.right().right().down();
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
