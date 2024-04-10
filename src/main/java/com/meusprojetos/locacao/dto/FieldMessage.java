package com.meusprojetos.locacao.dto;

public class FieldMessage {

    private String FieldName;
    private String message;

    public FieldMessage(String fieldName, String message) {
        FieldName = fieldName;
        this.message = message;
    }

    public String getFieldName() {
        return FieldName;
    }

    public String getMessage() {
        return message;
    }
}
