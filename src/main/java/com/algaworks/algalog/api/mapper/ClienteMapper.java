package com.algaworks.algalog.api.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.algaworks.algalog.api.model.ClienteDTO;
import com.algaworks.algalog.api.model.input.ClienteInput;
import com.algaworks.algalog.domain.model.Cliente;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class ClienteMapper {
private ModelMapper modelMapper;
	
	public ClienteDTO toDTO(Cliente cliente) {
		return modelMapper.map(cliente, ClienteDTO.class);
	}
	
	public List<ClienteDTO> toCollectionDTO(List<Cliente> clientes) {
		return clientes.stream()
				.map(this::toDTO)
				.collect(Collectors.toList());
	}
	
	public Cliente toEntity(ClienteInput clienteInputDTO) {
		return modelMapper.map(clienteInputDTO, Cliente.class);
	}
}
