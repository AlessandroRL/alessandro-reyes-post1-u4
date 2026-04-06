package com.universidad.tienda.command;

import org.springframework.stereotype.Component;
import java.util.ArrayDeque;
import java.util.Deque;

@Component
public class GestorComandos {

    private final Deque<Command> historial = new ArrayDeque<>();

    public void ejecutarComando(Command comando) {
        comando.ejecutar();
        historial.push(comando);
    }

    public void deshacerUltimo() {
        if (historial.isEmpty()) {
            System.out.println("[GESTOR] No hay acciones para deshacer.");
            return;
        }

        Command ultimo = historial.pop();
        System.out.println("[GESTOR] Revirtiendo accion: " + ultimo.getInfo());
        ultimo.deshacer();
    }
}
