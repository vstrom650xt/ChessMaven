package model.pawn;

import model.*;

import java.util.Set;

public abstract class Pawn extends Piece {
 private Set<Coordinate> coordinates;

    public Pawn(Type shape, Cell cell) {
        super(shape, cell);
    }


}
