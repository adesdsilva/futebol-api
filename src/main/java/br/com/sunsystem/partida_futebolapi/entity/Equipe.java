package br.com.sunsystem.partida_futebolapi.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "equipe")
public class Equipe implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "equipe_id")
	private Long id;
	
	@Column(name = "nome_equipe")
	private String nomeEquipe;
	
	@Column(name = "url_logo_equipe")
	private String urlLogoEquipe;
	
	public Equipe() {
		
	}

	public Equipe(Long id, String nomeEquipe, String urlLogoEquipe) {
		this.id = id;
		this.nomeEquipe = nomeEquipe;
		this.urlLogoEquipe = urlLogoEquipe;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeEquipe() {
		return nomeEquipe;
	}

	public void setNomeEquipe(String nomeEquipe) {
		this.nomeEquipe = nomeEquipe;
	}

	public String getUrlLogoEquipe() {
		return urlLogoEquipe;
	}

	public void setUrlLogoEquipe(String urlLogoEquipe) {
		this.urlLogoEquipe = urlLogoEquipe;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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
		Equipe other = (Equipe) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
