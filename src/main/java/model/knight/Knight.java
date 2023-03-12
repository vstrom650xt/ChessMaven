package model.knight;

import model.*;

import javax.tools.Tool;
import java.util.HashSet;
import java.util.Set;

/**
 * Knight
 */
public abstract class Knight extends Piece {
    private Set<Coordinate> coordinates = new HashSet<>();

    public Knight(Type shape, Cell cell) {
        super(shape, cell);
    }

    /**
     * @return possible movements
     */
    @Override
    public Set<Coordinate> getNextMovements() {

        Coordinate position = getCell().getCoordinate();
        Coordinate c;
        //up
        c = position.up().up().left();
        check(c, coordinates);
        c = position.up().up().right();
        check(c, coordinates);

        //down
        c = position.down().down().left();
        check(c, coordinates);
        c = position.down().down().right();
        check(c, coordinates);


        //left

        c = position.left().left().up();
        check(c, coordinates);
        c = position.left().left().down();
        check(c, coordinates);

        //right
        c = position.right().right().up();
        check(c, coordinates);
        c = position.right().right().down();
        check(c, coordinates);

        return coordinates;
    }


}
