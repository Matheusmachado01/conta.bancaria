package com.matheus.banco.model;

import java.util.Objects;

public class Conta {

  private Pessoa titular;
  private int agencia;
  private int numero;
  private double saldo;

    Conta() {
    }

   public Conta(Pessoa titular, int agencia, int numero){ // sem o modificador public neste construtor, o construtor não pode ser executado em outro pacote como o app.
        Objects.requireNonNull(titular); // Esta classe cria uma excessão caso esteja nulo o que foi passado como argumento.
        this.titular = titular;
        this.agencia = agencia;
        this.numero = numero;
    }

    public void depositar(double valor) {
        if (valor <= 0){
            throw new IllegalStateException("Valor deve ser maior que 0");
        }
        saldo = saldo + valor;
    }

       public void sacar(double valor){ // sem o modificador public neste método, o metódo não pode ser executado em outro pacote como o app.
            if (valor <= 0) {
                throw new IllegalStateException("Valor deve ser maior que 0");
            }
            if (getSaldoDisponivel() - valor < 0) {
                throw new IllegalStateException("Saldo insuficiente");// excessão para tentar novamente um valor correto
            }
            saldo = saldo - valor;
        }
       public void sacar(double valor, double taxaSaque){
        sacar(valor + taxaSaque);
        }

    public Pessoa getTitular() {
        return titular;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getSaldoDisponivel(){
       return getSaldo();
    }
}
