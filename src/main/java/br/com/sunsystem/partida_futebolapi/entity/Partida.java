package br.com.sunsystem.partida_futebolapi.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "partida")
public class Partida implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "partida_id")
	private Long id;
	
	@Transient
	private String statusPartida;
	
	@ManyToOne
	@JoinColumn(name = "equipe_casa_id")
	private Equipe equipeCasa;
	
	@ManyToOne
	@JoinColumn(name = "equipe_visitante")
	private Equipe equipeVisitante;
	
	@Column(name = "placar_equipe_casa")
	private Integer placarEquipeCasa;
	
	@Column(name = "placar_equipe_visitante")
	private Integer placarEquipeVisitante;
	
	@Column(name = "gols_equipe_casa")
	private String golsEquipeCasa;
	
	@Column(name = "gols_equipe_visitante")
	private String golsEquipeVisitante;
	
	@Column(name = "placar_estendido_equipe_casa")
	private Integer placarEstendidoEquipeCasa;
	
	@Column(name = "placar_estendido_equipe_visitante")
	private Integer placarEstendidoEquipeVisitante;
	
	@ApiModelProperty(example = "dd/MM/yyyy HH:mm")
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm", timezone = "America/Sao_Paulo")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_hora_partida")
	private Date dataHoraPartida;
	
	@Column(name = "local_partida")
	private String localPartida;
	
	public Partida() {
		
	}

	public Partida(Long id, String statusPartida, Equipe equipeCasa, Equipe equipeVisitante, Integer placarEquipeCasa,
			Integer placarEquipeVisitante) {
		this.id = id;
		this.statusPartida = statusPartida;
		this.equipeCasa = equipeCasa;
		this.equipeVisitante = equipeVisitante;
		this.placarEquipeCasa = placarEquipeCasa;
		this.placarEquipeVisitante = placarEquipeVisitante;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatusPartida() {
		return statusPartida;
	}

	public void setStatusPartida(String statusPartida) {
		this.statusPartida = statusPartida;
	}

	public Equipe getEquipeCasa() {
		return equipeCasa;
	}

	public void setEquipeCasa(Equipe equipeCasa) {
		this.equipeCasa = equipeCasa;
	}

	public Equipe getEquipeVisitante() {
		return equipeVisitante;
	}

	public void setEquipeVisitante(Equipe equipeVisitante) {
		this.equipeVisitante = equipeVisitante;
	}

	public Integer getPlacarEquipeCasa() {
		return placarEquipeCasa;
	}

	public void setPlacarEquipeCasa(Integer placarEquipeCasa) {
		this.placarEquipeCasa = placarEquipeCasa;
	}

	public Integer getPlacarEquipeVisitante() {
		return placarEquipeVisitante;
	}

	public void setPlacarEquipeVisitante(Integer placarEquipeVisitante) {
		this.placarEquipeVisitante = placarEquipeVisitante;
	}

	public String getGolsEquipeCasa() {
		return golsEquipeCasa;
	}

	public void setGolsEquipeCasa(String golsEquipeCasa) {
		this.golsEquipeCasa = golsEquipeCasa;
	}

	public String getGolsEquipeVisitante() {
		return golsEquipeVisitante;
	}

	public void setGolsEquipeVisitante(String golsEquipeVisitante) {
		this.golsEquipeVisitante = golsEquipeVisitante;
	}

	public Integer getPlacarEstendidoEquipeCasa() {
		return placarEstendidoEquipeCasa;
	}

	public void setPlacarEstendidoEquipeCasa(Integer placarEstendidoEquipeCasa) {
		this.placarEstendidoEquipeCasa = placarEstendidoEquipeCasa;
	}

	public Integer getPlacarEstendidoEquipeVisitante() {
		return placarEstendidoEquipeVisitante;
	}

	public void setPlacarEstendidoEquipeVisitante(Integer placarEstendidoEquipeVisitante) {
		this.placarEstendidoEquipeVisitante = placarEstendidoEquipeVisitante;
	}

	public Date getDataHoraPartida() {
		return dataHoraPartida;
	}

	public void setDataHoraPartida(Date dataHoraPartida) {
		this.dataHoraPartida = dataHoraPartida;
	}

	public String getLocalPartida() {
		return localPartida;
	}

	public void setLocalPartida(String localPartida) {
		this.localPartida = localPartida;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Partida other = (Partida) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
