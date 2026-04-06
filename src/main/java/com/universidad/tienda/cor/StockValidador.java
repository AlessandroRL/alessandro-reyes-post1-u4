package com.universidad.tienda.cor;

import com.universidad.tienda.modelo.Pedido;

public class StockValidador extends ValidadorPedido {

    @Override
    public boolean validar(Pedido pedido) {
        System.out.println("[COR] Revisando disponibilidad de stock para el pedido: " + pedido.id());

        if (pedido.stockDisponible() <= 0) {
            System.err.println("  -> RECHAZADO: No hay existencias del producto.");
            return false;
        }

        System.out.println("  -> Stock confirmado.");

        if (siguiente != null) {
            return siguiente.validar(pedido);
        }

        return true;
    }
}
