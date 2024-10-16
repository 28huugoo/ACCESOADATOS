/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package File1;

import java.io.File;

/**
 *
 * @author FP
 */
public class File1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File f = new File("WINDOWS\\fortnite.xml");
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
        System.out.println("¿EXISTE EL FICHERO?");
        if (f.exists() == false) {
            System.out.println("EL FICHERO NO EXISTE");
        } else {
            System.out.println("EL FICHERO EXISTE");
        }
    }
}
