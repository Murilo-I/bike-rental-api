package br.gov.sp.cptm.dto;

import lombok.Data;

@Data
public class ReservationRequest {

    private Integer userId;
    private Integer stationId;
    private Float time;
}
