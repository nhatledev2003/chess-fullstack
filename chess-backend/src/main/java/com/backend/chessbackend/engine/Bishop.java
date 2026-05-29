package com.backend.chessbackend.engine;



public class Bishop extends Piece {

    public Bishop(Color color) {
        super(color);
    }

    @Override
    public boolean isValidMove(Board board, Square start, Square end) {

        if (end.getPiece() != null && end.getPiece().getColor() == this.getColor()) {
            return false;
        }

        int dx = Math.abs(end.getX() - start.getX());
        int dy = Math.abs(end.getY() - start.getY());

        // 2. Kiểm tra luật di chuyển chéo
        if (dx != dy) {
            return false;
        }

        // 3. Kiểm tra vật cản trên đường đi
        int xDirection = (end.getX() > start.getX()) ? 1 : -1;
        int yDirection = (end.getY() > start.getY()) ? 1 : -1;

        int currentX = start.getX() + xDirection;
        int currentY = start.getY() + yDirection;

        while (currentX != end.getX() && currentY != end.getY()) {
            if (board.getSquare(currentX, currentY).isOccupied()) {
                return false; // Bị cản đường
            }
            currentX += xDirection;
            currentY += yDirection;
        }

        return true;
    }
}