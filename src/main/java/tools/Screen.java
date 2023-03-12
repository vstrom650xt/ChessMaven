package tools;

import model.Board;
import model.Coordinate;
import model.IDeletedPieceManager;
import model.Piece;

public class Screen {

    public static void showStorage(IDeletedPieceManager storage){

    }

    public static void show2(Board board, Piece.Color color){
        if (color == Piece.Color.BLACK)
        showviewblack(board);
        else
        showViewWhite(board);
       // showStorage(board.getDeletedPieceManager());
      //  showStorage(board.getCurrentPieceManager());
    }

    private static void showviewblack(Board board){
        String output = "   A  B  C  D  E  F  G  H\n";
        for (int i = 0; i < 8; i++) {
            output += (i + 1) + " ";
            for (int j = 0; j < 8; j++) {
                output += board.getCells(new Coordinate((char) ('A' + j), i + 1));
            }
            output += " " + (i + 1) + "\n";
        }
        output += "   A  B  C  D  E  F  G  H";
        System.out.println(output);
    }
    public static void show(Board board, Piece.Color color){
        if (color == Piece.Color.BLACK)
            showViewWhite(board);
        else
            showviewblack(board);
  //      showStorage(board.getDeletedPieceManager());
//        showStorage(board.getCurrentPieceManager());
    }

    private static void showViewWhite(Board board){
        String output = "   A  B  C  D  E  F  G  H\n";
        for (int i = 8; i > 0; i--) {
            output += i + " ";
            for (int j = 0; j < 8; j++) {
                output += board.getCells(new Coordinate((char) ('A' + j), i ));
            }
            output += " " + i + "\n";
        }
        output += "   A  B  C  D  E  F  G  H";
        System.out.println(output);
    }
    public static void show(int[][] v){
        for(int row=0;row<v.length;row++) {
            for (int col = 0; col < v[row].length; col++) {
                System.out.print(v[row][col] + " ");
            }
            System.out.println();
        }
    }

    public static void show(char[][] v){
        for(int row=0;row<v.length;row++) {
            for (int col = 0; col < v[row].length; col++) {
                System.out.print(v[row][col] + " ");
            }
            System.out.println();
        }
    }
    public static void clear(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}