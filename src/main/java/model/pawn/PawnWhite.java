package model.pawn;

import model.*;
import model.queen.QueenBlack;
import model.queen.QueenWhite;

import java.util.Set;

public class PawnWhite extends Pawn {
    public PawnWhite(Cell cell) {
        super(Type.WHITE_PAWN, cell);
    }

    @Override
    public Set<Coordinate> getNextMovements() {
        Coordinate position = getCell().getCoordinate(), c;

        //UP
        c = position.down();
        checkPawnMove(c);
        if (getCell().getCoordinate().getNumber() == 2) {
            c = position.down().down();
            checkPawnMove(c);
        }
        c = position.diagonalDownLeft();
        checkPawnKiller(c);
        c = position.diagonalDownRight();
        checkPawnKiller(c);

        return coordinates;
    }

    @Override
    public void transform(Piece piece) {


        piece = new QueenWhite(getCell());
        getCell().getBoard().getCurrentPieceManager().addPiece(piece);
        piece.putInYourPlace();

    }
}
