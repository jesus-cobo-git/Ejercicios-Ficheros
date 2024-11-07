/*Ejercicio n° 2
Escribir un programa Java que permita crear secuencialmente
un fichero binario que contenga la información de varias
personas. Para cada persona se almacenará: nombre, apellido1,
 apellido2 y año de nacimiento. El nombre y los apellidos
 tendrán 20 caracteres rellenando con espacios al final
 para completar la longitud.*/


package EjerciciosBinarios;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ejercicio2 {

    public static void main(String[] args) throws IOException {

        DataOutputStream outputStream = new DataOutputStream (new FileOutputStream("C:/dir1/personas.dat"));
        String [][] personas = {
                {"Juan", "Pérez", "Gonzalez", "1990"},
                {"María", "Martín", "Sánchez", "1995"},
                {"Lucas", "García", "Hernández", "2000"}
        };

        for (String [] persona : personas) {
            String nombre = String.format("%-20s", persona[0]);
            String apellido1 = S
            String apellido2 =
            String añoNacimiento = persona[3];

            outputStream.writeBytes(nombre + "\n");
            outputStream.writeBytes(apellido1 + "\n");
            outputStream.writeBytes(apellido2 + "\n");
            outputStream.writeBytes(añoNacimiento + "\n");
        }

        outputStream.close();
    }
}