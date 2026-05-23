package com.backend.chessbackend.engine;


public class Knight extends Piece {

    public Knight(Color color) {
        super(color);
    }

    @Override
    public boolean isValidMove(Board board, Square start, Square end) {
        // 1. Kiểm tra ô đích: Không được phép ăn quân cùng màu của mình
        if (end.getPiece() != null && end.getPiece().getColor() == this.getColor()) {
            return false;
        }

        // 2. Tính khoảng cách di chuyển tuyệt đối trên 2 trục
        int dx = Math.abs(start.getX() - end.getX());
        int dy = Math.abs(start.getY() - end.getY());

        // 3. Logic hình chữ L: 2 ô ngang + 1 ô dọc, hoặc 1 ô ngang + 2 ô dọc
        return (dx == 2 && dy == 1) || (dx == 1 && dy == 2);
    }
}
