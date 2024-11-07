/*Ejercicio 1.-
Hacer un programa que lea el fichero de texto, “texto.txt”, y genere otro llamado
“invertido.txt”, en el que se guardarán las frases del primero pero invertidas.
Mostrar en pantalla el nuevo fichero.
Ejemplo:
texto.txt Esto es un ejemplo
invertido.txt olpmeje nu se otsE*/




package EjerciciosFicheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio1 {

	public static void main(String[] args) throws IOException {

		String inputFile = "E:\\Escritorio\\2DAM\\dir1\\Texto.txt";
		String outputFile = "E:\\Escritorio\\2DAM\\dir1\\invertido.txt";

		BufferedReader reader = new BufferedReader(new FileReader(inputFile)); // Abre el archivo de entrada para
																				// leerlo.
		BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));// Abre el archivo de salida para
																				// escribir en él.

		String line; // Variable para almacenar cada línea leída del archivo original.

		while ((line = reader.readLine()) != null) {

			String reversedLine = new StringBuilder(line).reverse().toString(); // Invertir la línea leída.

			writer.write(reversedLine); // Escribe la línea invertida en el archivo de salida.

			writer.newLine();// Escribe una nueva línea en el archivo para separar las líneas.
		}

		reader.close();
		writer.close();

		// Leer y mostrar el contenido del archivo invertido en consola
		BufferedReader outputReader = new BufferedReader(new FileReader(outputFile));

		while ((line = outputReader.readLine()) != null) {
			System.out.println("Texto invertido: " + line); // Imprimir cada línea del archivo invertido
		}

		outputReader.close();

	}
}
