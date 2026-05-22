package com.backend.chessbackend.engine;

import lombok.Data;

@Data
public abstract class Piece {
    private Color color;
    private boolean isKilled = false; // Trạng thái: đã bị ăn hay chưa?

    public Piece(Color color) {
        this.color = color;
    }

    /**
     * Mỗi quân cờ sẽ có một luật di chuyển riêng, nên ta để abstract.
     * * @param board Bàn cờ hiện tại (để kiểm tra xem có bị cản đường không)
     * @param start Ô xuất phát
     * @param end   Ô đích đến
     * @return true nếu nước đi đúng luật của quân cờ đó
     */
    public abstract boolean isValidMove(Board board, Square start, Square end);
}