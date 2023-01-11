package model;

public class Coordinate {

    private final char letter;
    private final int number;


    public Coordinate(char letter, int number) {
        this.letter = Character.toUpperCase(letter);
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

    @Override
    public boolean equals(Object o) {

        if(! (o instanceof  Coordinate))
            return  false;
         Coordinate c = (Coordinate) o;
        return (c.getLetter()==this.letter)&& (c.getNumber() == this.number);



    }


}
