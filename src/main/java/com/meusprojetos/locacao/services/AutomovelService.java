package com.meusprojetos.locacao.services;

import com.meusprojetos.locacao.dto.AutomovelDTO;
import com.meusprojetos.locacao.entities.Automovel;
import com.meusprojetos.locacao.entities.AutomovelStatus;
import com.meusprojetos.locacao.repositories.AutomovelRespository;
import com.meusprojetos.locacao.services.exceptions.DatabaseException;
import com.meusprojetos.locacao.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AutomovelService {

    @Autowired
    private AutomovelRespository repository;

    @Transactional(readOnly = true)
    public AutomovelDTO findById(Long id) {
        Automovel automovel = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Id não encontrado")
        );
        return new AutomovelDTO(automovel);
    }

    @Transactional(readOnly = true)
    public Page<AutomovelDTO> findAll(Pageable pageable) {
        Page<Automovel> result = repository.findAll(pageable);
        return result.map(x -> new AutomovelDTO(x));
    }

    @Transactional
    public AutomovelDTO insert(AutomovelDTO dto) {
        Automovel entity = new Automovel();
        copyDtoEntity(dto, entity);
        entity = repository.save(entity);
        return new AutomovelDTO(entity);
    }

    @Transactional
    public AutomovelDTO update(Long id, AutomovelDTO dto) {
        try {
            Automovel entity = repository.getReferenceById(id);
            copyDtoEntity(dto, entity);
            entity = repository.save(entity);
            return new AutomovelDTO(entity);
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

    private void copyDtoEntity(AutomovelDTO dto, Automovel entity) {
        entity.setAno(dto.getAno());
        entity.setNumeroPlaca(dto.getNumeroPlaca());
        entity.setNumeroPortas(dto.getNumeroPortas());
        entity.setCor(dto.getCor());
        entity.setMarca(dto.getMarca());
        entity.setTipoCombustivel(dto.getTipoCombustivel());
        entity.setStatus(AutomovelStatus.DISPONIVEL);
    }
}
