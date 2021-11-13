package br.com.sunsystem.partida_futebolapi.dto;

import java.io.Serializable;

public class PartidaGoogleDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String statusPartida;
	private String tempoPartida;
	
	private String nomeEquipeCasa;
	private String urlLogoEquipeCasa;
	private Integer placarEquiqueCasa;
	private String golsEquipeCasa;
	private String placarEstendidoEquipeCasa;
	
	private String nomeEquipeVisitante;
	private String urlLogoEquipeVisitante;
	private Integer placarEquiqueVisitante;
	private String golsEquipeVisitante;
	private String placarEstendidoEquipeVisitante;
	
	public PartidaGoogleDTO() {
	
	}
	
	

	public PartidaGoogleDTO(String statusPartida, String tempoPartida, String nomeEquipeCasa, String urlLogoEquipeCasa,
			Integer placarEquiqueCasa, String golsEquipeCasa, String placarEstendidoEquipeCasa,
			String nomeEquipeVisitante, String urlLogoEquipeVisitante, Integer placarEquiqueVisitante,
			String golsEquipeVisitante, String placarEstendidoEquipeVisitante) {
		this.statusPartida = statusPartida;
		this.tempoPartida = tempoPartida;
		this.nomeEquipeCasa = nomeEquipeCasa;
		this.urlLogoEquipeCasa = urlLogoEquipeCasa;
		this.placarEquiqueCasa = placarEquiqueCasa;
		this.golsEquipeCasa = golsEquipeCasa;
		this.placarEstendidoEquipeCasa = placarEstendidoEquipeCasa;
		this.nomeEquipeVisitante = nomeEquipeVisitante;
		this.urlLogoEquipeVisitante = urlLogoEquipeVisitante;
		this.placarEquiqueVisitante = placarEquiqueVisitante;
		this.golsEquipeVisitante = golsEquipeVisitante;
		this.placarEstendidoEquipeVisitante = placarEstendidoEquipeVisitante;
	}

	public String getStatusPartida() {
		return statusPartida;
	}

	public void setStatusPartida(String statusPartida) {
		this.statusPartida = statusPartida;
	}

	public String getTempoPartida() {
		return tempoPartida;
	}

	public void setTempoPartida(String tempoPartida) {
		this.tempoPartida = tempoPartida;
	}

	public String getNomeEquipeCasa() {
		return nomeEquipeCasa;
	}

	public void setNomeEquipeCasa(String nomeEquipeCasa) {
		this.nomeEquipeCasa = nomeEquipeCasa;
	}

	public String getUrlLogoEquipeCasa() {
		return urlLogoEquipeCasa;
	}

	public void setUrlLogoEquipeCasa(String urlLogoEquipeCasa) {
		this.urlLogoEquipeCasa = urlLogoEquipeCasa;
	}

	public Integer getPlacarEquiqueCasa() {
		return placarEquiqueCasa;
	}

	public void setPlacarEquiqueCasa(Integer placarEquiqueCasa) {
		this.placarEquiqueCasa = placarEquiqueCasa;
	}

	public String getGolsEquipeCasa() {
		return golsEquipeCasa;
	}

	public void setGolsEquipeCasa(String golsEquipeCasa) {
		this.golsEquipeCasa = golsEquipeCasa;
	}

	public String getPlacarEstendidoEquipeCasa() {
		return placarEstendidoEquipeCasa;
	}

	public void setPlacarEstendidoEquipeCasa(String placarEstendidoEquipeCasa) {
		this.placarEstendidoEquipeCasa = placarEstendidoEquipeCasa;
	}

	public String getNomeEquipeVisitante() {
		return nomeEquipeVisitante;
	}

	public void setNomeEquipeVisitante(String nomeEquipeVisitante) {
		this.nomeEquipeVisitante = nomeEquipeVisitante;
	}

	public String getUrlLogoEquipeVisitante() {
		return urlLogoEquipeVisitante;
	}

	public void setUrlLogoEquipeVisitante(String urlLogoEquipeVisitante) {
		this.urlLogoEquipeVisitante = urlLogoEquipeVisitante;
	}

	public Integer getPlacarEquiqueVisitante() {
		return placarEquiqueVisitante;
	}

	public void setPlacarEquiqueVisitante(Integer placarEquiqueVisitante) {
		this.placarEquiqueVisitante = placarEquiqueVisitante;
	}

	public String getGolsEquipeVisitante() {
		return golsEquipeVisitante;
	}

	public void setGolsEquipeVisitante(String golsEquipeVisitante) {
		this.golsEquipeVisitante = golsEquipeVisitante;
	}

	public String getPlacarEstendidoEquipeVisitante() {
		return placarEstendidoEquipeVisitante;
	}

	public void setPlacarEstendidoEquipeVisitante(String placarEstendidoEquipeVisitante) {
		this.placarEstendidoEquipeVisitante = placarEstendidoEquipeVisitante;
	}

	
	
}
