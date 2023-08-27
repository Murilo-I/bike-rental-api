package br.gov.sp.cptm.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@Entity
public class ReservationManagement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reservationId;
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
    @ManyToOne
    @JoinColumn(name = "stationId")
    private BikeRack station;
    private Float time;
    private boolean isActive;
    private LocalDateTime createdAt;
}
