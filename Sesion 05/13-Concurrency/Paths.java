public class X {
    private int lastIdUsed;

    public int getNextId() {
        return ++lastIdUsed;
    }
}

//
/*
Creamos una instancia de X, lastIdUsed = 42 y compartimos la instancia con 2 hilos.
    - El hilo 1 obtiene el valor 43, el hilo 2 obtiene el valor 44, lastIdUsed == 44
    - El hilo 1 obtiene el valor 44, el hilo 2 obtiene el valor 43, lastIdUsed == 44
    - El hilo 1 obtiene el valor 43, el hilo 2 obtiene el valor 43, lastIdUsed == 43


    return ++lastIdUsed == 8 líneas de bytecode ==> 12.870 caminos de ejecución
    Si en lugar de un entero usamos un float    ==> 2.704.156 caminos de ejecución
    Si modificamos el código...
 */

public class X {
    private int lastIdUsed;

    public synchronized void incrementValue() {
        ++lastIdUsed;
    }
}

/*
 En este caso, el número de caminos de ejecución es de 2 en el caso de dos hilos y de N! en el caso de N hilos.
*/