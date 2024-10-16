/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package accesoadatostema2ant;

import java.sql.*;
import com.sun.jdi.connect.spi.Connection;

/**
 *
 * @author FP
 */
public class AccesoADatosTema2ANT {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String cadenaConexion = "jdbc:mysql://localhost:3306/biblioteca";
        try (Connection con = DriverManager.getConnection("root", "root", "fp.2023")){

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
