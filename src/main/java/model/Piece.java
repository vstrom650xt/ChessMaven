package model;

import com.diogonunes.jcolor.Attribute;
import controller.Game;
import model.queen.QueenBlack;
import tools.Input;

import java.util.HashSet;
import java.util.Set;

import static com.diogonunes.jcolor.Ansi.colorize;

public abstract class Piece {
//protected para que solo puedan acceder los hijo


    private Type shape;
    protected Cell cell;
    protected Set<Coordinate> coordinates = new HashSet<>();

    public Piece(Type shape, Cell cell) {
        this.shape = shape;
        this.cell = cell;
    }

    public Type getShape() {
        return shape;
    }

    /**
     * @return
     */
    public abstract Set<Coordinate> getNextMovements();

    public Color getColor() {
        return shape.color;

    }

    public void setShape(Type shape) {
        this.shape = shape;
    }


    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public void putInYourPlace() {

        cell.setPiece(this);

    }

    /**
     * @param c
     * @param getNextMovements
     */
    public void check(Coordinate c, Set<Coordinate> getNextMovements) {
        Board board = getCell().getBoard();
        if (board.getCells(c) != null) {
            if (board.getCells(c).isEmpty() ||
                    board.getCells(c).getPiece().getShape().getColor() != getShape().getColor()) {
                getNextMovements.add(c);
            }
        }
    }

    /**
     *
     */
    public enum Color {

        WHITE(Attribute.TEXT_COLOR(255)),
        BLACK(Attribute.TEXT_COLOR(16));
        private final Attribute pieceColor;

        public Color next() {
            if (this.equals(WHITE))
                return BLACK;

            return WHITE;


        }

        public Attribute getPieceColor() {
            return pieceColor;
        }

         Color(Attribute pieceColor) {
            this.pieceColor = pieceColor;
        }

    }

    /**
     * enum of Pieces
     */
    public enum Type {
        WHITE_KING("♚", Color.WHITE),
        WHITE_QUEEN("♛", Color.WHITE),
        WHITE_ROOK("♜", Color.WHITE),
        WHITE_BISHOP("♝", Color.WHITE),
        WHITE_KNIGHT("♞", Color.WHITE),
        WHITE_PAWN("♟", Color.WHITE),
        BLACK_KING("♚", Color.BLACK),
        BLACK_QUEEN("♛", Color.BLACK),
        BLACK_ROOK("♜", Color.BLACK),
        BLACK_BISHOP("♝", Color.BLACK),
        BLACK_KNIGHT("♞", Color.BLACK),
        BLACK_PAWN("♟", Color.BLACK),
        ;

        private String shape;

        public String getShape() {
            return shape;
        }

        public Color getColor() {
            return color;
        }

        private Color color;

        Type(String shape, Color color) {
            this.color = color;
            this.shape = shape;
        }

        @Override
        public String toString() {
            return String.valueOf(shape);

        }

    }

    /**
     * @param coordinate
     * @return
     */
    public boolean isInHighLight(Coordinate coordinate) {
        if (getNextMovements().contains(coordinate))
            return true;

        return false;
    }

    /**
     * @param coordinate
     * @return
     */
    public boolean moveTo(Coordinate coordinate) {
        while (!isInHighLight(coordinate)) {
            System.out.println("you are out of the hightlights");
            coordinate = Input.askCoordinate();
        }
        if (!getNextMovements().contains(coordinate))
            return false;
        if (!cell.getBoard().getCells(coordinate).isEmpty()) {
            Piece p = cell.getBoard().getCells(coordinate).getPiece();
            p.cell = null;
            cell.getBoard().getDeletedPieceManager().addPiece(p);
        }
        cell.setPiece(null);
        cell = cell.getBoard().getCells(coordinate);
        putInYourPlace();
        return true;
    }

    @Override
    public String toString() {
        return colorize(shape.getShape(), shape.getColor().getPieceColor(), cell.getColor()
                .getAttribute());
    }



}