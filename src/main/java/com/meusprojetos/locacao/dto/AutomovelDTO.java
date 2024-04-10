package com.meusprojetos.locacao.dto;

import com.meusprojetos.locacao.entities.Automovel;
import com.meusprojetos.locacao.entities.AutomovelStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class AutomovelDTO {

    private Long id;
    @Size(min = 7, message = "A placa deve conter 7 caracteres")
    @NotBlank(message = "Campo obrigatório")
    private String numeroPlaca;
    @NotBlank(message = "Campo obrigatório")
    private String cor;
    @NotNull(message = "Ano não pode ser nulo")
    @Positive(message = "Ano não pode ser negativo")
    private Integer ano;
    @NotBlank(message = "Campo obrigatório")
    private String tipoCombustivel;
    @NotNull(message = "Número de portas não pode ser nulo")
    private Integer numeroPortas;
    @NotBlank(message = "Campo obrigatório")
    private String marca;

    private AutomovelStatus status;

    public AutomovelDTO(Long id, String numeroPlaca, String cor, Integer ano, String tipoCombustivel, Integer numeroPortas, String marca, AutomovelStatus status) {
        this.id = id;
        this.numeroPlaca = numeroPlaca;
        this.cor = cor;
        this.ano = ano;
        this.tipoCombustivel = tipoCombustivel;
        this.numeroPortas = numeroPortas;
        this.marca = marca;
        this.status = status;
    }

    public AutomovelDTO(Automovel entity) {
        id = entity.getId();
        numeroPlaca = entity.getNumeroPlaca();
        cor = entity.getCor();
        ano = entity.getAno();
        tipoCombustivel = entity.getTipoCombustivel();
        numeroPortas = entity.getNumeroPortas();
        marca = entity.getMarca();
        status = entity.getStatus();
    }

    public Long getId() {
        return id;
    }

    public String getNumeroPlaca() {
        return numeroPlaca;
    }

    public String getCor() {
        return cor;
    }

    public Integer getAno() {
        return ano;
    }

    public String getTipoCombustivel() {
        return tipoCombustivel;
    }

    public Integer getNumeroPortas() {
        return numeroPortas;
    }

    public String getMarca() {
        return marca;
    }

    public AutomovelStatus getStatus() {
        return status;
    }
}
