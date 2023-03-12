package model.pawn;

import model.*;

import java.util.HashSet;
import java.util.Set;

/**
 * pawb
 */
public abstract class Pawn extends Piece {
    /**
     * @param type of piece.
     * @param cell of board.
     *             <p>
     *             pawn builder.
     */
    public Pawn(Type type, Cell cell) {
        super(type, cell);
    }

    /**
     * @param piece
     * @return a queen
     */
    public abstract Piece transform(Piece piece);

    /**
     * @param c
     * @return if it can move
     */
    @Override
    public boolean moveTo(Coordinate c) {
        boolean move = super.moveTo(c);
        if (move) {
            if (getCell().getCoordinate().getNumber() == 8 ||
                    getCell().getCoordinate().getNumber() == 1)
                transform(getCell().getPiece());
        }
        return move;
    }

    /**
     * check if the pawn can kill.
     * @param c to check the piece.
     */
    protected void checkPawnKiller(Coordinate c) {
        Board board = getCell().getBoard();
        if ((board.getCells(c) != null) && (!board.getCells(c).isEmpty()) && (board.getCells(c).getPiece().getColor() != getColor()))
            coordinates.add(c);


    }

    /**
     * check if the pawn can move.
     * @param c to check the piece.
     */
    protected void checkPawnMove(Coordinate c) {
        Board board = getCell().getBoard();
        if ((board.getCells(c) != null) && (board.getCells(c).isEmpty()))
            coordinates.add(c);
    }
}
