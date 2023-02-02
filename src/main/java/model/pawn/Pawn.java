package model.pawn;

import model.*;

public abstract class Pawn extends Piece {
 private ListCoor coordinates;

    public Pawn(Type shape, Cell cell) {
        super(shape, cell);
    }

    @Override
    public ListCoor getNextMovements() {

        coordinates= new ListCoor();
        Coordinate position= getCell().getCoordinate();
        Coordinate c;

        return coordinates;
    }


}
