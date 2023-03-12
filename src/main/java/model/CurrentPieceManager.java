package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import static com.diogonunes.jcolor.Ansi.colorize;

public class CurrentPieceManager implements ICurrentPieceManager {
    private List<Piece> pieces;

    private Board board;

    public CurrentPieceManager(Board board) {
        this.board = board;
        this.pieces = new LinkedList<>();
    }



    @Override
    public void addPiece(Piece piece) {
        pieces.add(piece);
    }

    @Override
    public int count(Piece.Color color,Piece.Type shape) {
        int count = 0;

        for (Cell cell : board.getBoard().values())
            if (cell.getPiece() ==null){

            }else if (cell.getPiece().getShape().getColor().equals(color)){
                    Piece.Type  aux =cell.getPiece().getShape();
                    if (aux.equals(shape)){
                        count++;

                    }
            }



        return count;
    }



    @Override
    public Piece removeLast() {
        return pieces.remove(0);
    }


}