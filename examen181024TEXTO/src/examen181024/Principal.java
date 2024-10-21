package examen181024;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Principal {

    private static void procesarLineaConfiguracion(String linea) {
        String[] partes = linea.split("=");
        if (partes.length == 2) {
            String parte1 = partes[0].trim();
            String parte2 = partes[1].trim();
            System.out.println(parte1 + " = " + parte2);
        } else {
        }
    }

    public static void main(String[] args) {
        String archivoConfiguracion = "jail.txt";
        try (BufferedReader lector
                = new BufferedReader(
                        new FileReader(archivoConfiguracion))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                procesarLineaConfiguracion(linea);
            }
        } catch (IOException e) {
            System.err.println("Error..." + e.getMessage());
        }
    }
}
