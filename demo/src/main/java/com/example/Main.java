package com.example;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        
        Buffer buffer1 = new Buffer(30); 
        Buffer buffer2 = new Buffer(30); 
        Semaphore semaphore = new Semaphore(30);

        
        Thread proceso1 = new Thread(new Proceso1(buffer1, semaphore)); // Proceso 1 
        Thread proceso2 = new Thread(new Proceso2(buffer1, semaphore)); // Proceso 2
        Thread proceso3 = new Thread(new Proceso3(buffer1, buffer2, semaphore)); // Proceso 3
        Thread proceso4 = new Thread(new Proceso4(buffer2, semaphore)); // Proceso 4 
        
        proceso1.start();
        proceso2.start();
        proceso3.start();
        proceso4.start();

        
    }
}