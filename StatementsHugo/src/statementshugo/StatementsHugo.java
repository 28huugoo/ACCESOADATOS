/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package statementshugo;

import java.sql.*;

public class StatementsHugo {

    private static final String CADENA_CONEXION = "jdbc:mysql://localhost:3306/biblioteca";

    public static void visualizarLibros() {
        try (Connection con = DriverManager.getConnection(CADENA_CONEXION, "root", "root"); Statement sentencia = con.createStatement();) {

            String selectLibro = "select * from libro natural join (autor,editorial,tema);";
            ResultSet sentenciaSelect = sentencia.executeQuery(selectLibro);
            while (sentenciaSelect.next()) {
                System.out.print(sentenciaSelect.getString("ISBN") + " ");
                System.out.print(sentenciaSelect.getString("idLibro") + " ");
                System.out.println(sentenciaSelect.getInt("NumeroEjemplares") + " ");
                System.out.print(sentenciaSelect.getString("idAutor") + " ");
                System.out.println(sentenciaSelect.getString("nombreEditorial") + " ");
                System.out.print(sentenciaSelect.getString("direccion") + " ");
                System.out.print(sentenciaSelect.getString("telefono") + " ");
                System.out.print(sentenciaSelect.getString("nombretema") + " ");
                System.out.println("");
                System.out.println("--------------------------------");
            }

        } catch (SQLException e) {
            System.out.println("Conexión incorrecta");
            System.out.println(e.getMessage());
        }

    }

    public static void main(String[] args) {

        //INSERCIÓN DE UN REGISTRO: libro
        try (Connection con = DriverManager.getConnection(CADENA_CONEXION, "root", "root"); Statement sentencia = con.createStatement(); CallableStatement procedimiento = con.prepareCall("CALL altaEditorial(?,?,?)")) {
            //System.out.println("Conexión correcta");
            //recogida de datos: LIBRO
            String isbn = "1234891";
            String titulo = "";
            Integer numeroEjemplares = 0;
            String nombreAutor = "";
            String nombreEditorial = "";
            String nombreTema = "";

            //comprobación de datos: LIBRO
            String selectLibro = "SELECT * FROM libro WHERE isbn = '" + isbn + "'; ";
            ResultSet sentenciaSelect = sentencia.executeQuery(selectLibro);
            if (sentenciaSelect.next()) {
                System.out.println("El libro ya existe");
                visualizarLibros();

            } else {

                if (!existeAutor(nombreAutor, con)) {
                    altaAutor(nombreAutor, con);
                }
                int idAutor = buscarAutor(nombreAutor, con);

                int idTema = buscarTema(nombreTema, con);
                if (buscarTema(nombreTema, con) == -1) {
                    altaTema(nombreTema, con);
                }

                if (!existeEditorial(nombreEditorial, con)) {
                    procedimiento.setString(1, nombreEditorial);
                    //pedir datos de la editorial
                    String direccion = "Calle Nueva";
                    String telefono = "";
                    procedimiento.setString(2, direccion);
                    procedimiento.setString(3, telefono);
                    procedimiento.execute();
                }
                int idEditorial = buscarEditorial(nombreEditorial, con);
                altaLibro(isbn, titulo, numeroEjemplares, idAutor, idEditorial, idTema);
                //Hay que dar de alta el libro
                visualizarLibros();
            }

            //inserción de datos: LIBRO
            //visualización de datos
        } catch (SQLException e) {
            System.out.println("Conexión incorrecta2");
            System.out.println(e.getMessage());
        }

    }

    private static boolean existeAutor(String nombreAutor, Connection con) throws SQLException {
        String sentenciaAutor = "Select * from autor where nombreAutor='" + nombreAutor + "'";
        ResultSet sentenciaSelect = con.createStatement().executeQuery(sentenciaAutor);
        if (!sentenciaSelect.next()) {
            return false;
        } else {
            return true;
        }
    }

    private static void altaAutor(String nombreAutor, Connection con) throws SQLException {
        String sentenciaInsert = "insert into autor(nombreAutor) values ('" + nombreAutor + "')";
        con.createStatement().executeUpdate(sentenciaInsert);
    }

    private static int buscarAutor(String nombreAutor, Connection con) throws SQLException {
        String sentenciaAutor = "Select * from autor where nombreAutor='" + nombreAutor + "'";
        ResultSet sentenciaSelect = con.createStatement().executeQuery(sentenciaAutor);
        sentenciaSelect.next();
        return sentenciaSelect.getInt("idAutor");
    }

    private static int buscarTema(String nombreTema, Connection con) {
        int devolver = -1;
        try (PreparedStatement selectTema = con.prepareStatement("SELECT idTema FROM tema WHERE NombreTema=?")) {

            selectTema.setString(1, nombreTema);
            ResultSet salida = selectTema.executeQuery();

            if (salida.next()) {
                devolver = salida.getInt("idTema");
            }

        } catch (SQLException e) {
            System.out.println("Error en la sentencia preparada de BUSCAR TEMA");
        }
        return devolver;
    }

    private static void altaTema(String nombreTema, Connection con) {
        try (PreparedStatement sentenciaInsert = con.prepareStatement("INSERT INTO tema(nombreTema) VALUES (?) ")) {
            sentenciaInsert.setString(1, nombreTema);
            sentenciaInsert.execute();
        } catch (SQLException e) {
            System.out.println("Error en el alta del TEMA");
        }
    }

    private static void altaLibro(String isbn, String titulo, Integer numeroEjemplares, int idAutor, int idEditorial, int idTema) {
        String sentenciaInsert = "INSERT INTO libro(isbn, titulo, NumeroEjemplares, idAutor, idEditorial, idTema) VALUES ('" + isbn + "','" + titulo + "','" + numeroEjemplares + "','" + idAutor + "','" + idEditorial + "','" + idTema + "',)";
    }

    private static int buscarEditorial(String nombreEditorial, Connection con) throws SQLException {
        String sentenciaEditorial2 = "Select * from editorial where NombreEditorial='" + nombreEditorial + "'";
        ResultSet sentenciaSelect = con.createStatement().executeQuery(sentenciaEditorial2);
        sentenciaSelect.next();
        return sentenciaSelect.getInt("idEditorial");
    }

    private static boolean existeEditorial(String nombreEditorial, Connection con) throws SQLException {
        String sentenciaEditorial3 = "Select * from editorial where NombreEditorial='" + nombreEditorial + "'";
        ResultSet sentenciaSelect = con.createStatement().executeQuery(sentenciaEditorial3);
        if (!sentenciaSelect.next()) {
            return false;
        } else {
            return true;
        }
    }
}
