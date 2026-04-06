package com.universidad.tienda.servicio;

import com.universidad.tienda.command.Command;
import com.universidad.tienda.command.GestorComandos;
import com.universidad.tienda.command.ProcesarPedidoCommand;
import com.universidad.tienda.cor.CreditoValidador;
import com.universidad.tienda.cor.DireccionValidador;
import com.universidad.tienda.cor.StockValidador;
import com.universidad.tienda.modelo.Pedido;
import org.springframework.stereotype.Service;

@Service
public class PedidoServicio {

    private final GestorComandos gestor;

    public PedidoServicio(GestorComandos gestor) {
        this.gestor = gestor;
    }

    public void procesarPedido(Pedido pedido) {
        StockValidador stock = new StockValidador();
        CreditoValidador credito = new CreditoValidador();
        DireccionValidador direccion = new DireccionValidador();

        stock.setSiguiente(credito);
        credito.setSiguiente(direccion);

        System.out.println("--- Iniciando validacion de Pedido " + pedido.id() + " ---");
        if (stock.validar(pedido)) {
            Command comando = new ProcesarPedidoCommand(pedido.id());
            gestor.ejecutarComando(comando);
            System.out.println(">>> Pedido procesado exitosamente.");
        } else {
            System.out.println(">>> El pedido no pudo ser procesado por fallas en la validacion.");
        }
    }

    public void deshacerUltimaAccion() {
        gestor.deshacerUltimo();
    }
}