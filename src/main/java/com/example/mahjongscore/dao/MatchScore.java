package com.example.mahjongscore.dao;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class MatchScore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @ManyToOne
    @JoinColumn(name = "player_id", nullable = false)
    @Getter
    @Setter
    private Player player;

    @Column(nullable = false)
    @Getter
    @Setter
    private LocalDate matchDate;

    @Column
    @Getter
    @Setter
    private Integer score;

    // Getters and Setters

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MatchScore that = (MatchScore) o;

        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(player, that.player)) return false;
        if (!Objects.equals(matchDate, that.matchDate)) return false;
        return Objects.equals(score, that.score);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (player != null ? player.hashCode() : 0);
        result = 31 * result + (matchDate != null ? matchDate.hashCode() : 0);
        result = 31 * result + (score != null ? score.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "MatchScore{" +
                "id=" + id +
                ", player=" + player +
                ", matchDate=" + matchDate +
                ", score=" + score +
                '}';
    }

}
