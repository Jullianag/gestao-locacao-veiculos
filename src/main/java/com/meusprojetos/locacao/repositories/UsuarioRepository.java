package com.meusprojetos.locacao.repositories;

import com.meusprojetos.locacao.entities.Usuario;
import com.meusprojetos.locacao.projections.UserDetailsProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String email);

    @Query("SELECT obj FROM Usuario obj " +
            "WHERE UPPER(obj.nome) LIKE UPPER(CONCAT('%', :name, '%'))")
    Page<Usuario> searchByName(String name, Pageable pageable);

    @Query(nativeQuery = true, value = "SELECT tb_usuario.email AS username, tb_usuario.password, tb_role.id AS roleId, tb_role.authority " +
            "FROM tb_usuario " +
            "INNER JOIN tb_usuario_role ON tb_usuario.id = tb_usuario_role.usuario_id " +
            "INNER JOIN tb_role ON tb_role.id = tb_usuario_role.role_id " +
            "WHERE tb_usuario.email = :email")
    List<UserDetailsProjection> searchUserAndRolesByEmail(String email);
}
