package controller;

import model.Board;
import model.Cell;
import model.Coordinate;
import model.Piece;
import tools.Input;
import tools.Screen;

import javax.swing.text.View;
import java.util.Collection;
import java.util.Scanner;


public class Game {
    static Board board = new Board();
    private Piece.Color shift;

    private String player1 = "pp", player2 = "ppt2";

    public void start() {
        inicio();
    }

    public void inicio() {
        boolean exit = false;
        int answ;
        answ = Input.getInteger("[1]Play \n" +
                "[2]Exit");
        if (answ == 1) {
            do {
                if (!kingAlive())
                choose();
                else
                    exit = true;

            } while (!exit);


        }
    }

    public boolean kingAlive() {
        Piece.Type type;

        Cell cell;
        Collection<Cell> cells = board.getBoard().values();
        Collection<Coordinate> coords = board.getBoard().keySet();

        for (int i = 0; i < cells.size(); i++) {
            for (int j = 0; j < coords.size(); j++) {
                cell = new Cell(board, new Coordinate((char) ('A' + j), i));
                if (cell.isEmpty()) {


                } else {
                    type = board.getCells(new Coordinate((char) ('A' + j), i)).getPiece().getShape();
                    if (type == Piece.Type.BLACK_KING || type == Piece.Type.WHITE_KING) {
                        return true;
                    }
                }


            }

        }


        return false;

    }

    public void choose() {
        System.out.println(board);
        System.out.println("choose the piece");
        Coordinate coordinate = getCoordinatePlayer(); //elegir la pieza
        Piece p = board.getCells(coordinate).getPiece();
        board.highlight(board.getCells(coordinate).getPiece().getNextMovements());
        System.out.println(board);
        System.out.println("where would you like to put it ?");
        coordinate = setPieceOnBoard(); // donde vamos a poner la pieza
        p.moveTo(coordinate);
        p.putInYourPlace();
        board.resetColor();
        System.out.println(board);


    }


    /**
     * method to translate the letter into a number
     *
     * @param coord
     * @return
     */
    public static int translateCoorLetter(String coord) {
        char aux = (char) ((coord.charAt(0)));

        return aux;
    }

    /**
     * method to separate the number
     *
     * @param coord
     * @return the value of the letter translated into integer
     */
    public static int translateCoorNum(String coord) {
        int aux = Character.getNumericValue(coord.charAt(1));
        return aux;
    }

    /**
     * method to know if the coordinate is long enought or too short
     *
     * @param coord
     * @return true if the coordinate is made of a number and a letter
     */
    public static boolean longEnought(String coord) {
        boolean correct = false;
        if (coord.length() >= 2) {
            correct = true;

        }

        return correct;
    }

    /**
     * method to know if the letter is between A nd I
     *
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
        } while (i <= 72 && !correct);

        return correct;

    }

    /**
     * method to know if the number is between 1 and 9
     *
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
        } while (i <= 8 && !correct);

        return correct;

    }

    /**
     * method to know if the coordinate is well formatted
     *
     * @param coord
     * @return true if is well formatted
     */
    public static boolean correctFormat(String coord) { //creo q bien
        boolean correct = false;
        if (coord.charAt(1) >= 49 && coord.charAt(1) <= 57 && coord.charAt(0) >= 65 && coord.charAt(0) <= 73)
            correct = true;

        return correct;

    }

    public static boolean isPiece(Coordinate coordinate) {
        if ((board.getCells(coordinate).getPiece() != null))
            return true;

        return false;


    }

    public Coordinate getCoordinatePlayer() {
        Scanner sc = new Scanner(System.in);
        String coordinate;
        Coordinate cord;
        do {
            do {
                coordinate = sc.next().toUpperCase().trim();
                if (!longEnought(coordinate)) {
                    System.out.println("la coordenada debe estar formada por dos caracteres");
                } else if (!correctFormat(coordinate)) {
                    System.out.println("ponga primero  la letra y el numero  luego");
                } else if (!isLetter(coordinate)) {
                    System.out.println("la letra debe estar entre la A y la H");
                } else if (!isNumber(coordinate)) {
                    System.out.println("el numero  debe estar entre el 1 y el 8");
                }

            } while (!longEnought(coordinate) || !isLetter(coordinate) || !isNumber(coordinate) || !correctFormat(coordinate));

            cord = new Coordinate((char) translateCoorLetter(coordinate), translateCoorNum(coordinate));

        } while (!pieceSelected(cord));

        return new Coordinate((char) translateCoorLetter(coordinate), translateCoorNum(coordinate));
    }


    public Coordinate setPieceOnBoard() {
        Scanner sc = new Scanner(System.in);
        String coordinate;
        Coordinate cord;

        do {
            coordinate = sc.next().toUpperCase().trim();
            if (!longEnought(coordinate)) {
                System.out.println("la coordenada debe estar formada por dos caracteres");
            } else if (!correctFormat(coordinate)) {
                System.out.println("ponga primero  la letra y el numero  luego");
            } else if (!isLetter(coordinate)) {
                System.out.println("la letra debe estar entre la A y la H");
            } else if (!isNumber(coordinate)) {
                System.out.println("el numero  debe estar entre el 1 y el 8");
            }

        } while (!longEnought(coordinate) || !isLetter(coordinate) || !isNumber(coordinate) || !correctFormat(coordinate));
        cord = new Coordinate((char) translateCoorLetter(coordinate), translateCoorNum(coordinate));
        Cell cell = new Cell(board, cord);
        boolean isEmpty = cell.getBoard().getCells(cord).isEmpty();
        while (isEnemy(cord) && !isEmpty) {
            System.out.println("u cant kill an allyyyyyyyyyyyy");
            coordinate = sc.next().toUpperCase().trim();
            cord = new Coordinate((char) translateCoorLetter(coordinate), translateCoorNum(coordinate));
        }
//        while (!isEmpty) {
//            System.out.println("u cant kill an allyyyyyyyyyyyy");
//            coordinate = sc.next().toUpperCase().trim();
//            cord = new Coordinate((char) translateCoorLetter(coordinate), translateCoorNum(coordinate));
//             isEmpty = cell.getBoard().getCells(cord).isEmpty();
//        }/

        return cord;
    }


    public boolean isEnemy(Coordinate coordinate) {

        Piece p = board.getCells(coordinate).getPiece();
        if (p == null) {

        } else if (p.getColor().equals(Piece.Color.BLACK))
            return true;
        return false;
    }


    public boolean pieceSelected(Coordinate cord) {
        if (board.getCells(cord).isEmpty()) {
            System.out.println("you choose an empty cell , nothing to move");
            return false;
        }

        return true;
    }

    private void shift() {
        if (shift == Piece.Color.WHITE)
            System.out.println("Shift of " + player1 + ".");
        else
            System.out.println("Shift of " + player2 + ".");
        Screen.show2(board, shift);
    }

    private void changeShift() {
        if (shift == Piece.Color.WHITE)
            shift = Piece.Color.BLACK;
        else
            shift = Piece.Color.WHITE;
    }
}
