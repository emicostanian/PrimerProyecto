package com.example;

import java.util.concurrent.Semaphore;
import java.util.Random;

public class Proceso1 implements Runnable {
    private final Buffer buffer1;
    private final Semaphore semaphore;
    private final Random random;

    public Proceso1(Buffer buffer1, Semaphore semaphore) {
        this.buffer1 = buffer1;
        this.semaphore = semaphore;
        this.random = new Random();
    }

    @Override
    public void run() {
        try {
            while (true) { 
                semaphore.acquire(); // Adquirir un permiso del semáforo
                int elemento = generarElemento(); // Generar dinámicamente el valor del elemento
                buffer1.insertar(elemento); // Insertar el elemento en buffer1
                System.out.println("Buffer1");
                buffer1.devolverElementos();
                semaphore.release(); // Liberar el permiso del semáforo
                Thread.sleep(100); // Simular una pausa en la producción
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restore interrupted status
            System.err.println("Error en Proceso1: " + e.getMessage());
        }
    }

    // Método para generar un elememento entero del 1 al 100
    private int generarElemento() {
        return random.nextInt(101); 
    }
}