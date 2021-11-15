package br.com.sunsystem.partida_futebolapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sunsystem.partida_futebolapi.entity.Equipe;

@Repository
public interface EquipeRepository extends JpaRepository<Equipe, Long> {

}
