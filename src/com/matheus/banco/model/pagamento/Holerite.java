package com.matheus.banco.model.pagamento;

import com.matheus.banco.model.Pessoa;

public class Holerite implements DocumentoPagavel {

    private Pessoa funcionario;
    private double valorHora;
    private int quatidadeHoras;
    private boolean pago;

    public Holerite(Pessoa funcionario, double valorHora, int quatidadeHoras) {
        this.funcionario = funcionario;
        this.valorHora = valorHora;
        this.quatidadeHoras = quatidadeHoras;
    }

    @Override
    public double getValorTotal() {
        return valorHora * quatidadeHoras;
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
