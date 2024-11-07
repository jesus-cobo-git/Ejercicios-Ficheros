/*Ejercicio n° 1
Escribir un programa Java que realice la copia de un fichero (por ejemplo un fichero imagen).
Se pide al usuario el fichero de entrada y el nombre del fichero de salida.
*/

package EjerciciosBinarios;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class Ejercicio1 {


    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el nombre del fichero de entrada: ");
        String entrada = scanner.nextLine();

        System.out.println("Introduce el nombre del fichero de salida: ");
        String salida = scanner.nextLine();

        Path origen = Paths.get(entrada);
        Path destino = Paths.get(salida);

        try {
            Files.copy(origen, destino, StandardCopyOption.REPLACE_EXISTING);
        } catch (java.io.IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("El fichero se ha copiado correctamente.");
    }

}
