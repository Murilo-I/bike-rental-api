package br.gov.sp.cptm.repository;

import br.gov.sp.cptm.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
