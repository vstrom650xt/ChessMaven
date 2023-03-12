package model.queen;

import model.*;
import model.bishop.Bishop;
import model.rook.Rook;

import java.util.HashSet;
import java.util.Set;

/**
 * Queen
 */
public abstract class Queen extends Piece {

    public Queen(Type shape, Cell cell) {
        super(shape, cell);
    }

    /**
     * @return possible movements
     */
    @Override
    public Set<Coordinate> getNextMovements() {
        Set<Coordinate> pieceList = new HashSet<>();
        pieceList.addAll(Bishop.getNextMovementsAsBishop(this));
        pieceList.addAll(Rook.getNextMovementsAsRook(this));
        return pieceList;
    }


}
