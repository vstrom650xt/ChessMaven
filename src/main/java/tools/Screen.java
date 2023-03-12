package tools;

import controller.Game;
import model.*;

import static com.diogonunes.jcolor.Ansi.colorize;

public class Screen {

    public static void showStorageDeleted(IDeletedPieceManager storage){
        String output = "DELETED PIECES\n";
        for (Piece.Type type : Piece.Type.values()) {
            output += colorize(" " + type.getShape() + " ", type.getColor().getPieceColor(), Cell.Color.WHITE_CELL.getAttribute());
        }
        output += "\n";
        for (Piece.Type type : Piece.Type.values()) {
            output += colorize(" " + storage.count(type) + " ", type.getColor().getPieceColor(), Cell.Color.BLACK_CELL.getAttribute());
        }
        System.out.println(output);
    }

    public static void showStorageCurrent(CurrentPieceManager storage){
        String output = "CURRENT PIECES\n";
        for (Piece.Type type : Piece.Type.values()) {
            output += colorize(" " + type.getShape() + " ", type.getColor().getPieceColor(), Cell.Color.WHITE_CELL.getAttribute());
        }
        output += "\n";
        for (Piece.Type type : Piece.Type.values()) {
            output += colorize(" " + storage.count(type.getColor(),type) + " ", type.getColor().getPieceColor(), Cell.Color.BLACK_CELL.getAttribute());
        }
        System.out.println(output);
    }
    public static void show2(Board board, Piece.Color color){
        if (color == Piece.Color.BLACK)
         showviewblack(board);
        else
         showViewWhite(board);


        showStorageDeleted(board.getDeletedPieceManager());
        showStorageCurrent(board.getCurrentPieceManager());
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

    public static void clear(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}