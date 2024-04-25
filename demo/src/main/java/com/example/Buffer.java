package com.example;

class Buffer {
    private int[] buffer;
    private int capacidad;
    private int count;
    private int cabeza; // Índice de inserción
    private int cola; // Índice de extracción

    public Buffer(int capacidad) {
        this.capacidad = capacidad;
        this.buffer = new int[capacidad];
        this.count = 0;
        this.cabeza = 0;
        this.cola = 0;
    }

    //PROCESO 1 (INSERTA ENTEROS)
    public synchronized void insertar(int elemento) throws InterruptedException {
        while (count == capacidad) {
            wait(); // Espera si el buffer está lleno
        }
        buffer[cabeza] = elemento;
        cabeza = (cabeza + 1) % capacidad; // Mueve el índice de inserción
        count++;
        System.out.println("Productor produce: " + elemento);
        notify(); // Notifica a los consumidores que hay datos disponibles
    }

    public synchronized int extraer() throws InterruptedException {
        while (count == 0) {
            wait(); // Espera si el buffer está vacío
        }
        int elemento = buffer[cola];
        cola = (cola + 1) % capacidad; // Mueve el índice de extracción
        count--;
        System.out.println("Consumidor consume: " + elemento);
        notify(); // Notifica a los productores que hay espacio disponible
        return elemento;
        //f
    }

    public synchronized void devolverElementos(){
        for(int i : this.buffer){
            System.out.print(i + " ");
        }
    }
}
