package model.pawn;

import model.*;

import java.util.HashSet;
import java.util.Set;

public abstract class Pawn extends Piece {
 private Set<Coordinate> coordinates= new HashSet<>();

    public Pawn(Type shape, Cell cell) {
        super(shape, cell);
    }



}
