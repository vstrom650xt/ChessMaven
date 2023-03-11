package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DeletedPieceManager implements IDeletedPieceManager{

private List<Piece> pieceList;

    public DeletedPieceManager() {
        this.pieceList = new LinkedList<>();
    }


    @Override
    public void addPiece(Piece piece) {
        pieceList.add(piece);
    }

    @Override
    public int count(Piece.Type type) {
        int count = 0;
        for (Piece piece : pieceList)
            if (piece.getShape().equals(type))
                count++;
        return count;
    }

    @Override
    public Piece removeLast() {
        pieceList.remove(0);

        return null;
    }
}