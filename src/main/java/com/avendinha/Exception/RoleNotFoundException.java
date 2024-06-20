package com.avendinha.Exception;

public class RoleNotFoundException extends RuntimeException {

    // Construtor que recebe uma mensagem de erro
    public RoleNotFoundException(String message) {
        // Chama o construtor da superclasse (RuntimeException) com a mensagem fornecida
        super(message);
    }
}