package model;

import com.diogonunes.jcolor.Attribute;

import java.util.Set;

import static com.diogonunes.jcolor.Ansi.colorize;

public abstract  class Piece {
//protected para que solo puedan acceder los hijo


    private Type shape;
    private Cell cell;
    public abstract Set <Coordinate> getNextMovements();

    public Piece(Type shape, Cell cell){
        this.shape = shape;
        this.cell = cell;
    }
    public Type getShape() {
        return shape;
    }

    public Color getColor(){
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

    public  void putInYourPlace(){
        cell.setPiece(this);

    }

    public void  check(Coordinate c, Set <Coordinate> getNextMovements){
        Board board = getCell().getBoard();
        if (board.getCells(c)!= null){
            if (board.getCells(c).isEmpty() ||
                    board.getCells(c).getPiece().getShape().getColor() != getShape().getColor()){
                getNextMovements.add(c);
            }
        }
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
        WHITE_PAWN("♟",Color.WHITE),
        BLACK_KING("♚",Color.BLACK),
        BLACK_QUEEN("♛",Color.BLACK),
        BLACK_ROOK("♜",Color.BLACK),
        BLACK_BISHOP("♝",Color.BLACK),
        BLACK_KNIGHT("♞",Color.BLACK),
        BLACK_PAWN("♟",Color.BLACK),
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

    public void moveTo(Coordinate coordinate){
        Piece p =  cell.getBoard().getCells(coordinate).getPiece();
   //     p.setCell(null);
        cell = cell.getBoard().getCells(coordinate);
        putInYourPlace();






    }

    @Override
    public String toString() {
        return colorize(shape.getShape(),shape.getColor().getPieceColor(),cell.getColor()
                .getAttribute());
    }

}