package model;

import com.diogonunes.jcolor.Attribute;

import java.awt.*;
import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicReference;

import static com.diogonunes.jcolor.Ansi.colorize;

public class Piece {
    @Override
    public String toString() {
        return colorize(shape.getShape(),shape.getColor().getPieceColor());

    }

    private Type shape;
    private Cell cell;

    public Piece(Type shape, Cell cell){
        this.shape = shape;
        this.cell = cell;
    }
    public enum Color {

        WHITE(Attribute.TEXT_COLOR(250)),
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
        WHITE_KING("\u265A",Color.WHITE),
        WHITE_QUEEN("\u265B",Color.WHITE),
        WHITE_ROOK("\u265C",Color.WHITE),
        WHITE_BISHOP("\u265D",Color.WHITE),
        WHITE_KNIGHT("\u265E",Color.WHITE),
        WHITE_PAWN("\u2659",Color.WHITE),
        BLACK_KING("\u265A",Color.BLACK),
        BLACK_QUEEN("\u265B",Color.BLACK),
        BLACK_ROOK("\u265C",Color.BLACK),
        BLACK_BISHOP("\u265D",Color.BLACK),
        BLACK_KNIGHT("\u265E",Color.BLACK),
        BLACK_PAWN("\u2659",Color.BLACK),
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


    }
}
