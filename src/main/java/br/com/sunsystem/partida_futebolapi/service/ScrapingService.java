package br.com.sunsystem.partida_futebolapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sunsystem.partida_futebolapi.dto.PartidaGoogleDTO;
import br.com.sunsystem.partida_futebolapi.entity.Partida;
import br.com.sunsystem.partida_futebolapi.util.ScrapingUtil;
import br.com.sunsystem.partida_futebolapi.util.StatusPartida;

@Service
public class ScrapingService {
	
	@Autowired
	private ScrapingUtil scrapingUtil;
	
	@Autowired
	private PartidaService partidaService;
	
	public void verificaPartidasPeriodo() {
		Integer qntPartidas = partidaService.buscarQuantidadePartidasPeriodo();
		if(qntPartidas > 0) {
			List<Partida> partidas = partidaService.listarPartidasPeriodo();
			partidas.forEach(partida -> {
				String urlPartida = scrapingUtil.montaUrlGoogle(
						partida.getEquipeCasa().getNomeEquipe(), 
						partida.getEquipeVisitante().getNomeEquipe());
				
				PartidaGoogleDTO googleDTO = scrapingUtil.obtemInformacoesGoogle(urlPartida);
				if (googleDTO.getStatusPartida() != StatusPartida.PARTIDA_NAO_INICIADA) {
					partidaService.atualizaPartida(partida, googleDTO);
				}
				
			});
		}
	}

}
