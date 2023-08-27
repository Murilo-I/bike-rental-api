package br.gov.sp.cptm.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class BikeRack {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer stationId;
    private String station;
    private Integer vacancyAmount;
}
