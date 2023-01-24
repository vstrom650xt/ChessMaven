package model;

public abstract class Knight extends Piece{


    public Knight(Type shape, Cell cell) {
        super(shape, cell);
    }

    @Override
    public Coordinate[] getNextMovements() {
        return new Coordinate[0];
    }
}
