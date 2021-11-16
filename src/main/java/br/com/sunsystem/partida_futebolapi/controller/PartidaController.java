package br.com.sunsystem.partida_futebolapi.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.sunsystem.partida_futebolapi.dto.PartidaDTO;
import br.com.sunsystem.partida_futebolapi.dto.PartidaResponseDTO;
import br.com.sunsystem.partida_futebolapi.entity.Partida;
import br.com.sunsystem.partida_futebolapi.exceptions.StandardError;
import br.com.sunsystem.partida_futebolapi.service.PartidaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api("api de partidas")
@RestController
@RequestMapping("/api/v1/partidas")
public class PartidaController {

	@Autowired
	private PartidaService partidaService;
	
	@ApiOperation(value = "buscar Partida Por Id")
	@ApiResponses(value = {@ApiResponse(code=200, message="ok", response=Partida.class), 
			@ApiResponse(code=400, message="Bad REquest", response=StandardError.class),
			@ApiResponse(code=401, message="Unauthorized", response=StandardError.class),
			@ApiResponse(code=403, message="Forbbiden", response=StandardError.class),
			@ApiResponse(code=404, message="Not found", response=StandardError.class),
			@ApiResponse(code=500, message="Internal server error", response=StandardError.class),})
	@GetMapping("/{id}")
	public ResponseEntity<Partida> buscarPartidaPorId(@PathVariable("id") Long id) {
		return ResponseEntity.ok().body(partidaService.buscarPartidaPorId(id));
	}
	
	@ApiOperation(value = "Listar Partidas")
	@ApiResponses(value = {@ApiResponse(code=200, message="ok", response=PartidaResponseDTO.class), 
			@ApiResponse(code=400, message="Bad REquest", response=StandardError.class),
			@ApiResponse(code=401, message="Unauthorized", response=StandardError.class),
			@ApiResponse(code=403, message="Forbbiden", response=StandardError.class),
			@ApiResponse(code=404, message="Not found", response=StandardError.class),
			@ApiResponse(code=500, message="Internal server error", response=StandardError.class),})
	@GetMapping
	public ResponseEntity<PartidaResponseDTO> listarPartidas() {
		return ResponseEntity.ok().body(partidaService.listarPartidas());
	}
	
	@ApiOperation(value = "Inserir Partida")
	@ApiResponses(value = {@ApiResponse(code=201, message="created", response=Partida.class), 
			@ApiResponse(code=400, message="Bad REquest", response=StandardError.class),
			@ApiResponse(code=401, message="Unauthorized", response=StandardError.class),
			@ApiResponse(code=403, message="Forbbiden", response=StandardError.class),
			@ApiResponse(code=404, message="Not found", response=StandardError.class),
			@ApiResponse(code=500, message="Internal server error", response=StandardError.class),})
	@PostMapping
	public ResponseEntity<Partida> inserirPartida(@Valid @RequestBody PartidaDTO dto) {
		Partida p = partidaService.inserirPartida(dto);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(p.getId()).toUri();
		return ResponseEntity.created(location).body(p);
		}
	
	@ApiOperation(value = "Alterar Partida")
	@ApiResponses(value = {@ApiResponse(code=204, message="no content", response=Void.class), 
			@ApiResponse(code=400, message="Bad REquest", response=StandardError.class),
			@ApiResponse(code=401, message="Unauthorized", response=StandardError.class),
			@ApiResponse(code=403, message="Forbbiden", response=StandardError.class),
			@ApiResponse(code=404, message="Not found", response=StandardError.class),
			@ApiResponse(code=500, message="Internal server error", response=StandardError.class),})
	@PutMapping("/{id}")
	public ResponseEntity<Void> alterarPartida(@PathVariable("id") Long id, 
			@Valid @RequestBody PartidaDTO dto) {
		partidaService.alterarPartida(id, dto);
		return ResponseEntity.noContent().build();
	}
	
	
	
}
