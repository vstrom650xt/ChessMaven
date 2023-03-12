package model;

public interface ICurrentPieceManager {
    void addPiece(Piece piece);

    int count(Piece.Color color,Piece.Type shape
    );

    Piece removeLast();
}
