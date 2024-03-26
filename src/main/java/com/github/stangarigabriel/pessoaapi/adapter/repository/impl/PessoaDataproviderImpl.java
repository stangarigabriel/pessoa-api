package com.github.stangarigabriel.pessoaapi.adapter.repository.impl;

import com.github.stangarigabriel.pessoaapi.adapter.repository.PessoaRepository;
import com.github.stangarigabriel.pessoaapi.domain.dataproviders.PessoaDataprovider;
import com.github.stangarigabriel.pessoaapi.domain.entities.PessoaEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PessoaDataproviderImpl implements PessoaDataprovider {

    private final PessoaRepository pessoaRepository;

    @Override
    public List<PessoaEntity> buscarTodos() {
        return pessoaRepository.findAll();
    }

    @Override
    public Optional<PessoaEntity> buscarPorId(Long id) {
        return pessoaRepository.findById(id);
    }

    @Override
    public void salvar(PessoaEntity pessoaEntity) {
        pessoaRepository.save(pessoaEntity);
    }

    @Override
    public void deletarPorId(Long id) {
        pessoaRepository.deleteById(id);
    }
}
