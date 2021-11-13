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
		String url = BASE_URL_GOOGLE + "flamengo+x+palmeiras+27/11/2021" + COMPLEMENTO_URL_GOOGLE;
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
			
			
		} catch (IOException e) {
			LOGGER.error("Erro ao conectar no Google! -> {}", e.getMessage());
		}
		return partida;
	}

}
