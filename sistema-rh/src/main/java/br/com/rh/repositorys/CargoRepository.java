package br.com.rh.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.rh.model.Cargo;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Long> {

}
