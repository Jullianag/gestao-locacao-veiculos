package com.meusprojetos.locacao.dto;

import com.meusprojetos.locacao.entities.Locacao;

import java.time.LocalDate;

public class LocacaoDTO {

    private Long id;
    private LocalDate dataLocacao;
    private LocalDate dataDevolucao;
    private Double valorLocacao;

    private UsuarioMinDTO usuarioAutomovel;

    private AutomovelMinDTO automovelLocado;

    public LocacaoDTO(Long id, LocalDate dataLocacao, LocalDate dataDevolucao, Double valorLocacao, UsuarioMinDTO usuarioAutomovel, AutomovelMinDTO automovelLocado) {
        this.id = id;
        this.dataLocacao = dataLocacao;
        this.dataDevolucao = dataDevolucao;
        this.valorLocacao = valorLocacao;
        this.usuarioAutomovel = usuarioAutomovel;
        this.automovelLocado = automovelLocado;
    }

    public LocacaoDTO(Locacao entity) {
        id = entity.getId();
        dataLocacao = entity.getDataLocacao();
        dataDevolucao = entity.getDataDevolucao();
        valorLocacao = entity.getValorLocacao();
        usuarioAutomovel = new UsuarioMinDTO(entity.getUsuario());
        automovelLocado = new AutomovelMinDTO(entity.getAutomovel());
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDataLocacao() {
        return dataLocacao;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public Double getValorLocacao() {
        return valorLocacao;
    }

    public UsuarioMinDTO getUsuarioAutomovel() {
        return usuarioAutomovel;
    }

    public AutomovelMinDTO getAutomovelLocado() {
        return automovelLocado;
    }
}
