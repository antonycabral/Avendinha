package com.avendinha.Exception;

public class UserNotFoundException extends RuntimeException {

    // Construtor que recebe uma mensagem de erro
    public UserNotFoundException(String message) {
        // Chama o construtor da superclasse (RuntimeException) com a mensagem fornecida
        super(message);
    }
}