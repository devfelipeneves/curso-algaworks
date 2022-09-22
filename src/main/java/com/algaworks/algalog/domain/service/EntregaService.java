package com.algaworks.algalog.domain.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algalog.api.mapper.EntregaMapper;
import com.algaworks.algalog.api.model.EntregaDTO;
import com.algaworks.algalog.domain.repository.EntregaRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class EntregaService {

	private EntregaRepository entregaRepository;
	private EntregaMapper entregaMapper;
	
	@Transactional
	public List<EntregaDTO> findAll() {
		return entregaMapper.toCollectionDTO(entregaRepository.findAll());
	}
	
	@Transactional
	public ResponseEntity<EntregaDTO> findById(Long entregaId) {
		return entregaRepository.findById(entregaId)
				.map(entrega ->  ResponseEntity.ok(entregaMapper.toDTO(entrega)))
				.orElse(ResponseEntity.notFound().build());
	}
}
