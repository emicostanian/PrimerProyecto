package com.example;

public class Main {
    public static void main(String[] args) {
        Buffer buffer = new Buffer(5); // Buffer con capacidad para 5 elementos

        // Crear hilos de productor y consumidor
        Thread productorThread = new Thread(new Productor(buffer));
        Thread consumidorThread = new Thread(new Consumidor(buffer));

        // Iniciar hilos
        productorThread.start();
        consumidorThread.start();
    }
}
// Prueba