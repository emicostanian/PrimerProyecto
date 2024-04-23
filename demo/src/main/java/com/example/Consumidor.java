package com.example;

class Consumidor implements Runnable {
    private Buffer buffer;

    public Consumidor(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            while (true) {
                buffer.extraer();
                Thread.sleep(2000); // Simula un proceso de consumo
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}