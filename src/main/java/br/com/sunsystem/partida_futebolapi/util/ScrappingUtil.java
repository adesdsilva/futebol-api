package br.com.sunsystem.partida_futebolapi.util;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.sunsystem.partida_futebolapi.dto.PartidaGoogleDTO;

public class ScrappingUtil {

	private static final Logger LOGGER = LoggerFactory.getLogger(ScrappingUtil.class);
	public static final String BASE_URL_GOOGLE = "http://www.google.com/search?q=";
	private static final String COMPLEMENTO_URL_GOOGLE = "&hl=pt-BR";
	
	public static void main(String[] args) {
		String url = BASE_URL_GOOGLE + "brasil+x+colombia" + COMPLEMENTO_URL_GOOGLE;
		ScrappingUtil scrapping = new ScrappingUtil();
		scrapping.obterInfoPartida(url);

	}
	
	public PartidaGoogleDTO obterInfoPartida(String url) {
		PartidaGoogleDTO partida = new PartidaGoogleDTO();
		Document document = null;
		try {
			document = Jsoup.connect(url).get();
			String title = document.title();
			LOGGER.info("Titulo da pagina: {}", title);
			
			StatusPartida statusPartida = obterStatusPartida(document);
			LOGGER.info("Status Partida: {}", statusPartida);
			String tempoPartida = obterTempoPartida(document);
			LOGGER.info("Tempo de partida: {}", tempoPartida);
		} catch (IOException e) {
			LOGGER.error("Erro ao conectar no Google! -> {}", e.getMessage());
		}
		return partida;
	}
	
	public StatusPartida obterStatusPartida(Document document) {
		//situaçoes:
		//1. partida nao iniciada;
		//2. partida iniciada;
		//3. partida encerrada;
		//4. penalidades;
		StatusPartida status = StatusPartida.PARTIDA_NAO_INICIADA;
		boolean isTempoPartida = document.select("div[class=imso_mh__pst-m-stts-l]").isEmpty();
		if(!isTempoPartida) {
			String tempoPartida = document.select("div[class=imso_mh__pst-m-stts-l]").first().text();
			status = StatusPartida.PARTIDA_ENCERRADA;
			
			LOGGER.info(tempoPartida);
		}
		//inspecionar o elemento verificado, pois se a pagina for atualizada, a info de verificaçao pode alterar!
		isTempoPartida = document.select("div[class=imso_mh__pst-m-stts-l-cont]").isEmpty();
		if(!isTempoPartida) {
			String tempoPartida = document.select("div[class=imso_mh__pst-m-stts-l-cont]").first().text();
			status = StatusPartida.PARTIDA_EM_ANDAMENTO;
			if(tempoPartida.contains("Penaltis")) {
				status = StatusPartida.PARTIDA_PENALTIS;
			}
		}
		LOGGER.info(status.toString());
		return status;
	}
	
	public String obterTempoPartida(Document document) {
		String tempoPartida = null;
		boolean isTempoPartida = document.select("div[class=imso_mh__lv-m-stts-cont]").isEmpty();
		if(!isTempoPartida) {
			tempoPartida = document.select("div[class=imso_mh__lv-m-stts-cont]").first().text();
		}
		isTempoPartida = document.select("span[class=imso_mh__ft-mtch imso-medium-font imso_mh__ft-mtch]").isEmpty();
		if(!isTempoPartida) {
			tempoPartida = document.select("span[class=imso_mh__ft-mtch imso-medium-font imso_mh__ft-mtch]").first().text();
		}
		//LOGGER.info(corrigeTempoPartida(tempoPartida));
		return tempoPartida;
	}
	
//	public String corrigeTempoPartida(String tempo) {
//		String tempoPartida = null;
//		if(tempo.contains("'")) {
//			tempo.replace("'", " min");
//		} else {
//			return tempo;
//		}
//		return tempoPartida;
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
