package model.pawn;

import model.Board;
import model.Cell;
import model.Coordinate;
import model.Tools;

public class PawnWhite extends Pawn {
    public PawnWhite(Cell cell){
        super(Type.WHITE_PAWN,cell);
    }
    private Coordinate[] coordinates;

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
