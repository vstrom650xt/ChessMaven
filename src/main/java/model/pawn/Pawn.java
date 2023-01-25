package model.pawn;

import model.*;

public abstract class Pawn extends Piece {
 private Coordinate[] coordinates;

    public Pawn(Type shape, Cell cell) {
        super(shape, cell);
    }

    @Override
    public Coordinate[] getNextMovements() {

        coordinates= new Coordinate[0];
        Coordinate position= getCell().getCoordinate();
        Coordinate c;

        return coordinates;
    }


}
