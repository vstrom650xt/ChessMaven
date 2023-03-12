package model.king;

import model.*;

import java.util.HashSet;
import java.util.Set;

/**
 * king
 */
public abstract class King extends Piece {

    private Set<Coordinate> coordinates = new HashSet<>();

    public King(Type shape, Cell cell) {
        super(shape, cell);
    }

    /**
     * @return  possible movements
     */
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


}
