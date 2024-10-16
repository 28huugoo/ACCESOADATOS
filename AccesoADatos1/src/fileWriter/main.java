/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fileWriter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author FP
 */
public class main {

    public static void main(String[] args) throws IOException {
        Scanner teclado = new Scanner(System.in);

        FileReader leer = new FileReader("carta.txt");
        BufferedReader buffer = new BufferedReader(leer);

        System.out.println("Dime el nombre...");
        String nombre = teclado.nextLine();
        System.out.println("Dime el apellido...");
        String apellido = teclado.nextLine();
        System.out.println("Dime el jefe...");
        String jefe = teclado.nextLine();
        System.out.println("Dime el departamento...");
        String departamento = teclado.nextLine();

        FileWriter escribir = new FileWriter("carta.txt", false);
        BufferedWriter bw = new BufferedWriter(escribir);

        String parrafo;
        while ((parrafo = buffer.readLine()) != null) {

            parrafo = parrafo.replace("$nombre", nombre)
                    .replace("$apellido", apellido)
                    .replace("$jefe", jefe)
                    .replace("$departamento", departamento);

            bw.write(parrafo);
            bw.newLine();
        }

        buffer.close();
        leer.close();
        bw.close();
        escribir.close();

        System.out.println("Carta generada correctamente.");
    }
}
