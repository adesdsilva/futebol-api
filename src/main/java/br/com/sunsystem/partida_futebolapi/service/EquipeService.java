package br.com.sunsystem.partida_futebolapi.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sunsystem.partida_futebolapi.dto.EquipeDTO;
import br.com.sunsystem.partida_futebolapi.dto.EquipeResponseDTO;
import br.com.sunsystem.partida_futebolapi.entity.Equipe;
import br.com.sunsystem.partida_futebolapi.exceptions.BadRequestException;
import br.com.sunsystem.partida_futebolapi.exceptions.NotFoundException;
import br.com.sunsystem.partida_futebolapi.repository.EquipeRepository;

@Service
public class EquipeService {

	@Autowired
	private EquipeRepository equipeRepository;

	@Autowired
	private ModelMapper mapper;

	public Equipe buscarEquipeId(Long id) {
		return equipeRepository.findById(id).orElseThrow(
				() -> new NotFoundException("Objeto nao encontrado! Id:" + id + ", Tipo: " + Equipe.class.getName()));
	}
	
	public Equipe buscarEquipePorNome(String nomeEquipe) {
		return equipeRepository.findByNomeEquipe(nomeEquipe)
				.orElseThrow(() -> new NotFoundException("Nenhuma equipe encontrada com o nome!" + nomeEquipe));
	}

	public EquipeResponseDTO listarEquipes() {
		EquipeResponseDTO equipes = new EquipeResponseDTO();
		equipes.setEquipes(equipeRepository.findAll());
		return equipes;
	}

	public Equipe inserirEquipe(EquipeDTO dto) {
		boolean exists = equipeRepository.existsByNomeEquipe(dto.getNomeEquipe());
		if (exists) {
			throw new BadRequestException("Ja existe uma equipe cadastrada com o nome informado!");
		}
		Equipe equipe = mapper.map(dto, Equipe.class);
		return equipeRepository.save(equipe);
	}

	public void alterarEquipe(Long id, EquipeDTO dto) {
		boolean exists = equipeRepository.existsById(id);
		if (!exists) {
			throw new BadRequestException("Nao foi possivel alterar a equipe! Id inexistente");
		}
		Equipe equipe = mapper.map(dto, Equipe.class);
		equipe.setId(id);
		equipeRepository.save(equipe);
	}

}
