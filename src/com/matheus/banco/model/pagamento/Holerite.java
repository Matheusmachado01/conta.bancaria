package com.matheus.banco.model.pagamento;

import com.matheus.banco.model.Pessoa;

import java.math.BigDecimal;

public class Holerite implements DocumentoPagavel {

    private Pessoa funcionario;
    private BigDecimal valorHora;
    private int quatidadeHoras;
    private boolean pago;

    public Holerite(Pessoa funcionario, BigDecimal valorHora, int quatidadeHoras) {
        this.funcionario = funcionario;
        this.valorHora = valorHora;
        this.quatidadeHoras = quatidadeHoras;
    }

    @Override
    public BigDecimal getValorTotal() {
        return valorHora.multiply(new BigDecimal(quatidadeHoras));
    }

    @Override
    public boolean estaPago() {
        return pago;
    }

    @Override
    public void quitarPagamento() {
        pago = true;
    }
}
