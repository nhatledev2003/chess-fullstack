package com.backend.chessbackend.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "puzzles")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Puzzle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Thế cờ xuất phát của câu đố
    @Column(nullable = false)
    private String fen;

    // Chuỗi các nước đi đúng (ví dụ: "e2e4,e7e5")
    @Column(nullable = false)
    private String solutionMoves;

    private Integer difficultyElo; // Độ khó của câu đố
}