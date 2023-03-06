package model;

import java.util.ArrayList;
import java.util.List;

public class DeletedPieceManager implements IDeletedPieceManager{

private List<Piece> pieceList;

    public DeletedPieceManager() {
        this.pieceList = new ArrayList<>();
    }


    @Override
    public void addPiece(Piece piece) {
        pieceList.add(piece);
    }

    @Override
    public int count(Piece.Type type) {

        return 0;
    }

    @Override
    public Piece removeLast() {
        pieceList.remove(0);

        return null;
    }
}