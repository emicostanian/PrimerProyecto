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
        try {
            semaphore.acquire(); // Adquirir un permiso del semáforo
            int elemento = buffer1.extraer(); 
            elemento = (int)Math.pow(elemento, 2);
            buffer1.insertar(elemento); 
            System.out.println("buffer 1");
            buffer1.devolverElementos();
            semaphore.release(); // Liberar el permiso del semáforo
            System.out.println("Imprimir P2: " + elemento);
        
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); 
            System.err.println("Error en Proceso2: " + e.getMessage());
        }
    }
}