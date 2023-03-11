package model.queen;

import model.*;
import model.bishop.Bishop;
import model.rook.Rook;

import java.util.HashSet;
import java.util.Set;

public abstract class Queen extends Piece {
 //private ListCoor coordinates;
    private Set <Coordinate> coordinates=new HashSet<>();

    public Queen(Type shape, Cell cell) {
        super(shape, cell);
    }

    @Override
    public Set<Coordinate> getNextMovements(){
        Set<Coordinate> pieceList = new HashSet<>() ;
        pieceList.addAll(Bishop.getNextMovementsAsBishop(this));
        pieceList.addAll(Rook.getNextMovementsAsRook(this));

        return  pieceList;
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
