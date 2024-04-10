package com.meusprojetos.locacao.dto;

import com.meusprojetos.locacao.entities.Automovel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class AutomovelMinDTO {

    private Long id;
    private String numeroPlaca;
    private String marca;

    public AutomovelMinDTO(Automovel entity) {
        id = entity.getId();
        numeroPlaca = entity.getNumeroPlaca();
        marca = entity.getMarca();
    }

    public Long getId() {
        return id;
    }

    public String getNumeroPlaca() {
        return numeroPlaca;
    }

    public String getMarca() {
        return marca;
    }
}
