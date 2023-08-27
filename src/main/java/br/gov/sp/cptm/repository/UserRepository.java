package br.gov.sp.cptm.repository;

import br.gov.sp.cptm.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Usuario, Integer> {
}
