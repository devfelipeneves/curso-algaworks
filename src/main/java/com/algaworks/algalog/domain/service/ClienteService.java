package com.algaworks.algalog.domain.service;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ClienteService {

//	private ClienteRepository clienteRepository;
//	
//	public Cliente search(Long clienteId) {
//		return clienteRepository.findById(clienteId)
//				.orElseThrow(() -> new DomainException("Cliente não encontrado"));
//	}
//	
//	@Transactional
//	public List<Cliente> findAll() {
//		return clienteRepository.findAll();
//	}
//	
//	@Transactional
//	public Cliente save(Cliente cliente) {
//		boolean emailInUse = clienteRepository.findByEmail(cliente.getEmail())
//				.stream()
//				.anyMatch(clienteExist -> !clienteExist.equals(cliente));
//		if (emailInUse) {
//			throw new DomainException("Já existe um cliente cadastrado com esse e-mail");
//		}
//		return clienteRepository.save(cliente);
//	}
//	
//	@Transactional
//	public void delete(Long clienteId) {
//		clienteRepository.deleteById(clienteId);
//	}
//	
//	@Transactional
//	public ResponseEntity<Cliente> findById(Long clienteId) {
//		return clienteRepository.findById(clienteId)
//				.map(ResponseEntity::ok)
//				.orElse(ResponseEntity.notFound().build());
//	}
//	
//	@Transactional
//	public ResponseEntity<Cliente> updateCliente(Long clienteId, Cliente cliente) {
//		if(!clienteRepository.existsById(clienteId)) {
//			return ResponseEntity.notFound().build();
//		}
//		
//		cliente.setId(clienteId);
//		cliente = save(cliente);
//		
//		return ResponseEntity.ok(cliente);
//	}
//	
//	@Transactional
//	public ResponseEntity<Void> removeCliente(Long clienteId) {
//		if(!clienteRepository.existsById(clienteId)) {
//			return ResponseEntity.notFound().build();
//		}
//		delete(clienteId);
//		
//		return ResponseEntity.noContent().build();
//	}
}
