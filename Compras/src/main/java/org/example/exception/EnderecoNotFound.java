package org.example.exception;

public class EnderecoNotFound extends RuntimeException{

    public EnderecoNotFound(String message) {
        super(message);
    }
}
