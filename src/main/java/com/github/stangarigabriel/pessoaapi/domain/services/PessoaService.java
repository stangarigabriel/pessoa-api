package com.github.stangarigabriel.pessoaapi.domain.services;


import com.github.stangarigabriel.pessoaapi.domain.dataproviders.PessoaDataprovider;
import com.github.stangarigabriel.pessoaapi.domain.entities.PessoaEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PessoaService {

    private final PessoaDataprovider pessoaDataprovider;

    public List<PessoaEntity> buscarTodos() {
        return pessoaDataprovider.buscarTodos();
    }

    public PessoaEntity buscarPorId(Long id) {
        return pessoaDataprovider.buscarPorId(id).orElseThrow(
                () -> new RuntimeException(String.format("Pessoa com id %s não encontrada", id)));
    }

    public void salvar(PessoaEntity pessoaEntity) {
        pessoaDataprovider.salvar(pessoaEntity);
    }

    public void deletarPorId(Long id) {
        pessoaDataprovider.deletarPorId(id);
    }
}

