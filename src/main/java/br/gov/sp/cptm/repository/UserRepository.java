package br.gov.sp.cptm.repository;

import br.gov.sp.cptm.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
