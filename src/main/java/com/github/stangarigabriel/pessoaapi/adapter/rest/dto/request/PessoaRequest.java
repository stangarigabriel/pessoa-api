package com.github.stangarigabriel.pessoaapi.adapter.rest.dto.request;

public record PessoaRequest(
        Long id,
        String name,
        String email,
        String telefone
) {
}