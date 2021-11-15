package br.com.sunsystem.partida_futebolapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sunsystem.partida_futebolapi.entity.Partida;

@Repository
public interface PartidaRepository extends JpaRepository<Partida, Long> {

}
