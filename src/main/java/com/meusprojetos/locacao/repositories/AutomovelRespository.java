package com.meusprojetos.locacao.repositories;

import com.meusprojetos.locacao.entities.Automovel;
import com.meusprojetos.locacao.entities.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AutomovelRespository extends JpaRepository<Automovel, Long> {

}
