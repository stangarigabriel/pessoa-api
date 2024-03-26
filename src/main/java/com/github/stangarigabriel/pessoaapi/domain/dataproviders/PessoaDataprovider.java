package com.github.stangarigabriel.pessoaapi.domain.dataproviders;

import com.github.stangarigabriel.pessoaapi.domain.entities.PessoaEntity;

import java.util.List;
import java.util.Optional;

public interface PessoaDataprovider {
    List<PessoaEntity> buscarTodos();
    Optional<PessoaEntity> buscarPorId(Long id);
    void salvar(PessoaEntity pessoaEntity);
    void deletarPorId(Long id);
}
