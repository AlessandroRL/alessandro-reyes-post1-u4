package com.universidad.tienda.modelo;

public record Pedido(String id, double monto, int stockDisponible, boolean direccionValida) {}