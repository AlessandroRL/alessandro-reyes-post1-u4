package com.universidad.tienda.cor;

import com.universidad.tienda.modelo.Pedido;

public class DireccionValidador extends ValidadorPedido {

    @Override
    public boolean validar(Pedido pedido) {
        System.out.println("[COR] Verificando direccion de envio...");

        if (!pedido.direccionValida()) {
            System.err.println("  -> RECHAZADO: La direccion de destino no es servible.");
            return false;
        }

        System.out.println("  -> Direccion verificada.");

        if (siguiente != null) {
            return siguiente.validar(pedido);
        }

        return true;
    }
}
