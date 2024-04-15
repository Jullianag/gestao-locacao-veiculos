package com.meusprojetos.locacao.controllers;

import com.meusprojetos.locacao.dto.LocacaoDTO;
import com.meusprojetos.locacao.dto.UsuarioDTO;
import com.meusprojetos.locacao.entities.Locacao;
import com.meusprojetos.locacao.services.LocacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/locacoes")
public class LocacaoController {

    @Autowired
    private LocacaoService service;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping(value = "/{id}")
    public ResponseEntity<LocacaoDTO> findById(@PathVariable Long id) {
         LocacaoDTO dto = service.findById(id);
         return ResponseEntity.ok(dto);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping
    public ResponseEntity<Page<LocacaoDTO>> findAll(
            @RequestParam(name = "name", defaultValue = "") String nome,
            Pageable pageable) {
        Page<LocacaoDTO> dto = service.findAll(nome, pageable);
        return ResponseEntity.ok(dto);
    }
}
