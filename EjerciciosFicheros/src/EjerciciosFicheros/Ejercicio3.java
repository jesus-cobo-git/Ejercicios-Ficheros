/*Ejercicio 3.-
Realizar un programa que cuente el número de líneas, caracteres y palabras que
tiene un fichero que se pasará por teclado.
Se debe comprobar que el fichero existe antes de empezar a contar.*/


package EjerciciosFicheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {
		
			Scanner scanner = new Scanner (System.in);
			
			System.out.println("Introduzca la ruta del fichero");
			String filePath = scanner.nextLine(); // Leer la ruta del archivo introducida por el usuario
			
			 // Verificar si el archivo existe
	        File file = new File(filePath); // Crear un objeto File con la ruta proporcionada
	        if (!file.exists()) { // Comprobar si el archivo no existe
	            System.out.println("El archivo no existe."); // Mostrar un mensaje de error
	            return; // Terminar el programa
	        }
	        
	        // Inicializar contadores de líneas, palabras y caracteres
	        
	        int lineCount = 0; // Contador de líneas
	        int wordCount = 0; // Contador de palabras
	        int charCount = 0; // Contador de caracteres
	        
	        try (BufferedReader reader= new BufferedReader(new FileReader(file))) {
	        	String line;
	        	
	    
				while((line = reader.readLine()) != null) {
	        		lineCount ++;
	        		charCount += line.length();

	                // Dividir la línea en palabras usando espacios como delimitador y contar
	                String[] words = line.split("\\s+"); // Dividir la línea en palabras utilizando expresión regular para espacios
	                wordCount += words.length; // Aumentar el contador de palabras con la cantidad de palabras en la línea
	            }

	            // Mostrar los resultados al usuario
	            System.out.println("Número de líneas: " + lineCount); // Mostrar el total de líneas
	            System.out.println("Número de palabras: " + wordCount); // Mostrar el total de palabras
	            System.out.println("Número de caracteres: " + charCount); // Mostrar el total de caracteres

	        } catch (IOException e) { // Manejar excepciones de entrada/salida
	            System.err.println("Error al leer el archivo: " + e.getMessage()); // Mostrar un mensaje de error si ocurre una excepción
	        } finally {
	            scanner.close(); // Cerrar el objeto Scanner
	        }
	    }
	        		
	        		
	        	
	        
			
		
	

}
