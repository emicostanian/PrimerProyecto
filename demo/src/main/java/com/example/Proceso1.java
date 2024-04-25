package com.example;

import java.util.concurrent.Semaphore;

public class Proceso1 implements Runnable {
    private final Buffer buffer1;
    private final Semaphore semaphore;

    public Proceso1(Buffer buffer1, Semaphore semaphore) {
        this.buffer1 = buffer1;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            while (true) { // Loop infinito para seguir produciendo
                semaphore.acquire(); // Adquirir un permiso del semáforo
                int elemento = generarElemento(); // Generar dinámicamente el valor del elemento
                buffer1.insertar(elemento); // Insertar el elemento en buffer1
                semaphore.release(); // Liberar el permiso del semáforo
                Thread.sleep(100); // Simular una pausa en la producción
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restore interrupted status
            System.err.println("Error en Proceso1: " + e.getMessage());
        }
    }

    // Método para generar dinámicamente el valor del elemento
    private int generarElemento() {
        // Aquí puedes implementar la lógica para generar el valor del elemento
        // por ejemplo, puedes utilizar un generador de números aleatorios o cualquier
        // otra lógica que se ajuste a tus necesidades.
        // En este ejemplo, simplemente se retorna un valor fijo como ejemplo.
        return 1; // Valor de ejemplo, puedes reemplazarlo con tu lógica de generación de elementos
    }
}

