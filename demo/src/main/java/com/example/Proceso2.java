package com.example;

public class Proceso2 implements Runnable {
    private final Buffer buffer1;
    private final Buffer buffer2;

    public Proceso2(Buffer buffer1, Buffer buffer2) {
        this.buffer1 = buffer1;
        this.buffer2 = buffer2;
    }

    @Override
    public void run() {
        int count = 0; // Initialize a counter
        while (count < 30) { // End condition for the loop
            int elemento = buffer1.extraer(); // Extract an element from buffer1
            buffer2.insertar(elemento); // Insert the element into buffer2
            buffer1.insertar(elemento); // Return the element to buffer1
            count++; // Increment the counter
        }
    }
}
