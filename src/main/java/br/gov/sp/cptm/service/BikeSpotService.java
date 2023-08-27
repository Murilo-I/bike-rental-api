package br.gov.sp.cptm.service;

import br.gov.sp.cptm.dto.BaseResponse;
import br.gov.sp.cptm.dto.ReservationRequest;
import br.gov.sp.cptm.model.BikeRack;
import br.gov.sp.cptm.model.ReservationManagement;
import br.gov.sp.cptm.model.User;
import br.gov.sp.cptm.repository.BikeRackRepository;
import br.gov.sp.cptm.repository.ReservationManagementRepository;
import br.gov.sp.cptm.repository.UserRepository;
import br.gov.sp.cptm.util.exception.GenericException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BikeSpotService {

    @Autowired
    private BikeRackRepository bikeRepository;
    @Autowired
    private ReservationManagementRepository reservationRepository;
    @Autowired
    private UserRepository userRepository;


    public List<BikeRack> getAvailableStation() {
        return bikeRepository.findAll();
    }


    public BaseResponse reserveBikeSpot(ReservationRequest request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new GenericException("User not found"));
        BikeRack bikeRack = bikeRepository.findById(request.getStationId())
                .orElseThrow(() -> new GenericException("Station not found"));

        var reserve = ReservationManagement.builder().user(user).station(bikeRack)
                .time(request.getTime()).isActive(true)
                .createdAt(LocalDateTime.now())
                .build();

        reservationRepository.save(reserve);

        return new BaseResponse(true, "Reserva feita com sucesso");
    }

    public BaseResponse doesTheBikeRackHasVacancy(Integer stationId) {
        BikeRack bikeRack = bikeRepository.findById(stationId)
                .orElseThrow(() -> new GenericException("Station not found"));

        var reserves = reservationRepository.findByIsActiveAndStation(true, bikeRack);

        if (reserves.size() > bikeRack.getVacancyAmount())
            throw new GenericException("Não há vagas disponíveis");

        return new BaseResponse(true, "Vagas disponíveis");
    }
}
