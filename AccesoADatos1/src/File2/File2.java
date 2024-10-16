/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package File2;

import java.io.File;

/**
 *
 * @author FP
 */
public class File2 {

    public static void main(String[] args) {

        File f = new File("C:\\Program Files\\Java\\jdk-21\\bin\\java.exe");
        System.out.println("Nombre: " + f.getName());
        System.out.println("Ruta: " + f.getAbsolutePath());
        System.out.println("Directorio padre: " + f.getParent());
        System.out.println("Directorio: " + f.getAbsolutePath());
        System.out.println("-----------------------------------");
        System.out.println("¿ES UN DIRECTORIO?");
        if (f.isDirectory() == false) {
            System.out.println("NO ES UN DIRECTORIO");
        } else {
            System.out.println("ES UN DIRECTORIO");
        }
        System.out.println("¿EXISTE JAVA EN NUESTRO ORDENADOR?");
        if (f.exists() == false) {
            System.out.println("NO EXISTE");
        } else {
            System.out.println("EXISTE");
        }
    }

}
