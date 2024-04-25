package com.example;

public class Main {
    public static void main(String[] args) {
        // Crear los dos buffers con sus respectivas capacidades
        Buffer buffer1 = new Buffer(30); // Buffer con capacidad para 30 elementos
        Buffer buffer2 = new Buffer(5); // Buffer con capacidad para 5 elementos

        // Crear e iniciar los hilos de los procesos
        Thread proceso1 = new Thread(new Productor(buffer1)); // Proceso 1 (Productor para buffer1)
        Thread proceso2 = new Thread(new Proceso2(buffer1, buffer2)); // Proceso 2
        Thread proceso3 = new Thread(new Proceso3(buffer1, buffer2)); // Proceso 3
        Thread proceso4 = new Thread(new Consumidor(buffer2)); // Proceso 4 (Consumidor de buffer2)

        proceso1.start();
        proceso2.start();
        proceso3.start();
        proceso4.start();
    }
}