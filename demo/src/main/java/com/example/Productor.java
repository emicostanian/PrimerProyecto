package com.example;

class Productor implements Runnable {
    private Buffer buffer;

    public Productor(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            int item = 1;
            while (true) {
                buffer.insertar(item++);
                Thread.sleep(5000); // Simula un proceso de producción
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}