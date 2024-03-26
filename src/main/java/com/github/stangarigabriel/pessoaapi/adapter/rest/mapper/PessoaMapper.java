package com.github.stangarigabriel.pessoaapi.adapter.rest.mapper;

import com.github.stangarigabriel.pessoaapi.adapter.rest.dto.request.PessoaRequest;
import com.github.stangarigabriel.pessoaapi.adapter.rest.dto.response.PessoaResponse;
import com.github.stangarigabriel.pessoaapi.domain.entities.PessoaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PessoaMapper {

    PessoaResponse entityToResponse(PessoaEntity pessoaEntity);
    PessoaEntity requestToEntity(PessoaRequest pessoaRequest);
}
