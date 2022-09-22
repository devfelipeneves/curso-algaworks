package com.algaworks.algalog.api.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.algaworks.algalog.api.model.EntregaDTO;
import com.algaworks.algalog.api.model.input.EntregaInput;
import com.algaworks.algalog.domain.model.Entrega;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class EntregaMapper {

	private ModelMapper modelMapper;
	
	public EntregaDTO toDTO(Entrega entrega) {
		return modelMapper.map(entrega, EntregaDTO.class);
	}
	
	public List<EntregaDTO> toCollectionDTO(List<Entrega> entregas) {
		return entregas.stream()
				.map(this::toDTO)
				.collect(Collectors.toList());
	}
	
	public Entrega toEntity(EntregaInput entregaInputDTO) {
		return modelMapper.map(entregaInputDTO, Entrega.class);
	}
	
}
