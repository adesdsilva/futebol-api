package br.com.sunsystem.partida_futebolapi.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sunsystem.partida_futebolapi.dto.PartidaDTO;
import br.com.sunsystem.partida_futebolapi.dto.PartidaGoogleDTO;
import br.com.sunsystem.partida_futebolapi.dto.PartidaResponseDTO;
import br.com.sunsystem.partida_futebolapi.entity.Partida;
import br.com.sunsystem.partida_futebolapi.exceptions.BadRequestException;
import br.com.sunsystem.partida_futebolapi.exceptions.NotFoundException;
import br.com.sunsystem.partida_futebolapi.repository.PartidaRepository;

@Service
public class PartidaService {
	
	@Autowired
	private PartidaRepository partidaRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private EquipeService equipeService;

	public Partida buscarPartidaPorId(Long id) {
		return partidaRepository.findById(id).orElseThrow(
				() -> new NotFoundException("Objeto nao encontrado! Id:" + id + ", Tipo: " + Partida.class.getName()));
	}

	public PartidaResponseDTO listarPartidas() {
		PartidaResponseDTO partidas = new PartidaResponseDTO();
		partidas.setPartidas(partidaRepository.findAll());
		return partidas;
	}

	public Partida inserirPartida(PartidaDTO dto) {
		Partida p = mapper.map(dto, Partida.class);
		p.setEquipeCasa(equipeService.buscarEquipePorNome(dto.getNomeEquipeCasa()));
		p.setEquipeVisitante(equipeService.buscarEquipePorNome(dto.getNomeEquipeVisitante()));
		return salvarPartida(p);
	}

	private Partida salvarPartida(Partida p) {
		return partidaRepository.save(p); 
	}
	
	public void alterarPartida(Long id, PartidaDTO dto) {
		boolean exists = partidaRepository.existsById(id);
		if (!exists) {
			throw new BadRequestException("Nao foi possivel alterar a partida! Id inexistente");
		}
		Partida partida = buscarPartidaPorId(id);
		partida.setEquipeCasa(equipeService.buscarEquipePorNome(dto.getNomeEquipeCasa()));
		partida.setEquipeVisitante(equipeService.buscarEquipePorNome(dto.getNomeEquipeVisitante()));
		partida.setDataHoraPartida(dto.getDataHoraPartida());
		partida.setLocalPartida(dto.getLocalPartida());
		salvarPartida(partida);
	}

	public Integer buscarQuantidadePartidasPeriodo() {
		return partidaRepository.buscarQuantidadePartidasPeriodo();
	}

	public List<Partida> listarPartidasPeriodo() {
		return partidaRepository.listarPartidasPeriodo();
	}

	public void atualizaPartida(Partida partida, PartidaGoogleDTO googleDTO) {
		partida.setPlacarEquipeCasa(googleDTO.getPlacarEquiqueCasa());
		partida.setPlacarEquipeVisitante(googleDTO.getPlacarEquiqueVisitante());
		partida.setGolsEquipeCasa(googleDTO.getGolsEquipeCasa());
		partida.setGolsEquipeVisitante(googleDTO.getGolsEquipeVisitante());
		partida.setPlacarEstendidoEquipeCasa(googleDTO.getPlacarEstendidoEquipeCasa());
		partida.setPlacarEstendidoEquipeVisitante(googleDTO.getPlacarEstendidoEquipeVisitante());
		partida.setTempoPartida(googleDTO.getTempoPartida());
		salvarPartida(partida);
		
	}

}
