/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package conexionsql;

import java.sql.*;
import java.util.Scanner;

/**
 *
 * @author FP
 */
public class insercionLibro {

    public static final String url = "jdbc:mysql://localhost:3306/biblioteca";

    public static void visualizarLibros() throws SQLException {
        try (Connection con = DriverManager.getConnection(url, "root", "root"); Statement st = con.createStatement()) {
            Statement sentencia = con.createStatement();

            String selectLibro = "SELECT * FROM libro natural join (autor, editorial, tema)";
            ResultSet sentenciaSelect = sentencia.executeQuery(selectLibro);
            while (sentenciaSelect.next()) {
                System.out.println(sentenciaSelect.getString("ISBN" + " "));
                System.out.println(sentenciaSelect.getString("titulo" + " "));
                System.out.println(sentenciaSelect.getString("numeroEjemplares" + " "));
                System.out.println(sentenciaSelect.getString("nombreAutor" + " "));
                System.out.println(sentenciaSelect.getString("nombreEditorial" + " "));
                System.out.println(sentenciaSelect.getString("direccion" + " "));
                System.out.println(sentenciaSelect.getString("telefono" + " "));
                System.out.println(sentenciaSelect.getString("nombretema"+" "));
                System.out.println("");
                System.out.println("------------------------------");
            }
        } catch (SQLException ex) {
            System.out.println("CONEXION INCORRECTA");
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) throws SQLException {

        Scanner teclado = new Scanner(System.in);

        String user = "root";
        String password = "root";

        try (Connection con = DriverManager.getConnection(url, user, password); Statement st = con.createStatement()) {
            //recogida de datos:LIBRO
            String isbn = "";
            String titulo = "";
            Integer numeroEjemplares = 0;
            String nombreAutor = "";
            String nombreEditorial = "";
            String nombreTema = "";
            //comprobacion de datos:LIBRO
            String selectLibro = "SELECT * FROM libro WHERE isbn = '" + isbn + "'; ";
            ResultSet sentenciaConSelect = st.executeQuery(selectLibro);
            if (sentenciaConSelect.next()) {
                System.out.println("El libro ya existe");
                visualizarLibros();
            } else {
            }
            //inserción de datos
            System.out.println("CONEXION REALIZADA CON EXITO");
        } catch (SQLException ex) {
            System.out.println("CONEXION INCORRECTA");
            System.out.println(ex.getMessage());
        }
    }

}
