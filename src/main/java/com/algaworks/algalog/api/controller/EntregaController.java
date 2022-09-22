package com.algaworks.algalog.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algalog.api.mapper.EntregaMapper;
import com.algaworks.algalog.api.model.EntregaDTO;
import com.algaworks.algalog.api.model.input.EntregaInput;
import com.algaworks.algalog.domain.model.Entrega;
import com.algaworks.algalog.domain.repository.EntregaRepository;
import com.algaworks.algalog.domain.service.SolicitacaoEntregaService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas")
public class EntregaController {

//	private EntregaService entregaService;
	private EntregaRepository entregaRepository;
	private SolicitacaoEntregaService solicitacaoEntregaService;
	private EntregaMapper entregaMapper;
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public EntregaDTO request(@Valid @RequestBody EntregaInput entregaInput) {
		Entrega newEntrega = entregaMapper.toEntity(entregaInput);
		Entrega entregaRequest = solicitacaoEntregaService.request(newEntrega);
		return entregaMapper.toDTO(entregaRequest);
	}
	
//	@GetMapping
//	public List<EntregaDTO> findAll() {
//		return entregaService.findAll();
//	}
	@GetMapping
	public List<EntregaDTO> findAll() {
		return entregaMapper.toCollectionDTO(entregaRepository.findAll());
	}
	
//	@GetMapping("/{entregaId}")
//	public ResponseEntity<EntregaDTO> findById(@PathVariable Long entregaId) {
//		return entregaService.findById(entregaId);
//	}
	@GetMapping("/{entregaId}")
	public ResponseEntity<EntregaDTO> findById(@PathVariable Long entregaId) {
		return entregaRepository.findById(entregaId)
				.map(entrega ->  ResponseEntity.ok(entregaMapper.toDTO(entrega)))
				.orElse(ResponseEntity.notFound().build());
	}
}
