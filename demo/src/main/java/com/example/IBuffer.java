package com.example;

public interface IBuffer {

    void insertar(int elemento) throws InterruptedException;

    // Método para extraer un elemento del buffer
    int extraer() throws InterruptedException;

    int[] imprimirElementos(); //Imprime los elemnetos del buffer
}
