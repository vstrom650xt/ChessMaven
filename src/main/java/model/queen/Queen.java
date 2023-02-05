package model.queen;

import model.*;
import model.bishop.Bishop;
import model.rook.Rook;

public abstract class Queen extends Piece {
 //private ListCoor coordinates;

    public Queen(Type shape, Cell cell) {
        super(shape, cell);
    }

    @Override
    public ListCoor getNextMovements(){
        ListCoor lc = new ListCoor();
        lc.addAll(Bishop.getNextMovementsAsBishop(this));
        lc.addAll(Rook.getNextMovementsAsRook(this));

        return  lc;
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
