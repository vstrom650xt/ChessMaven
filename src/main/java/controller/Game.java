package controller;

import model.Board;
import model.Cell;
import model.Coordinate;
import model.Piece;
import tools.Input;

import java.util.Scanner;


public class Game {
    static Board board = new Board();


    public  void start(){
        inicio();


    }

    public void inicio() {
        int answ;
        answ= Input.getInteger(  "[1]Play \n" +
                "[2]Exit");

        if (answ==1){
            choose();

        }
    }


    public  void choose(){
        System.out.println(board);
        System.out.println("choose the piece");
        Coordinate coordinate =getCoordinatePlayer(); //elegir la pieza
        Piece p = board.getCells(coordinate).getPiece();
        System.out.println("where would you like to put it ?");
        coordinate =getCoordinatePlayer(); // donde vamos a poner la pieza
        p.moveTo(coordinate);
        p.putInYourPlace();
        System.out.println(board);


    }






    /**
     *  method to translate the letter into a number
     * @param coord
     * @return
     */
    public static int translateCoorLetter(String coord) {
        char aux = (char) ((coord.charAt(0)));

        return aux;
    }

    /**
     * method to separate the number
     * @param coord
     * @return the value of the letter translated into integer
     */
    public static int translateCoorNum(String coord) {
        int aux = Character.getNumericValue(coord.charAt(1));
        return aux;
    }

    /**
     * method to know if the coordinate is long enought or too short
     * @param coord
     * @return true if the coordinate is made of a number and a letter
     */
    public static boolean longEnought(String coord) {
        boolean correct = false;
        if (coord.length() >= 2 ) {
            correct = true;

        }

        return correct;
    }

    /**
     * method to know if the letter is between A nd I
     * @param coord
     * @return true if is a correct letter
     */
    public static boolean isLetter(String coord) {
        int i = 65;
        boolean correct = false;

        do {
            if (coord.charAt(0) == (char) (i)) {
                correct = true;

            }

            i++;
        } while (i <= 73 && !correct);

        return correct;

    }

    /**
     *method to know if the number is between 1 and 9
     * @param coord
     * @returnw true if the number is correct
     */
    public static boolean isNumber(String coord) {
        int i = 1;
        boolean correct = false;
        int aux = Character.getNumericValue(coord.charAt(1));

        if (aux == 0) correct = false;

        do {
            if (aux == i) {
                correct = true;
            }
            i++;
        } while (i <= 9 && !correct);

        return correct;

    }

    /**
     * method to know if the coordinate is well formatted
     * @param coord
     * @return true if is well formatted
     */
    public static boolean correctFormat(String coord) { //creo q bien
        boolean correct = false;
        if (coord.charAt(1) >= 49 && coord.charAt(1) <= 57 && coord.charAt(0) >= 65 && coord.charAt(0) <= 73)
            correct = true;

        return correct;

    }

    public static  boolean isPiece(Coordinate coordinate){
        if((board.getCells(coordinate).getPiece() != null))
            return  true;

        return  false;


    }

    public Coordinate getCoordinatePlayer() {
        Scanner sc = new Scanner(System.in);
        String coordinate;

        do {
            coordinate = sc.next().toUpperCase().trim();
            if (!longEnought(coordinate)) {
                System.out.println("la coordenada debe estar formada por dos caracteres");
            } else if (!correctFormat(coordinate)) {
                System.out.println("ponga primero  la letra y el numero  luego");
            } else if (!isLetter(coordinate)) {
                System.out.println("la letra debe estar entre la A y la I");
            } else if (!isNumber(coordinate)) {
                System.out.println("el numero  debe estar entre el 1 y el 9");
            }

        } while (!longEnought(coordinate) || !isLetter(coordinate) || !isNumber(coordinate) || !correctFormat(coordinate));


        return new Coordinate((char) translateCoorLetter(coordinate),translateCoorNum(coordinate));
    }}
