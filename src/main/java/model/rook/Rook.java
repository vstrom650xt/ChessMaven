package model.rook;

import model.*;
import model.bishop.Bishop;

import java.util.HashSet;
import java.util.Set;

/**
 * Rook
 */
public abstract class Rook extends Piece {
    private Set<Coordinate> coordinates = new HashSet<>();

    public Rook(Type shape, Cell cell) {
        super(shape, cell);
    }

    /**
     * @return possible movements
     */
    @Override
    public Set<Coordinate> getNextMovements() {
        return Rook.getNextMovementsAsRook(this);

    }

    /**
     * @param p
     * @return possible movements
     */
    public static Set<Coordinate> getNextMovementsAsRook(Piece p) {

        Set<Coordinate> coordinates = new HashSet<>();
        Cell cell = p.getCell();
        Board board = cell.getBoard();
        Piece.Color color = p.getShape().getColor();
        Coordinate position = cell.getCoordinate();
        Coordinate c;


        //up
        c = position.up();
        while (board.getCells(c) != null && board.getCells(c).isEmpty()) {
            coordinates.add(c);
            c = c.up();

        }
        if (board.getCells(c) != null && board.getCells(c).getPiece().getColor() != color) {
            coordinates.add(c);
        }
        //down
        c = position.down();
        while (board.getCells(c) != null && board.getCells(c).isEmpty()) {
            coordinates.add(c);
            c = c.down();

        }
        if (board.getCells(c) != null && board.getCells(c).getPiece().getColor() != color) {
            coordinates.add(c);
        }

        //left
        c = position.left();
        while (board.getCells(c) != null && board.getCells(c).isEmpty()) {
            coordinates.add(c);
            c = c.left();

        }
        if (board.getCells(c) != null && board.getCells(c).getPiece().getColor() != color) {
            coordinates.add(c);
        }

        //right
        c = position.right();
        while (board.getCells(c) != null && board.getCells(c).isEmpty()) {
            coordinates.add(c);
            c = c.right();

        }
        if (board.getCells(c) != null && board.getCells(c).getPiece().getColor() != color) {
            coordinates.add(c);
        }


        return coordinates;
    }



}
