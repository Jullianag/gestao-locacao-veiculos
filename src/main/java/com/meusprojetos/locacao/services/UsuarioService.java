package com.meusprojetos.locacao.services;

import com.meusprojetos.locacao.dto.UsuarioDTO;
import com.meusprojetos.locacao.entities.Role;
import com.meusprojetos.locacao.entities.Usuario;
import com.meusprojetos.locacao.projections.UserDetailsProjection;
import com.meusprojetos.locacao.repositories.UsuarioRepository;
import com.meusprojetos.locacao.services.exceptions.DatabaseException;
import com.meusprojetos.locacao.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository repository;

    @Transactional(readOnly = true)
    public UsuarioDTO findById(Long id) {
        Usuario usuario = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Id não encontrado")
        );
        return new UsuarioDTO(usuario);
    }

    @Transactional(readOnly = true)
    public Page<UsuarioDTO> findAll(String nome, Pageable pageable) {
        Page<Usuario> result = repository.searchByName(nome, pageable);
        return result.map(x -> new UsuarioDTO(x));
    }

    @Transactional
    public UsuarioDTO insert(UsuarioDTO dto) {
        Usuario entity = new Usuario();
        copyDtoEntity(dto, entity);
        entity = repository.save(entity);
        return new UsuarioDTO(entity);
    }

    @Transactional
    public UsuarioDTO update(Long id, UsuarioDTO dto) {
        try {
            Usuario entity = repository.getReferenceById(id);
            copyDtoEntity(dto, entity);
            entity = repository.save(entity);
            return new UsuarioDTO(entity);
        }
        catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id não encontrado");
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Id não encontrado");
        }
        try {
            repository.deleteById(id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial");
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        List<UserDetailsProjection> result = repository.searchUserAndRolesByEmail(username);

        if (result.size() == 0) {
            throw new UsernameNotFoundException("Usuário não encontrado");
        }

        Usuario usuario = new Usuario();
        usuario.setEmail(username);
        usuario.setPassword(result.get(0).getPassword());

        for (UserDetailsProjection projection : result) {
            usuario.addRole(new Role(projection.getRoleId(), projection.getAuthority()));
        }
        return usuario;
    }

    protected Usuario authenticated() {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            Jwt jwtPrincipal = (Jwt) authentication.getPrincipal();
            String username = jwtPrincipal.getClaim("username");
            return repository.findByEmail(username).get();
        }
        catch (Exception e) {
            throw new UsernameNotFoundException("Email não encontrado");
        }
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CLIENT')")
    @Transactional(readOnly = true)
    public UsuarioDTO getMe() {
        Usuario usuario = authenticated();
        return new UsuarioDTO(usuario);
    }

    private void copyDtoEntity(UsuarioDTO dto, Usuario entity) {
        entity.setNome(dto.getNome());
        entity.setEmail(dto.getEmail());
        entity.setTelefone(dto.getTelefone());
        entity.setDataNasc(dto.getDataNasc());
        entity.setEndereco(dto.getEndereco());
    }

}
