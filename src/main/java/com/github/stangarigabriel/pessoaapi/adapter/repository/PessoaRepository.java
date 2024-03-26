package com.github.stangarigabriel.pessoaapi.adapter.repository;

import com.github.stangarigabriel.pessoaapi.domain.entities.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity, Long> {
}
