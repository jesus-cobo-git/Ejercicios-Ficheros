/*Hacer un programa que pida al usuario una palabra por teclado y diga cuántas
veces aparece esa palabra en el fichero "parrafo.txt".
*/

package EjerciciosFicheros;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio5 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        
     
        System.out.println("Introduzca la palabra que desea buscar:");
        String palabraBuscada = scanner.nextLine(); 
        
        // Ruta del archivo donde se buscará la palabra
        String archivo = "E:\\Escritorio\\2DAM\\dir1\\Articulo.txt"; 

        // Inicializar un contador para contar las ocurrencias de la palabra
        int contador = 0; 

       
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea; // Variable para almacenar cada línea leída del archivo
            
            // Leer el archivo línea por línea
            while ((linea = reader.readLine()) != null) {
                // Dividir la línea en palabras utilizando espacios como delimitador
                String[] palabras = linea.split("\\s+"); // Utilizar expresión regular para dividir en palabras
                
                // Contar las ocurrencias de la palabra buscada en la línea actual
                for (String palabra : palabras) {
                    if (palabra.equalsIgnoreCase(palabraBuscada)) { // Comparar ignorando mayúsculas y minúsculas
                        contador++; // Incrementar el contador si se encuentra la palabra
                    }
                }
            }

            // Mostrar el resultado al usuario
            System.out.println("La palabra \"" + palabraBuscada + "\" aparece " + contador + " veces en el archivo.");

        } catch (IOException e) { // Manejar excepciones de entrada/salida
            System.err.println("Error al leer el archivo: " + e.getMessage()); // Mensaje de error si ocurre una excepción
        } finally {
            scanner.close(); // Cerrar el objeto Scanner
        }
    }
}
