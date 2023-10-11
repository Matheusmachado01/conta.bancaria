package com.matheus.banco.model.excecao;

public class SaldoInsuficienteException extends RuntimeException{


    public SaldoInsuficienteException(String message) {
        super(message);
    }


}
