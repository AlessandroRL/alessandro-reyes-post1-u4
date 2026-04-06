package com.universidad.tienda.command;

public interface Command {
    void ejecutar();
    void deshacer();

    String getInfo();
}