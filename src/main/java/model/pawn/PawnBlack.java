package model.pawn;

import model.*;
import model.queen.QueenBlack;

import java.util.HashSet;
import java.util.Set;

public class PawnBlack extends Pawn {
   // private Set<Coordinate> coordinates = new HashSet<>();////////

    public PawnBlack(Cell cell) {
        super(Type.BLACK_PAWN,cell);

    }


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
        //getCell().getBoard().getDeletedPieceManager().addPiece(p);
        cell = null;
    }



}
