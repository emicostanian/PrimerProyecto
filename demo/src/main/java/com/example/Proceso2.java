package com.example;

import java.util.concurrent.Semaphore;

public class Proceso2 implements Runnable {
    private final Buffer buffer1;
    private final Semaphore semaphore;

    public Proceso2(Buffer buffer1, Semaphore semaphore) {
        this.buffer1 = buffer1;
        this.semaphore = semaphore;
    }

    //SACA DE B1, ELEVA AL CUADRADO Y DEVUELVE EL RESULTADO 
    public void run() {
        int count = 0; // Initialize a counter
        try {
            while (count < 30) { // End condition for the loop
                semaphore.acquire(); // Adquirir un permiso del semáforo
                int elemento = buffer1.extraer(); // Extract an element from buffer1
                elemento = (int)Math.pow(elemento, 2);
                buffer1.insertar(elemento); // Return the element to buffer1
                semaphore.release(); // Liberar el permiso del semáforo
                count++; // Increment the counter
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restore interrupted status
            System.err.println("Error en Proceso2: " + e.getMessage());
        }
    }
}
