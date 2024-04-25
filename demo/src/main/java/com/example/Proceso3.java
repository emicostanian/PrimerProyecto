package com.example;

public class Proceso3 implements Runnable {
    private final Buffer buffer1;
    private final Buffer buffer2;

    public Proceso3(Buffer buffer1, Buffer buffer2) {
        this.buffer1 = buffer1;
        this.buffer2 = buffer2;
    }

    //SUMA X E, Y LOS COLOCA EN B2
    @Override
    public void run() {
        while (true) { // Loop infinito, puede ajustarse según la lógica del proceso
            try {
                // Tomar dos elementos del buffer1
                int x = buffer1.extraer();
                int y = buffer1.extraer();
                // Sumar los elementos (aquí se asume concatenación para simplificar)
                int resultado = x + y;
                // Agregar el resultado al buffer2
                buffer2.insertar(resultado);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Restore interrupted status
                System.err.println("Error en Proceso3: " + e.getMessage());
            }
        }
    }
}
