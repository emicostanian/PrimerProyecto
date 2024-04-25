package com.example;

import java.util.concurrent.Semaphore;

public class Proceso4 implements Runnable {
    private final Buffer buffer2;
    private final Semaphore semaphore;

    //EL PROCESO 4 ES EL ENCARGADO DE IMPRIMIR
    public Proceso4(Buffer buffer2, Semaphore semaphore) {
        this.buffer2 = buffer2;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire(); // Adquirir un permiso del semáforo
            int elemento = buffer2.extraer(); 
            procesarElemento(elemento); 
            semaphore.release(); // Liberar el permiso del semáforo
            Thread.sleep(100); // Simular una pausa en el consumo
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); 
            System.err.println("Error en Proceso4: " + e.getMessage());
        }
    }

    // Método para procesar el elemento extraído del buffer
    private void procesarElemento(int elemento) {
        System.out.println("Impresora P4: " + elemento);
    }
}
