package br.com.sunsystem.partida_futebolapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sunsystem.partida_futebolapi.entity.Equipe;

@Repository
public interface EquipeRepository extends JpaRepository<Equipe, Long> {

	public Optional<Equipe> findByNomeEquipe(String nomeEquipe);
	
	public boolean existsByNomeEquipe(String nomeEquipe);
}
