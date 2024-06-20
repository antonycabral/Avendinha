package com.avendinha.Exception;

public class CustomException extends RuntimeException {

    // Construtor que recebe uma mensagem de erro
    public CustomException(String message) {
        // Chama o construtor da superclasse (RuntimeException) com a mensagem fornecida
        super(message);
    }
}
