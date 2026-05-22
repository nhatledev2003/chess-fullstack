package com.backend.chessbackend.engine;

import lombok.Data;

@Data
public class Square {
    private int x; // (tương ứng cột A đến H)
    private int y; // (tương ứng hàng 1 đến 8)
    private Piece piece; // Trỏ đến quân cờ đang đứng ở ô này (null nếu ô trống)

    public Square(int x, int y, Piece piece) {
        this.x = x;
        this.y = y;
        this.piece = piece;
    }

    // Hàm tiện ích kiểm tra xem ô cờ có bị chiếm đóng chưa
    public boolean isOccupied() {
        return this.piece != null;
    }
}