package model.pawn;

import model.*;
import model.queen.QueenBlack;

import java.util.List;
import java.util.Set;

public class PawnWhite extends Pawn {
    public PawnWhite(Cell cell) {
        super(Type.WHITE_PAWN, cell);
    }
    @Override
    public Set<Coordinate> getNextMovements() {
        Coordinate position = getCell().getCoordinate(), c;

        //UP
        c = position.up();
        checkPawnMove(c);
        if (getCell().getCoordinate().getNumber() == 7) {
            c = position.up().up();
            checkPawnMove(c);
        }
        c = position.diagonalUpLeft();
        checkPawnKiller(c);
        c = position.diagonalUpRight();
        checkPawnKiller(c);

        return coordinates;
    }

    @Override
    public void transform() {
        Piece p = getCell().getPiece();
        new QueenBlack(getCell());
        getCell().getBoard().getDeletedPieceManager().addPiece(p);
        cell = null;
    }
}
