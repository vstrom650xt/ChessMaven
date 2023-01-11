package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoordinateTest {

    @Test
    @DisplayName("new coordinate up direcction")
    void up() {

        Coordinate c1 = new Coordinate('c',2);
        Coordinate c2 = new Coordinate( 'c',3).up();
        assertEquals(c1,c2);


    }

    @Test
    void down() {

        Coordinate c1 = new Coordinate('c',3);
        Coordinate c2 = new Coordinate( 'c',2).down();
        assertEquals(c1,c2);
    }

    @Test
    void right() {

        Coordinate c1 = new Coordinate('a',3);
        Coordinate c2 = new Coordinate( 'b',3).right();
        assertEquals(c1,c2);
    }

    @Test
    void left() {
    }

    @Test
    void diagonalUpLeft() {
    }

    @Test
    void diagonalUpRight() {
    }

    @Test
    void diagonalDownLeft() {
    }

    @Test
    void diagonalDownRight() {
    }
}