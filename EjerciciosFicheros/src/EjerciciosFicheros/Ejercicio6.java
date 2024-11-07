package EjerciciosFicheros;/*Ejercicio 6.-
Hacer un programa que lea los valores del fichero de texto “numeros.txt” (0 al 9) y
cree el fichero “estadistica.txt”, donde se guarde las frecuencias, la moda (el
número que aparece con mayor frecuencia) y la media.
Ejemplo:
numeros.txt 4 5 2 1 6 2 1 1 3 5 5 9
estadistica.txt Número 0 – 0 veces
Número 1 – 3 veces
................................
Número 9 – 1 vez
Moda: 1 y 5 Media:3.66
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio6 {
    public static void main(String[] args) {

        try {
            List<Integer> numbers = new ArrayList<>();
            int[] frecuencia = new int[10];
            BufferedReader reader = new BufferedReader(new FileReader("C:/dir1/numeros.txt"));
            String line = reader.readLine();
            String[] numbersStr = line.split(" ");
            for (String numStr : numbersStr) {
                int number = Integer.parseInt(numStr);
                numbers.add(number);
                frecuencia[number]++;
            }
            reader.close();

            int maxFrecuencia = 0;
            int moda = 0;
            double sum = 0;
            for (int i = 0; i < frecuencia.length; i++) {
                sum += i * frecuencia[i];
                if (frecuencia[i] > maxFrecuencia) {
                    maxFrecuencia = frecuencia[i];
                    moda = i;
                }
            }
            double media = sum / numbers.size();
            PrintWriter writer = new PrintWriter("C:/dir1/estadisticas.txt");
            for (int i = 0; i < frecuencia.length; i++) {
                writer.println("Numero " + i + " - " + frecuencia[i] + " veces");
            }
            writer.println("Moda: " + moda + " y Media: " + media);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}