package com.meusprojetos.locacao.services;

import com.meusprojetos.locacao.dto.LocacaoDTO;
import com.meusprojetos.locacao.dto.UsuarioDTO;
import com.meusprojetos.locacao.entities.Locacao;
import com.meusprojetos.locacao.entities.Usuario;
import com.meusprojetos.locacao.repositories.LocacaoRepository;
import com.meusprojetos.locacao.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LocacaoService {

    @Autowired
    private LocacaoRepository repository;

    @Transactional(readOnly = true)
    public LocacaoDTO findById(Long id) {
        Locacao locacao = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Id da locação não encontrado")
        );
        return new LocacaoDTO(locacao);
    }

    @Transactional(readOnly = true)
    public Page<LocacaoDTO> findAll(String nome, Pageable pageable) {
        Page<Locacao> result = repository.searchByName(nome, pageable);
        return result.map(x -> new LocacaoDTO(x));
    }
}
