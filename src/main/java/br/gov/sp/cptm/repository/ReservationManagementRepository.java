package br.gov.sp.cptm.repository;

import br.gov.sp.cptm.model.BikeRack;
import br.gov.sp.cptm.model.ReservationManagement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationManagementRepository extends JpaRepository<ReservationManagement, Integer> {

    List<ReservationManagement> findByIsActiveAndStation(boolean isActive, BikeRack station);
}
