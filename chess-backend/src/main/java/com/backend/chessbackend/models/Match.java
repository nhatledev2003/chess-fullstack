package com.backend.chessbackend.models;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "matches")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "white_player_id")
    private User whitePlayer;

    @ManyToOne
    @JoinColumn(name = "black_player_id")
    private User blackPlayer;

    // Chuỗi FEN lưu trạng thái cuối cùng của bàn cờ
    @Column(columnDefinition = "TEXT")
    private String finalFen;

    // Kết quả: WHITE_WIN, BLACK_WIN, DRAW
    private String result;

    private LocalDateTime playedAt;

    @PrePersist
    protected void onCreate() {
        this.playedAt = LocalDateTime.now();
    }
}