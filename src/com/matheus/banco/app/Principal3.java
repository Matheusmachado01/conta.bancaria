package com.matheus.banco.app;

import com.matheus.banco.model.Banco;
import com.matheus.banco.model.Conta;

import java.util.Comparator;

public class Principal3 {

    public static void main(String[] args) {

        Banco banco = new Banco();


        banco.getContas().sort(Comparator.comparingInt(new NumeroContaFunction()));

        for (Conta conta : banco.getContas()){
            System.out.println(conta.getAgencia() + "/" + conta.getNumero());
        }
    }
}
