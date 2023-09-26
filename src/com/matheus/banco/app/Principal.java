package com.matheus.banco.app;

import com.matheus.banco.model.*;

public class Principal {

    public static void main(String[] args) {

        Pessoa titular1 = new Pessoa();
        titular1.setNome("João da Silva");
        titular1.setDocumento("6103643571");

        Pessoa titular2 = new Pessoa();
        titular2.setNome("Maria Abadia");
        titular2.setDocumento("6103643572");

        CaixaEletronico caixaEletronico = new CaixaEletronico();

        ContaIvestimento minhaConta = new ContaIvestimento(titular1, 123, 987);
        ContaEspecial suaConta = new ContaEspecial(titular2, 333, 987, 1000);

        minhaConta.depositar(15_000);
        minhaConta.sacar(1_000);
        minhaConta.creditarRendimentos(0.8);

        suaConta.depositar(15_000);
        suaConta.sacar(15_500);

        caixaEletronico.imprimirSaldo(minhaConta);
        System.out.println();
        caixaEletronico.imprimirSaldo(suaConta);

    }
 //MINUTO 00:30
}
