package br.gov.sp.cptm.controller;

import br.gov.sp.cptm.dto.ReservationRequest;
import br.gov.sp.cptm.dto.BaseResponse;
import br.gov.sp.cptm.model.BikeRack;
import br.gov.sp.cptm.service.BikeSpotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bike-spot-reservation")
public class BikeSpotController {

    @Autowired
    private BikeSpotService service;

    @GetMapping
    public ResponseEntity<List<BikeRack>> getAvailableStation() {
        return ResponseEntity.ok(service.getAvailableStation());
    }

    @GetMapping("/{stationId}")
    public ResponseEntity<BaseResponse> doesTheBikeRackHasVacancy(@PathVariable Integer stationId) {
        return ResponseEntity.ok(service.doesTheBikeRackHasVacancy(stationId));
    }

    @PostMapping
    public ResponseEntity<BaseResponse> reserveBikeSpot(ReservationRequest request) {
        return ResponseEntity.ok(service.reserveBikeSpot(request));
    }
}
