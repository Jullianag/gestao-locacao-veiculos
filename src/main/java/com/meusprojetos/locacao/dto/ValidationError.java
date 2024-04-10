package com.meusprojetos.locacao.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends CustomError {

    private List<FieldMessage> erros = new ArrayList<>();

    public ValidationError(Instant moment, Integer status, String error, String path) {
        super(moment, status, error, path);
    }

    public List<FieldMessage> getErros() {
        return erros;
    }

    public void addError(String fieldName, String message) {
        erros.removeIf(x -> x.getFieldName().equals(message));
        erros.add(new FieldMessage(fieldName, message));
    }
}
