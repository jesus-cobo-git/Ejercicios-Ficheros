/*Ejercicio 2.-
Realizar un programa que muestre las n primeras líneas del fichero de texto
“texto.txt”. El valor de n se pedirá al usuario y se tendrá en cuenta que puede ser
mayor que el número de filas del fichero.*/


package EjerciciosFicheros;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio2 {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Introduzca el número de líneas a mostrar:");
        
        int n = scanner.nextInt(); // Número de líneas a mostrar
        scanner.nextLine(); // Limpiar el buffer después de leer el entero
        
        String inputFile = "E:\\Escritorio\\2DAM\\dir1\\texto.txt"; // Ruta del archivo

        // Usamos try-with-resources para asegurar el cierre automático de BufferedReader
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line; // Almacena temporalmente cada línea leída
            int lineCount = 0; // Cuenta las líneas leídas
            
            // Leer y mostrar las líneas hasta el límite o el final del archivo
            while ((line = reader.readLine()) != null && lineCount < n) {
                System.out.println(line);
                lineCount++;
            }

            // Si el archivo tiene menos líneas que n, mostramos un mensaje
            if (lineCount < n) {
                System.out.println("El archivo tiene menos de " + n + " líneas.");
            }

        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
