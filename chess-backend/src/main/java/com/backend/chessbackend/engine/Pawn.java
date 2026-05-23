package com.backend.chessbackend.engine;



public class Pawn extends Piece {

    public Pawn(Color color) {
        super(color);
    }

    @Override
    public boolean isValidMove(Board board, Square start, Square end) {
        // Hướng đi: Trắng tiến lên (y tăng), Đen lùi xuống (y giảm)
        int direction = (this.getColor() == Color.WHITE) ? 1 : -1;

        int dx = end.getX() - start.getX();
        int dy = end.getY() - start.getY();

        // TRƯỜNG HỢP 1: Tốt tiến thẳng 1 bước
        if (dx == 0 && dy == direction) {
            // Chỉ được tiến nếu ô phía trước không có quân nào cản
            return end.getPiece() == null;
        }

        // TRƯỜNG HỢP 2: Tốt tiến thẳng 2 bước (Chỉ áp dụng ở nước đi đầu tiên)
        int startRow = (this.getColor() == Color.WHITE) ? 1 : 6;
        if (dx == 0 && dy == 2 * direction && start.getY() == startRow) {
            // Cả ô đích và ô nằm giữa phải là ô trống
            Square middleSquare = board.getSquare(start.getX(), start.getY() + direction);
            return end.getPiece() == null && middleSquare.getPiece() == null;
        }

        // TRƯỜNG HỢP 3: Tốt ăn chéo
        if (Math.abs(dx) == 1 && dy == direction) {
            // Chỉ hợp lệ nếu ô đích có quân cờ của đối phương
            return end.getPiece() != null && end.getPiece().getColor() != this.getColor();
        }

        // Các trường hợp còn lại đều là đi sai luật
        return false;
    }
}