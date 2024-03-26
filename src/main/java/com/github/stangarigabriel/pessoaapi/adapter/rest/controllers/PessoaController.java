package com.github.stangarigabriel.pessoaapi.adapter.rest.controllers;

import com.github.stangarigabriel.pessoaapi.adapter.rest.dto.request.PessoaRequest;
import com.github.stangarigabriel.pessoaapi.adapter.rest.dto.response.PessoaResponse;
import com.github.stangarigabriel.pessoaapi.adapter.rest.mapper.PessoaMapper;
import com.github.stangarigabriel.pessoaapi.domain.services.PessoaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoa")
@RequiredArgsConstructor
public class PessoaController {

    private final PessoaService pessoaService;

    //mappers
    private final PessoaMapper pessoaMapper;

    @GetMapping
    public ResponseEntity<List<PessoaResponse>> buscarTodos() {

        var response = pessoaService.buscarTodos().stream()
                .map(pessoaMapper::entityToResponse).toList();

        return ResponseEntity.ok(response);
    }

    @GetMapping("{id}")
    public ResponseEntity<PessoaResponse> buscarPorId(@PathVariable("id") Long id
    ) {
        var response = pessoaMapper.entityToResponse(pessoaService.buscarPorId(id));

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<Void> salvar(@RequestBody PessoaRequest pessoaRequest) {

        var entity = pessoaMapper.requestToEntity(pessoaRequest);

        pessoaService.salvar(entity);

        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<Void> atualizar(@RequestBody PessoaRequest pessoaRequest) {

        final var entity = pessoaService.buscarPorId(pessoaRequest.id());
        entity.setNome(pessoaRequest.name());
        entity.setEmail(pessoaRequest.email());
        entity.setTelefone(pessoaRequest.telefone());

        pessoaService.salvar(entity);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
        final var entity = pessoaService.buscarPorId(id);
        pessoaService.deletarPorId(entity.getId());
        return ResponseEntity.noContent().build();
    }
}