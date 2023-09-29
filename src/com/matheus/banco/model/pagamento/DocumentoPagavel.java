package com.matheus.banco.model.pagamento;

public interface DocumentoPagavel {

    double getValorTotal();
    boolean estaPago();
    void quitarPagamento();

    default void imprimirrecibo() {
        System.out.println("RECIBO");
        System.out.println("Valor Total: " + getValorTotal());
        System.out.println("Pago: " + estaPago());
    }

}
