package com.algaworks.algalog.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algalog.api.mapper.ClienteMapper;
import com.algaworks.algalog.api.model.ClienteDTO;
import com.algaworks.algalog.api.model.input.ClienteInput;
import com.algaworks.algalog.domain.model.Cliente;
import com.algaworks.algalog.domain.repository.ClienteRepository;
import com.algaworks.algalog.domain.service.CatalogoClienteService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/clientes")
public class ClienteController {

	private CatalogoClienteService catalogoClienteService;
	private ClienteRepository clienteRepository;
	private ClienteMapper clienteMapper;
	
	@GetMapping
	public List<ClienteDTO> findAll() {
		return clienteMapper.toCollectionDTO(clienteRepository.findAll());
	}
	
	@GetMapping("/{clienteId}")
	public ResponseEntity<ClienteDTO> findById(@PathVariable Long clienteId) {
		return clienteRepository.findById(clienteId)
				.map(cliente -> ResponseEntity.ok(clienteMapper.toDTO(cliente)))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ClienteDTO addCliente(@Valid @RequestBody ClienteInput clienteInput) {
		Cliente newCliente = clienteMapper.toEntity(clienteInput);
		Cliente addCliente = catalogoClienteService.save(newCliente);
		return clienteMapper.toDTO(addCliente);
	}
	
	@PutMapping("/{clienteId}")
	public ResponseEntity<ClienteDTO> updateCliente(@PathVariable Long clienteId, 
			@Valid @RequestBody ClienteInput clienteInput) {
		Cliente newCliente = clienteMapper.toEntity(clienteInput);
		return catalogoClienteService.updateCliente(clienteId, newCliente);
	}
	
	@DeleteMapping("/{clienteId}")
	public ResponseEntity<Void> removeCliente(@PathVariable Long clienteId) {
		return catalogoClienteService.removeCliente(clienteId);
	}
}
