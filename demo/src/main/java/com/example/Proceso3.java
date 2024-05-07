package com.example;

import java.util.concurrent.Semaphore;

public class Proceso3 implements Runnable {
    private final Buffer buffer1;
    private final Buffer buffer2;
    private final Semaphore semaphore;

    public Proceso3(Buffer buffer1, Buffer buffer2, Semaphore semaphore) {
        this.buffer1 = buffer1;
        this.buffer2 = buffer2;
        this.semaphore = semaphore;
    }

    //SUMA X E, Y LOS COLOCA EN B2
    @Override
    public void run() {
        while (true) { // Loop infinito
            try {
                semaphore.acquire(); // Adquirir un permiso del semáforo
                int x = buffer1.extraer();
                int y = buffer1.extraer();
                int resultado = x + y;
                buffer2.insertar(resultado);
                System.out.println("Buffer 2");
                buffer2.devolverElementos();
                semaphore.release(); // Liberar el permiso del semáforo
                System.out.println("Imprimir P3: " + resultado);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Restore interrupted status
                System.err.println("Error en Proceso3: " + e.getMessage());
            }
        }
    }
}