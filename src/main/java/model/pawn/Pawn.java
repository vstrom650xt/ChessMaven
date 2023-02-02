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
        return coordinates;
    }


}
