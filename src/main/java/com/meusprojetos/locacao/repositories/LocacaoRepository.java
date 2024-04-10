package com.meusprojetos.locacao.repositories;

import com.meusprojetos.locacao.entities.Locacao;
import com.meusprojetos.locacao.entities.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LocacaoRepository extends JpaRepository<Locacao, Long> {

    @Query("SELECT obj FROM Locacao obj " +
            "WHERE UPPER(obj.usuario.nome) LIKE UPPER(CONCAT('%', :name, '%'))")
    Page<Locacao> searchByName(String name, Pageable pageable);
}
