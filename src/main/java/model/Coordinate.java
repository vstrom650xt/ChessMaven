package model;

public class Coordinate {

    private char letter;
    private int number;

    public Coordinate(char letter, int number) {
        this.letter = letter;
        this.number = number;
    }

    public char getLetter() {
        return letter;
    }

    public int getNumber() {
        return number;
    }

    public Coordinate up(){
        return new Coordinate(letter,number-1);


    }
    public Coordinate down(){
        return new Coordinate(letter,number+1);


    }
    public Coordinate right(){
        return new Coordinate((char) (letter+1),number);


    }
    public Coordinate left(){
        return new Coordinate((char) (letter-1),number);


    }

    public Coordinate diagonalUpLeft(){

        return  up().left();

    }

    public Coordinate diagonalUpRight(){

        return up().right();
    }

    public Coordinate diagonalDownLeft(){

        return  down().left();
    }
    public Coordinate diagonalDownRight(){

        return  down().right();
    }



}
