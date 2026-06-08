package me.projects.cnpjtame.exception;

public class InvalidCnpjException extends RuntimeException {
    public InvalidCnpjException(String mensagem) {
        super(mensagem);
    }
}
