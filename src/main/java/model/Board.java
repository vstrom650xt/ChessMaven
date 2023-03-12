package model;

import model.bishop.BishopBlack;
import model.bishop.BishopWhite;
import model.king.KingBlack;
import model.king.KingWhite;
import model.knight.KnightBlack;
import model.knight.KnightWhite;
import model.pawn.PawnBlack;
import model.pawn.PawnWhite;
import model.queen.QueenBlack;
import model.queen.QueenWhite;
import model.rook.RookBlack;
import model.rook.RookWhite;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Board
 */
public class Board {

    private Map<Coordinate, Cell> board;

    private IDeletedPieceManager deletedPieceManager;
    private CurrentPieceManager currentPieceManager;


    /**
     * constructor of board
     */
    public Board() {
        board = new HashMap<>();
        inicializarTablero();
        placePiece();
        deletedPieceManager = new DeletedPieceManager();
        currentPieceManager = new CurrentPieceManager(this);
    }

    public CurrentPieceManager getCurrentPieceManager() {
        return currentPieceManager;
    }

    /**
     * create the board
     */
    public void inicializarTablero() {

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board.put(new Coordinate((char) ('A' + j), i + 1), new Cell(this, new Coordinate((char) ('A' + j), i + 1)));
            }

        }
    }


    public Map<Coordinate, Cell> getBoard() {
        return board;
    }

    /**
     * @param coordinate
     * @return cell of a coordinate
     */
    public Cell getCells(Coordinate coordinate) {
        return board.get(coordinate);
    }

    /**
     * @return the pieces you've killed.
     */
    public IDeletedPieceManager getDeletedPieceManager() {
        return deletedPieceManager;
    }


    /**
     * place the piece on the board
     */
    public void placePiece() {
        Piece p;
        char a = 'A';
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (j == 7) {
                    p = new PawnBlack(getCells(new Coordinate(a, 7)));
                    p.putInYourPlace();
                    a++;
                } else if (j == 2) {
                    p = new PawnWhite(getCells(new Coordinate(a, 2)));
                    p.putInYourPlace();
                }

            }

        }


        p = new RookBlack(getCells(new Coordinate('A', 8)));
        p.putInYourPlace();
        p = new KnightBlack(getCells(new Coordinate('B', 8)));
        p.putInYourPlace();
        p = new BishopBlack(getCells(new Coordinate('C', 8)));
        p.putInYourPlace();
        p = new KingBlack(getCells(new Coordinate('D', 8)));
        p.putInYourPlace();
        p = new QueenBlack(getCells(new Coordinate('E', 8)));
        p.putInYourPlace();
        p = new BishopBlack(getCells(new Coordinate('F', 8)));
        p.putInYourPlace();
        p = new KnightBlack(getCells(new Coordinate('G', 8)));
        p.putInYourPlace();
        p = new RookBlack(getCells(new Coordinate('H', 8)));
        p.putInYourPlace();


        p = new RookWhite(getCells(new Coordinate('A', 1)));
        p.putInYourPlace();
        p = new KnightWhite(getCells(new Coordinate('B', 1)));
        p.putInYourPlace();
        p = new BishopWhite(getCells(new Coordinate('C', 1)));
        p.putInYourPlace();
        p = new KingWhite(getCells(new Coordinate('D', 1)));
        p.putInYourPlace();
        p = new QueenWhite(getCells(new Coordinate('E', 1)));
        p.putInYourPlace();
        p = new BishopWhite(getCells(new Coordinate('F', 1)));
        p.putInYourPlace();
        p = new KnightWhite(getCells(new Coordinate('G', 1)));
        p.putInYourPlace();
        p = new RookWhite(getCells(new Coordinate('H', 1)));
        p.putInYourPlace();
    }

    /**
     * @param coordinates  set the lights to the cells
     */
    public void highlight(Set<Coordinate> coordinates) {
        for (Coordinate c : coordinates) {
            getCells(c).highlight();
        }
    }


    /**
     * erase the colors of the cells
     */
    public void resetColor() {
        for (Cell c : board.values()) {
            c.resetColor();
        }
    }


    @Override
    public String toString() {
        String output = "   A  B  C  D  E  F  G  H\n";
        for (int i = 0; i < 8; i++) {
            output += (i + 1) + " ";
            for (int j = 0; j < 8; j++) {
                output += board.get(new Coordinate((char) ('A' + j), 1 + i));
            }
            output += " " + (i + 1) + "\n";
        }

        output += "   A  B  C  D  E  F  G  H";
        return output;
    }


}