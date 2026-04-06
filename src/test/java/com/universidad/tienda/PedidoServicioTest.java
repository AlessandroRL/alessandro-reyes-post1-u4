package com.universidad.tienda;

import com.universidad.tienda.modelo.Pedido;
import com.universidad.tienda.cor.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PedidoServicioTest {

    @Test
    void testCadenaFallaPorStock() {
        Pedido pedidoSinStock = new Pedido("P001", 100.0, 0, true);
        ValidadorPedido validador = new StockValidador();

        assertFalse(validador.validar(pedidoSinStock), "Deberia fallar cuando el stock es 0");
    }

    @Test
    void testCadenaFallaPorMontoExcedido() {
        Pedido pedidoCaro = new Pedido("P002", 6000.0, 10, true);
        ValidadorPedido stock = new StockValidador();
        stock.setSiguiente(new CreditoValidador());

        assertFalse(stock.validar(pedidoCaro), "Deberia fallar cuando el monto > 5000");
    }

    @Test
    void testCadenaExitosa() {
        Pedido pedidoOk = new Pedido("P003", 200.0, 5, true);
        ValidadorPedido stock = new StockValidador();
        stock.setSiguiente(new CreditoValidador());
        stock.setSiguiente(new DireccionValidador());

        assertTrue(stock.validar(pedidoOk), "El pedido deberia pasar todas las validaciones");
    }
}
