package com.universidad.tienda.cor;

import com.universidad.tienda.modelo.Pedido;

public abstract class ValidadorPedido {
    protected ValidadorPedido siguiente;

    public void setSiguiente(ValidadorPedido siguiente) {
        this.siguiente = siguiente;
    }

    public abstract boolean validar(Pedido pedido);
}
