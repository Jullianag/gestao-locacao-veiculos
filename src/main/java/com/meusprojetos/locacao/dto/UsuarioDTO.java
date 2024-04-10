package com.meusprojetos.locacao.dto;

import com.meusprojetos.locacao.entities.Role;
import com.meusprojetos.locacao.entities.Usuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.security.core.GrantedAuthority;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDTO {

    private Long id;
    @Size(min = 3, max = 80, message = "O nome deve conter de 3 a 80 caracteres")
    @NotBlank(message = "Campo obrigatório")
    private String nome;
    private String email;
    @NotNull(message = "O telefone não pode ser nulo")
    private String telefone;
    private LocalDate dataNasc;
    @Size(min = 10, message = "Endereço deve conter no mínimo 10 caracteres")
    @NotBlank(message = "Campo obrigatório")
    private String endereco;

    private List<String> roles = new ArrayList<>();

    public UsuarioDTO(Long id, String nome, String email, String telefone, LocalDate dataNasc, String endereco) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.dataNasc = dataNasc;
        this.endereco = endereco;
    }

    public UsuarioDTO(Usuario entity) {
        id = entity.getId();
        nome = entity.getNome();
        email = entity.getEmail();
        telefone = entity.getTelefone();
        dataNasc = entity.getDataNasc();
        endereco = entity.getEndereco();
        for (GrantedAuthority role : entity.getRoles()) {
            roles.add(role.getAuthority());
        }

    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public LocalDate getDataNasc() {
        return dataNasc;
    }

    public String getEndereco() {
        return endereco;
    }

    public List<String> getRoles() {
        return roles;
    }
}
