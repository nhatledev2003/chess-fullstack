package com.backend.chessbackend.engine;

import lombok.Data;

@Data
public class Board {
    private Square[][] squares;

    public Board() {
        this.squares = new Square[8][8];
        this.resetBoard();
    }

    // Lấy ra một ô cờ tại tọa độ cụ thể
    public Square getSquare(int x, int y) {
        if (x < 0 || x > 7 || y < 0 || y > 7) {
            throw new IllegalArgumentException("Tọa độ nằm ngoài bàn cờ!");
        }
        return squares[x][y];
    }

    // Khởi tạo bàn cờ
    public void resetBoard() {
        // 1. Tạo 64 ô cờ trống
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                squares[i][j] = new Square(i, j, null);
            }
        }





    }
    // 2. Setup quân cờ (Chúng ta sẽ thêm logic xếp quân vào đây ở Day 4 & Day 5
    // sau khi đã tạo xong các class con như Pawn, Knight, King...)
    public boolean isInCheck(Color color) {
        Square kingSquare = findKingSquare(color);

        // Trải phẳng vòng lặp để quét 64 ô cờ
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Piece currentPiece = squares[i][j].getPiece();

                // Nếu ô này có chứa quân cờ của đối phương
                if (currentPiece != null && currentPiece.getColor() != color) {
                    // Mượn logic isValidMove của chính quân địch để xem nó có "ăn" được Vua không
                    if (currentPiece.isValidMove(this, squares[i][j], kingSquare)) {
                        return true; // Phát hiện tia chiếu!
                    }
                }
            }
        }
        return false; // An toàn
    }
    private Square findKingSquare(Color color) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Piece piece = squares[i][j].getPiece();
                if (piece != null && piece instanceof King && piece.getColor() == color) {
                    return squares[i][j];
                }
            }
        }
        throw new IllegalStateException("Lỗi nghiêm trọng: Không tìm thấy Vua trên bàn cờ!");
    }
}