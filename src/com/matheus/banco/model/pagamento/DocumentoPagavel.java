package com.matheus.banco.model.pagamento;

import java.math.BigDecimal;

public interface DocumentoPagavel {

    BigDecimal getValorTotal();
    boolean estaPago();
    void quitarPagamento();

    default void imprimirrecibo() {
        System.out.println("RECIBO");
        System.out.println("Valor Total: " + getValorTotal());
        System.out.println("Pago: " + estaPago());
    }

}
