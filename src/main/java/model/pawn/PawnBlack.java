package model.pawn;

import model.*;
import model.queen.QueenBlack;

import java.util.Set;

public class PawnBlack extends Pawn {
    public PawnBlack(Cell cell) {
        super(Type.BLACK_PAWN, cell);
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
    public void transform(Piece piece) {

        piece = new QueenBlack(getCell());
        getCell().getBoard().getCurrentPieceManager().addPiece(piece);
        piece.putInYourPlace();

    }


}
