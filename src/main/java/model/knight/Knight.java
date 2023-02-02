package model.knight;

import model.*;

import javax.tools.Tool;

public abstract class Knight extends Piece {
 private ListCoor coordinates;

    public Knight(Type shape, Cell cell) {
        super(shape, cell);
    }

    @Override
    public ListCoor getNextMovements() {

        coordinates= new ListCoor();
        Coordinate position= getCell().getCoordinate();
        Coordinate c;
        //up
        c = position.up().up().left();
        check(c,coordinates);
        c = position.up().up().right();
        check(c,coordinates);

        //down
        c = position.up().up().left();
        check(c,coordinates);

        c = position.up().up().right();
        check(c,coordinates);


        //left

        c = position.left().left().up();
        check(c,coordinates);

        c = position.left().left().down();
        check(c,coordinates);

        //right
        c = position.right().right().up();
        check(c,coordinates);

        c = position.right().right().down();
        check(c,coordinates);

        return coordinates;
    }


}
