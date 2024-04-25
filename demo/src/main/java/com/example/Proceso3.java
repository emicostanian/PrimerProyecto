public class Proceso3 implements Runnable {
    private final Buffer buffer1;
    private final Buffer buffer2;

    public Proceso3(Buffer buffer1, Buffer buffer2) {
        this.buffer1 = buffer1;
        this.buffer2 = buffer2;
    }

    @Override
    public void run() {
        while (true) { // Loop infinito, puede ajustarse según la lógica del proceso
            // Tomar dos elementos del buffer1
            String x = buffer1.extraer();
            String y = buffer1.extraer();
            // Sumar los elementos (aquí se asume concatenación para simplificar)
            String resultado = x + y;
            // Agregar el resultado al buffer2
            buffer2.insertar(resultado);
        }
    }
}