package com.universidad.tienda.command;

public class ProcesarPedidoCommand implements Command {

    private final String pedidoId;

    public ProcesarPedidoCommand(String pedidoId) {
        this.pedidoId = pedidoId;
    }

    @Override
    public void ejecutar() {
        System.out.println("[COMMAND] -> Ejecutando: Procesamiento de pedido #" + pedidoId);
    }

    @Override
    public void deshacer() {
        System.out.println("[COMMAND] -> Deshaciendo: Cancelacion de pedido #" + pedidoId);
    }

    @Override
    public String getInfo() {
        return "Procesar Pedido " + pedidoId;
    }
}
