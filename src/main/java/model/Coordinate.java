package model;

public class Coordinate {
    private char letter;
    private int number;

    public Coordinate(char letter, int number) {
        this.letter = Character.toUpperCase(letter);
        this.number = number;
    }

    public Coordinate up() {
        return new Coordinate(letter, number - 1);


    }

    public Coordinate down() {
        return new Coordinate(letter, number + 1);


    }

    public Coordinate right() {
        return new Coordinate((char) (letter + 1), number);


    }

    public Coordinate left() {
        return new Coordinate((char) (letter - 1), number);


    }

    public Coordinate diagonalUpLeft() {

        return up().left();

    }

    public Coordinate diagonalUpRight() {

        return up().right();
    }

    public Coordinate diagonalDownLeft() {

        return down().left();
    }

    public Coordinate diagonalDownRight() {

        return down().right();
    }

    @Override
    public int hashCode() {
        return number;
    }

    @Override
    public boolean equals(Object o) {

        if (!(o instanceof Coordinate c))
            return false;
        return (c.letter == this.letter) && (c.number == this.number);

    }

    public char getLetter() {
        return letter;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "(" + letter + " " + number + ")";
    }

}