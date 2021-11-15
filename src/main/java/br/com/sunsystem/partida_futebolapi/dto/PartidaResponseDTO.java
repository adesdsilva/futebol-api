package br.com.sunsystem.partida_futebolapi.dto;

import java.io.Serializable;
import java.util.List;

import br.com.sunsystem.partida_futebolapi.entity.Partida;

public class PartidaResponseDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Partida> partidas;
	
	public PartidaResponseDTO() {
		
	}

	public PartidaResponseDTO(List<Partida> partidas) {
		this.partidas = partidas;
	}

	public List<Partida> getPartidas() {
		return partidas;
	}

	public void setPartidas(List<Partida> partidas) {
		this.partidas = partidas;
	}
	
	
}
