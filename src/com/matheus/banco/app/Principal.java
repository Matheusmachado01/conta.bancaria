package com.matheus.banco.app;

import com.matheus.banco.model.*;
import com.matheus.banco.model.atm.CaixaEletronico;
import com.matheus.banco.model.excecao.SaldoInsuficienteException;
import com.matheus.banco.model.pagamento.Boleto;
import com.matheus.banco.model.pagamento.DocumentoEstornavel;
import com.matheus.banco.model.pagamento.DocumentoPagavel;
import com.matheus.banco.model.pagamento.Holerite;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Principal {

    public static void main(String[] args) {

        Pessoa titular1 = new Pessoa();
        titular1.setNome("João da Silva");
        titular1.setDocumento("6103643575");
        titular1.setRendimentoAnual(new BigDecimal("15000"));
        titular1.setTipo(TipoPessoa.JURIDICA);
        //System.out.println(titular1.getTipo());

        titular1.setDataUltimaAtualizacao(LocalDateTime.parse("2023-10-08T17:25:00"));
        System.out.println(titular1.getDataUltimaAtualizacao());

        Pessoa titular2 = new Pessoa();
        titular2.setNome("Maria Abadia");
        titular2.setDocumento("6103643572");

        CaixaEletronico caixaEletronico = new CaixaEletronico();

        ContaIvestimento minhaConta = new ContaIvestimento(titular1, 123, 987);
        ContaEspecial suaConta = new ContaEspecial(titular2, 333, 987, new BigDecimal("1000"));

        try {
            minhaConta.depositar(new BigDecimal("30000"));
            minhaConta.sacar(new BigDecimal("1000"));
            // minhaConta.creditarRendimentos(0.8);
            // minhaConta.debitarTarifaMensal();

            suaConta.depositar(new BigDecimal("15000"));
            suaConta.sacar(new BigDecimal("15500"));
            suaConta.debitarTarifaMensal();

            DocumentoPagavel boletoEscola = new Boleto(titular2, new BigDecimal("35000"));
            Holerite salarioFuncionario = new Holerite(titular2, new BigDecimal("100"), 160);

            caixaEletronico.pagar(boletoEscola, minhaConta);
            caixaEletronico.pagar(salarioFuncionario, minhaConta);

            caixaEletronico.estornarPagamento((DocumentoEstornavel) boletoEscola, minhaConta);

            boletoEscola.imprimirrecibo();
            salarioFuncionario.imprimirrecibo();
        } catch (SaldoInsuficienteException e){
            System.out.println("Erro ao executar operação na conta: " + e.getMessage());
        }
    //    System.out.println("Boleto pago: " + boletoEscola.estaPago());
    //    System.out.println("Salário pago: " + salarioFuncionario.estaPago());

        caixaEletronico.imprimirSaldo(minhaConta);
        System.out.println();
        caixaEletronico.imprimirSaldo(suaConta);

    }
 // 01:25
}
