package com.desafio.desafio.exception;

public class RecordFoundException extends RuntimeException {
    
    public RecordFoundException(String documento) {
        super("Já existe um cliente registrado com o documento: " + documento);
    }
}
