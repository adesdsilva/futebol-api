package br.com.sunsystem.partida_futebolapi.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;

public class PartidaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotBlank
	private String nomeEquipeCasa;
	
	@NotBlank
	private String nomeEquipeVisitante;
	
	@NotBlank
	private String localPartida;
	
	@NotNull
	@ApiModelProperty(example = "dd/MM/yyyy HH:mm")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm", timezone = "America/Sao_Paulo")
	private Date dataHoraPartida;
	
	public PartidaDTO() {
		
	}

	public PartidaDTO(@NotBlank String nomeEquipeCasa, @NotBlank String nomeEquipeVisitante,
			@NotBlank String localPartida, @NotNull Date dataHoraPartida) {
		this.nomeEquipeCasa = nomeEquipeCasa;
		this.nomeEquipeVisitante = nomeEquipeVisitante;
		this.localPartida = localPartida;
		this.dataHoraPartida = dataHoraPartida;
	}

	public String getNomeEquipeCasa() {
		return nomeEquipeCasa;
	}

	public void setNomeEquipeCasa(String nomeEquipeCasa) {
		this.nomeEquipeCasa = nomeEquipeCasa;
	}

	public String getNomeEquipeVisitante() {
		return nomeEquipeVisitante;
	}

	public void setNomeEquipeVisitante(String nomeEquipeVisitante) {
		this.nomeEquipeVisitante = nomeEquipeVisitante;
	}

	public String getLocalPartida() {
		return localPartida;
	}

	public void setLocalPartida(String localPartida) {
		this.localPartida = localPartida;
	}

	public Date getDataHoraPartida() {
		return dataHoraPartida;
	}

	public void setDataHoraPartida(Date dataHoraPartida) {
		this.dataHoraPartida = dataHoraPartida;
	}
	
	
	
}
