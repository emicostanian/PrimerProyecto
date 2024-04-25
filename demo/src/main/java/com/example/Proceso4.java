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
            while (true) { // Loop infinito para seguir consumiendo
                semaphore.acquire(); // Adquirir un permiso del semáforo
                int elemento = buffer2.extraer(); // Extraer un elemento del buffer2
                procesarElemento(elemento); // Procesar el elemento (aquí puedes agregar tu lógica de procesamiento)
                semaphore.release(); // Liberar el permiso del semáforo
                Thread.sleep(100); // Simular una pausa en el consumo
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restore interrupted status
            System.err.println("Error en Proceso4: " + e.getMessage());
        }
    }

    // Método para procesar el elemento extraído del buffer
    private void procesarElemento(int elemento) {
        // Aquí puedes agregar la lógica para procesar el elemento extraído del buffer
        // Por ejemplo, puedes imprimirlo, realizar algún cálculo, enviarlo a otro sistema, etc.
        System.out.println("Elemento consumido: " + elemento);
    }
}
