package view;

import model.Tools;
import tools.Input;

import java.util.Scanner;

public class Menu {

    public void inicio() {
        System.out.println(
                "[1]Play" +
               "[2]Exit"
        );
    }

    public void choose(){
        int answ;
        System.out.println("choose the piece");




    }


    /**
     *  method to translate the letter into a number
     * @param coord
     * @return
     */
    public static int translateCoorLetter(String coord) {
        char aux = (char) ((coord.charAt(1) - 'A') + 1);
        return aux;
    }

    /**
     * method to separate the number
     * @param coord
     * @return the value of the letter translated into integer
     */
    public static int translateCoorNum(String coord) {
        int aux = Character.getNumericValue(coord.charAt(0));
        return aux;
    }

    /**
     * method to know if the coordinate is long enought or too short
     * @param coord
     * @return true if the coordinate is made of a number and a letter
     */
    public static boolean longEnought(String coord) {
        boolean correct = false;
        if (coord.length() == 2) {
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
            if (coord.charAt(1) == (char) (i)) {
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
        int aux = Character.getNumericValue(coord.charAt(0));

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
    public static boolean correctFormat(String coord) {
        boolean correct = false;
        if (coord.charAt(0) >= 49 && coord.charAt(0) <= 57 && coord.charAt(1) >= 65 && coord.charAt(1) <= 73)
            correct = true;

        return correct;

    }

    public static String getCoordinatePlayer() {
        Scanner sc = new Scanner(System.in);
        String coordinate;

        do {
            coordinate = sc.next().toUpperCase().trim();
            if (!longEnought(coordinate)) {
                System.out.println("la coordenada debe estar formada por dos caracteres");
            } else if (!correctFormat(coordinate)) {
                System.out.println("ponga primero el numero y luego la letra");
            } else if (!isLetter(coordinate)) {
                System.out.println("la letra debe estar entre la A y la I");
            } else if (!isNumber(coordinate)) {
                System.out.println("el numero  debe estar entre el 1 y el 9");
            }

        } while (!longEnought(coordinate) || !isLetter(coordinate) || !isNumber(coordinate) || !correctFormat(coordinate));
        coordinate = translateCoorNum(coordinate) + "" + translateCoorLetter(coordinate);
        return coordinate;
    }

}
