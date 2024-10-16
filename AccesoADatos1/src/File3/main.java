/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package File3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author FP
 */
public class main {

    public static void main(String[] args) throws IOException {

        FileReader f = new FileReader("C:\\Users\\FP\\Desktop\\mario.txt");
        BufferedReader texto = new BufferedReader(f);
        String parrafo;
        String letra;
        String parrafosin;
        int caracteressin = 0;
        int contador = 0;
        int longitudcon = 0;
        double lineasD = 0.0;        
        int caracteres = 0;

        while ((parrafo = texto.readLine()) != null) {
            System.out.println(parrafo);
            contador = contador + 1;
            longitudcon = longitudcon + parrafo.length();
            parrafosin = parrafo;
            parrafosin = parrafosin.replace(" ", "");
            caracteressin += parrafosin.length();
        }
        lineasD = caracteres/95;
        System.out.println("El número de lineas totales es: " + contador);
        System.out.println("El número de caracteres total es: " + longitudcon);
        System.out.println("El número de caracteres totales sin espacios es de: " + caracteressin);

    }
}
