package com.matheus.banco.app;

import com.matheus.banco.model.Conta;

import java.util.function.ToIntFunction;

public class NumeroContaFunction implements ToIntFunction<Conta> {


    @Override
    public int applyAsInt(Conta conta) {
        return conta.getNumero();
    }
}
