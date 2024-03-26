package com.github.stangarigabriel.pessoaapi.adapter.rest.dto.response;

public record PessoaResponse(
        Long id,
        String name,
        String email,
        String telefone
) {
}
