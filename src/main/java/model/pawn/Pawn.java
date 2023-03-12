package model.pawn;

import model.*;

import java.util.HashSet;
import java.util.Set;

public abstract class Pawn extends Piece {
    /**
     * @param type of piece.
     * @param cell of board.
     *
     *  pawn builder.
     */
    public Pawn(Type type, Cell cell) {
        super(type, cell);
    }

    public abstract void transform();

    @Override
    public boolean moveTo(Coordinate c) {
        boolean move = super.moveTo(c);
        if (move) {
            if (getCell().getCoordinate().getNumber() == 8 ||
                    getCell().getCoordinate().getNumber() == 1)
                transform();
        }
        return move;
    }

    /**
     * @param c to check the piece.
     * check if the pawn can kill.
     */
    protected void checkPawnKiller(Coordinate c) {
        Board board = getCell().getBoard();
        if ((board.getCells(c) != null) && (!board.getCells(c).isEmpty())  && (board.getCells(c).getPiece().getColor() != getColor()) )
            coordinates.add(c);


    }
    /**
     * @param c to check the piece.
     * check if the pawn can move.
     */
    protected void checkPawnMove(Coordinate c) {
        Board board = getCell().getBoard();
        if ((board.getCells(c) != null) && (board.getCells(c).isEmpty()))
            coordinates.add(c);
    }
}
