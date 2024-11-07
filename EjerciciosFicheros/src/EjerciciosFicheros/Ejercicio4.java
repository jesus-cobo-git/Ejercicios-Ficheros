/*Ejercicio 4.-
Hacer un programa, que modifique el fichero “texto.txt”, insertando un * delante de
cada vocal.
Mostrar el fichero “texto.txt” resultante.
Ejemplo :
Inicialmente Texto.txt Voy a hacer una prueba
Finalmente Texto.txt V*oy *a h*ac*er *un*a pr*u*eb*a*/

package EjerciciosFicheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio4 {

    public static void main(String[] args) {
        String inputFile = "E:\\Escritorio\\2DAM\\dir1\\Texto.txt"; // Ruta del archivo de entrada

        // Usar StringBuilder fuera del bloque try para almacenar el contenido modificado
        StringBuilder content = new StringBuilder(); 

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) { // Crear un BufferedReader para leer el archivo

            String line; // Variable para almacenar cada línea leída
            // Leer el archivo línea por línea
            while ((line = reader.readLine()) != null) {
                String modifiedLine = modifyLine(line); // Modificar la línea actual
                content.append(modifiedLine).append(System.lineSeparator()); // Añadir la línea modificada al StringBuilder
            }

        } catch (IOException e) { // Manejar excepciones de entrada/salida
            System.err.println("Error al procesar el archivo: " + e.getMessage()); // Mensaje de error si ocurre una excepción
            return; // Terminar el programa si hay un error
        }

        // Escribir el contenido modificado de vuelta en el archivo original
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(inputFile))) { // Crear un BufferedWriter para escribir en el archivo original
            writer.write(content.toString()); // Escribir el contenido modificado en el archivo
        } catch (IOException e) { // Manejar excepciones de entrada/salida
            System.err.println("Error al escribir el archivo: " + e.getMessage()); // Mensaje de error si ocurre una excepción
        }

        // Mostrar el contenido modificado en consola
        System.out.println("Contenido modificado de " + inputFile + ":");
        System.out.println(content.toString()); // Mostrar el contenido modificado en la consola
    }

    // Método para modificar una línea añadiendo un asterisco delante de cada vocal
    private static String modifyLine(String line) {
        return line.replaceAll("([aeiouAEIOU])", "*$1"); // Reemplazar cada vocal por sí misma precedida de un asterisco
    }
}

