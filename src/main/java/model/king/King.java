package model.king;

import model.*;

import java.util.Set;

public abstract class King extends Piece {

    private Set<Coordinate> coordinates;

    public King(Type shape, Cell cell) {
        super(shape, cell);
    }

    @Override
    public Set<Coordinate> getNextMovements() {
        Coordinate position = getCell().getCoordinate();
        Coordinate c;
        //up
        c = position.up();
        check(c, coordinates);
        //down
        c = position.down();
        check(c, coordinates);
        //left
        c = position.left();
        check(c, coordinates);
        //right
        c = position.right();
        check(c, coordinates);

        //up-right
        c = position.diagonalUpRight();
        check(c, coordinates);

        //up-left
        c = position.diagonalUpLeft();
        check(c, coordinates);
        //down-right
        c = position.diagonalDownRight();
        check(c, coordinates);
        //down-left
        c = position.diagonalDownLeft();
        check(c, coordinates);

        return coordinates;
    }

    public Set<Coordinate> check(Coordinate c) {
        Board board = getCell().getBoard();
        if (board.getCells(c) != null) {
            if (board.getCells(c).isEmpty() ||
                    board.getCells(c).getPiece().getShape().getColor() != getShape().getColor()) {
                coordinates.add(c);

            }


        }

        return coordinates;
    }
}
