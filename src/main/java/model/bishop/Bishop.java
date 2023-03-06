package model.bishop;

import model.*;

import java.util.HashSet;
import java.util.Set;

public abstract class Bishop extends Piece {
    //private ListCoor coordinates;
    private Set<Coordinate> coordinates;

    public Bishop(Type shape, Cell cell) {
        super(shape, cell);
    }

    public Set<Coordinate> getNextMovements() {

        return Bishop.getNextMovementsAsBishop(this);
    }

    public static Set<Coordinate> getNextMovementsAsBishop(Piece p) {

        Set<Coordinate> coordinates = new HashSet<>();
        Cell cell = p.getCell();
        Board board = cell.getBoard();
        Piece.Color color = p.getShape().getColor();
        Coordinate position = cell.getCoordinate();
        Coordinate c;


        //up-right
        c = position.diagonalUpRight();
        while (board.getCells(c) != null && board.getCells(c).isEmpty()) {
            coordinates.add(c);
            c = c.diagonalUpRight();

        }
        if (board.getCells(c) != null && board.getCells(c).getPiece().getColor() != color) {
            coordinates.add(c);
        }


        //up-left
        c = position.diagonalUpLeft();
        while (board.getCells(c) != null && board.getCells(c).isEmpty()) {
            coordinates.add(c);
            c = c.diagonalUpLeft();

        }
        if (board.getCells(c) != null && board.getCells(c).getPiece().getColor() != color) {
            coordinates.add(c);
        }


        //down-left

        c = position.diagonalDownLeft();
        while (board.getCells(c) != null && board.getCells(c).isEmpty()) {
            coordinates.add(c);
            c = c.diagonalDownLeft();

        }
        if (board.getCells(c) != null && board.getCells(c).getPiece().getColor() != color) {
            coordinates.add(c);
        }


        //down-right


        c = position.diagonalDownRight();
        while (board.getCells(c) != null && board.getCells(c).isEmpty()) {
            coordinates.add(c);
            c = c.diagonalDownRight();

        }
        if (board.getCells(c) != null && board.getCells(c).getPiece().getColor() != color) {
            coordinates.add(c);
        }


        return coordinates;
    }

    public void check(Coordinate c, Set<Coordinate> coordinates) {
        Board board = getCell().getBoard();
        if (board.getCells(c) != null) {
            if (board.getCells(c).isEmpty() ||
                    board.getCells(c).getPiece().getShape().getColor() != getShape().getColor()) {
                coordinates.add(c);

            }


        }


    }

}
