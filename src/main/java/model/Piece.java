package model;

import com.diogonunes.jcolor.Attribute;

import java.awt.*;
import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicReference;

import static com.diogonunes.jcolor.Ansi.colorize;

public abstract  class Piece {



    private Type shape;
    private Cell cell;

    public abstract Coordinate[] getNextMovements();


    public Piece(Type shape, Cell cell){
        this.shape = shape;
        this.cell = cell;
    }
    public Type getShape() {
        return shape;
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

    public  void putInYourPlace(){
        cell.setPiece(this);

    }

    public enum Color {

        WHITE(Attribute.TEXT_COLOR(255)),
        BLACK(Attribute.TEXT_COLOR(16));

        private final Attribute pieceColor;

        public Color next(){
            if (this.equals(WHITE))
                return BLACK;

            return WHITE;


        }

        public Attribute getPieceColor() {
            return pieceColor;
        }

        private Color(Attribute pieceColor){
            this.pieceColor=pieceColor;
        }

    }
    public  enum Type{
        WHITE_KING("♚",Color.WHITE),
        WHITE_QUEEN("♛",Color.WHITE),
        WHITE_ROOK("♜",Color.WHITE),
        WHITE_BISHOP("♝",Color.WHITE),
        WHITE_KNIGHT("♞",Color.WHITE),
        WHITE_PAWN("♙",Color.WHITE),
        BLACK_KING("♚",Color.BLACK),
        BLACK_QUEEN("♛",Color.BLACK),
        BLACK_ROOK("♜",Color.BLACK),
        BLACK_BISHOP("♝",Color.BLACK),
        BLACK_KNIGHT("♞",Color.BLACK),
        BLACK_PAWN("♙",Color.BLACK),
        ;

        private String shape;

        public String getShape() {
            return shape;
        }

        public Color getColor() {
            return color;
        }

        private Color color;

        Type( String shape, Color color) {
            this.color = color;
            this.shape = shape;
        }
        @Override
        public String toString() {
            return String.valueOf(shape);

        }

    }
    @Override
    public String toString() {
        return colorize(shape.getShape(),shape.getColor().getPieceColor(),cell.getColor()
                .getAttribute());

    }

}