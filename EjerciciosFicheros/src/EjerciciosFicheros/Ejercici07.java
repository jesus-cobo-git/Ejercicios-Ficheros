package EjerciciosFicheros;

import java.io.*;

public class Ejercici07 {

    String archivoEntrada = "C:/dir1/texto.txt";
    String archivoSalida = "C:/dir1/encriptado.txt";

    public static void main(String[] args) {
        encriptarArchivo("C:/dir1/texto.txt", "C:/dir1/encriptado.txt");
        mostrarArchivo("C:/dir1/encriptado.txt");
    }

    public static void encriptarArchivo(String archivoEntrada, String archivoSalida) {
        try (FileInputStream fis = new FileInputStream(archivoEntrada);
             BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
             FileWriter writer = new FileWriter(archivoSalida)) {

            String line;
            while ((line = reader.readLine()) != null) {
                // encriptar la línea y escribirla en el archivo de salida
                String encriptada = encriptar(line);
                writer.write(encriptada + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void mostrarArchivo(String archivoSalida) {
        try (BufferedReader reader = new BufferedReader(new FileReader(archivoSalida))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static String encriptar(String texto) {

        StringBuilder encriptado = new StringBuilder();
        for (char caracter : texto.toCharArray()) {
            encriptado.append((char) (caracter + 1));
        }
        return encriptado.toString();
    }
}