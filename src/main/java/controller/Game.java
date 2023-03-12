package controller;

import model.*;
import tools.Input;
import tools.Screen;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;


public class Game {
    static Board board = new Board();
    private Piece.Color shift;
    private String player1 , player2 ;


    public Game() {
        shift = Piece.Color.WHITE;
        this.player1 = "player1";
        this.player2 = "player2";
    }

//    public IDeletedPieceManager getCurrentPieceManager() {
//        return currentPieceManager;
//    }


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
                if (kingsAlive()){
                    checkTurn();
                    changeBoardView();
                }   else{
                    exit = true;
                }

            } while (!exit);


        }
    }


    public boolean kingsAlive() {
        Collection<Cell> cells = board.getBoard().values();
        List<Cell> celdas = new ArrayList<>(cells);
        boolean foundWhiteKing = false;
        boolean foundBlackKing= false;
        Piece.Type type;

        for (int i = 0; i < cells.size(); i++) {
            if (celdas.get(i).isEmpty()){

            }else{
                type = celdas.get(i).getPiece().getShape();
                if (type == Piece.Type.BLACK_KING ) {
                    foundBlackKing = true;

                } else if (type == Piece.Type.WHITE_KING ) {
                    foundWhiteKing = true;
                }

                if (foundWhiteKing  && foundBlackKing ) {
                    return true;
                }


            }
        }




        return false;

    }

    public void choose() {
        Coordinate coordinate;
        Screen.show2(board,shift);
        System.out.println("choose the piece");
        coordinate = getCoordinatePlayer(); //elegir la pieza
        Piece p = board.getCells(coordinate).getPiece();
        board.highlight(board.getCells(coordinate).getPiece().getNextMovements());
        Screen.show2(board,shift);

        System.out.println("where would you like to put it ?");
        coordinate = askPiecePlayer(); // donde vamos a poner la pieza
     //   p. sige valiendo  peon al salir de moveto1
        p.moveTo(coordinate);
       // p.putInYourPlace();
        board.resetColor();

        // aver si asi limpia la lista
        if ( board.getCells(coordinate).getPiece()==null){

        }else {
            board.getCells(coordinate).getPiece().getNextMovements().clear();

        }



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

        Coordinate cord;
        do {
            cord=Input.askCoordinate();
        } while (!pieceSelected(cord)||!isYourColor(cord)||!noMovements(cord));
   //     board.getCells(cord).getPiece().getNextMovements().clear();

        return cord;
    }


    public Coordinate askPiecePlayer() {
        Scanner sc = new Scanner(System.in);
        String coordinate;
        Coordinate cord;
        Piece piece;


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
        while (!isEnemy(cord) && !isEmpty ) {
            System.out.println("u cant kill an ally");
            coordinate = sc.next().toUpperCase().trim();
            cord = new Coordinate((char) translateCoorLetter(coordinate), translateCoorNum(coordinate));
        }



        return cord;
    }
//
//    private void changeBoardView() {
//        if (shift == Piece.Color.WHITE)
//            shift = Piece.Color.BLACK;
//        else
//            shift = Piece.Color.WHITE;
//    }
    public boolean isEnemy(Coordinate coordinate) {
        Piece p = board.getCells(coordinate).getPiece();
        if (p==null){

        } else if (shift == Piece.Color.WHITE) {
            if (p.getColor().equals(Piece.Color.WHITE)){
                return  false;
            }

        }
            return true;



    }

    public boolean noMovements(Coordinate cord) {
        if (board.getCells(cord).getPiece().getNextMovements().size()==0 ){
            System.out.println("this piece is blocked");
            return false;


        }

        return true;
    }
    public boolean isYourColor(Coordinate cord) {
        if (board.getCells(cord).getPiece().getColor() != shift){
            System.out.println("is not from your color");
                return false;


        }

        return true;
    }
    public boolean pieceSelected(Coordinate cord) {
        if (board.getCells(cord).isEmpty()) {
            System.out.println("you choose an empty cell , nothing to move");
            return false;
        }

        return true;
    }

    private void checkTurn() {
        if (shift == Piece.Color.WHITE)
            System.out.println("Turn of " + player1 + ".");
        else
            System.out.println("Turn of " + player2 + ".");
      //  Screen.show2(board, shift);
        choose();
    }

    private void changeBoardView() {
        if (shift == Piece.Color.WHITE)
            shift = Piece.Color.BLACK;
        else
            shift = Piece.Color.WHITE;
    }
}