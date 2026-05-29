package com.backend.chessbackend.engine;


public class Rook extends Piece {

    public Rook(Color color) {
        super(color);
    }

    @Override
    public boolean isValidMove(Board board, Square start, Square end) {
        // 1. Không được ăn quân cùng màu
        if (end.getPiece() != null && end.getPiece().getColor() == this.getColor()) {
            return false;
        }

        // 2. Kiểm tra luật di chuyển thẳng
        if (start.getX() != end.getX() && start.getY() != end.getY()) {
            return false;
        }

        // 3. Kiểm tra vật cản trên đường đi
        if (start.getX() == end.getX()) { // Di chuyển dọc
            int yDirection = (end.getY() > start.getY()) ? 1 : -1;
            for (int y = start.getY() + yDirection; y != end.getY(); y += yDirection) {
                if (board.getSquare(start.getX(), y).isOccupied()) {
                    return false;
                }
            }
        } else { // Di chuyển ngang
            int xDirection = (end.getX() > start.getX()) ? 1 : -1;
            for (int x = start.getX() + xDirection; x != end.getX(); x += xDirection) {
                if (board.getSquare(x, start.getY()).isOccupied()) {
                    return false;
                }
            }
        }

        return true;
    }
}