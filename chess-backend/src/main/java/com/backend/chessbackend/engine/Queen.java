package com.backend.chessbackend.engine;



public class Queen extends Piece {

    public Queen(Color color) {
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

        // 2. Xác định hướng đi: Thẳng (giống Xe) hoặc Chéo (giống Tượng)
        boolean isStraight = (start.getX() == end.getX() || start.getY() == end.getY());
        boolean isDiagonal = (dx == dy);

        if (!isStraight && !isDiagonal) {
            return false;
        }

        // 3. Kiểm tra vật cản (Sử dụng bước nhảy linh hoạt)
        int xDirection = Integer.compare(end.getX(), start.getX()); // Trả về 1, -1 hoặc 0
        int yDirection = Integer.compare(end.getY(), start.getY());

        int currentX = start.getX() + xDirection;
        int currentY = start.getY() + yDirection;

        while (currentX != end.getX() || currentY != end.getY()) {
            if (board.getSquare(currentX, currentY).isOccupied()) {
                return false;
            }
            currentX += xDirection;
            currentY += yDirection;
        }

        return true;
    }
}