package br.com.sunsystem.partida_futebolapi.dto;

import java.io.Serializable;
import java.util.List;

import br.com.sunsystem.partida_futebolapi.entity.Equipe;

public class EquipeResponseDTO implements Serializable {


	private static final long serialVersionUID = 1L;
	
	private List<Equipe> equipes;
	
	public EquipeResponseDTO() {
		
	}

	public EquipeResponseDTO(List<Equipe> equipes) {
		this.equipes = equipes;
	}

	public List<Equipe> getEquipes() {
		return equipes;
	}

	public void setEquipes(List<Equipe> equipes) {
		this.equipes = equipes;
	}
	
	
}
