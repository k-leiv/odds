package com.assessment.odds.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Schema(description = "Match description", example = "Euroleague Final")
    private String description;

    @Schema(description = "Date of match in yyyy-MM-dd format", example = "2024-05-21")
    @Column(columnDefinition = "DATE")
    private LocalDate matchDate;

    @Schema(description = "Time of match in hh:mm format", example = "20:30")
    @Column(columnDefinition = "TIME")
    private LocalTime matchTime;

    @Schema(description = "Team A name", example = "Real Madrid")
    private String teamA;

    @Schema(description = "Team B name", example = "Monaco")
    private String teamB;

    @Schema(description = "Sport - FOOTBALL(0) or BASKETBALL(1)", example = "1")
    @Enumerated(EnumType.ORDINAL)
    private Sport sport;
}
