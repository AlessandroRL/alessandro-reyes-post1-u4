package com.universidad.tienda.cor;

import com.universidad.tienda.modelo.Pedido;

public class CreditoValidador extends ValidadorPedido {

    @Override
    public boolean validar(Pedido pedido) {
        System.out.println("[COR] Validando solvencia para el monto: $" + pedido.monto());

        if (pedido.monto() > 5000) {
            System.err.println("  -> RECHAZADO: El monto excede el limite de credito automatico.");
            return false;
        }

        System.out.println("  -> Credito aprobado.");

        if (siguiente != null) {
            return siguiente.validar(pedido);
        }

        return true;
    }
}
