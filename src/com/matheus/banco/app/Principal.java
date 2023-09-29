package com.matheus.banco.app;

import com.matheus.banco.model.*;
import com.matheus.banco.model.atm.CaixaEletronico;
import com.matheus.banco.model.pagamento.Boleto;
import com.matheus.banco.model.pagamento.DocumentoEstornavel;
import com.matheus.banco.model.pagamento.DocumentoPagavel;
import com.matheus.banco.model.pagamento.Holerite;

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


        minhaConta.depositar(30_000);
        minhaConta.sacar(1_000);
       // minhaConta.creditarRendimentos(0.8);
       // minhaConta.debitarTarifaMensal();

        suaConta.depositar(15_000);
        suaConta.sacar(15_500);
        suaConta.debitarTarifaMensal();

        DocumentoPagavel boletoEscola = new Boleto(titular2, 800);
        Holerite salarioFuncionario = new Holerite(titular2, 100,160);

        caixaEletronico.pagar(boletoEscola, minhaConta);
        caixaEletronico.pagar(salarioFuncionario, minhaConta);

        caixaEletronico.estornarPagamento((DocumentoEstornavel) boletoEscola, minhaConta);

        boletoEscola.imprimirrecibo();
        salarioFuncionario.imprimirrecibo();

    //    System.out.println("Boleto pago: " + boletoEscola.estaPago());
    //    System.out.println("Salário pago: " + salarioFuncionario.estaPago());

        caixaEletronico.imprimirSaldo(minhaConta);
        System.out.println();
        caixaEletronico.imprimirSaldo(suaConta);

    }
 // 01:12
}
