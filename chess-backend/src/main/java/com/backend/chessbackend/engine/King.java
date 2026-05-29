package com.backend.chessbackend.engine;


public class King extends Piece {

    public King(Color color) {
        super(color);
    }

    @Override
    public boolean isValidMove(Board board, Square start, Square end) {
        // 1. Không được ăn quân cùng màu
        if (end.getPiece() != null && end.getPiece().getColor() == this.getColor()) {
            return false;
        }

        int dx = Math.abs(end.getX() - start.getX());
        int dy = Math.abs(end.getY() - start.getY());

        // 2. Vua chỉ được đi 1 ô theo mọi hướng
        return (dx <= 1 && dy <= 1);
    }
}