package com.meusprojetos.locacao.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_automovel")
public class Automovel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numeroPlaca;
    private String cor;
    private Integer ano;
    private String tipoCombustivel;
    private Integer numeroPortas;
    private String marca;

    private AutomovelStatus status;

    @OneToMany(mappedBy = "automovel")
    private List<Locacao> locacoes = new ArrayList<>();

    public Automovel() {
    }

    public Automovel(Long id, String numeroPlaca, String cor, Integer ano, String tipoCombustivel, Integer numeroPortas, String marca, AutomovelStatus status) {
        this.id = id;
        this.numeroPlaca = numeroPlaca;
        this.cor = cor;
        this.ano = ano;
        this.tipoCombustivel = tipoCombustivel;
        this.numeroPortas = numeroPortas;
        this.marca = marca;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroPlaca() {
        return numeroPlaca;
    }

    public void setNumeroPlaca(String numeroPlaca) {
        this.numeroPlaca = numeroPlaca;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public String getTipoCombustivel() {
        return tipoCombustivel;
    }

    public void setTipoCombustivel(String tipoCombustivel) {
        this.tipoCombustivel = tipoCombustivel;
    }

    public Integer getNumeroPortas() {
        return numeroPortas;
    }

    public void setNumeroPortas(Integer numeroPortas) {
        this.numeroPortas = numeroPortas;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public AutomovelStatus getStatus() {
        return status;
    }

    public void setStatus(AutomovelStatus status) {
        this.status = status;
    }

    public List<Locacao> getLocacoes() {
        return locacoes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Automovel automovel = (Automovel) o;

        return Objects.equals(id, automovel.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
