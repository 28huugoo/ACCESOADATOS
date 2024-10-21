/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package starPractica1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import starGuarro.Personaje;

/**
 *
 * @author FP
 */
public class Principal {

    public static void main(String[] args) throws IOException {

Scanner teclado = new Scanner(System.in);

        boolean salir = false;
        ArrayList<Personaje> arrayPersonaje = new ArrayList();
        
          try {
                String contenido = new String(java.nio.file.Files.readAllBytes(java.nio.file.Paths.get("starwars.json")));
                JSONObject jsonLeido = new JSONObject(contenido);
                String nombrePersonaje = jsonLeido.getString("name");
                String altura = jsonLeido.getString("height");
                JSONArray jsonPeliculasLeidas = jsonLeido.getJSONArray("films");
                JSONArray jsonEspeciesLeidas = jsonLeido.getJSONArray("species");
                Personaje personajeLeido = new Personaje(nombrePersonaje, altura);

                for (int i = 0; i < jsonPeliculasLeidas.length(); i++) {
                    JSONObject jsonPeliculas = jsonPeliculasLeidas.getJSONObject(i);
                    String titulo = jsonPeliculas.getString("title");
                    int id_episodio = jsonPeliculas.getInt("episode_id");
                    String opening = jsonPeliculas.getString("opening_crawl");
                    String director = jsonPeliculas.getString("director");

                    Peliculas p1 = new Peliculas(titulo, id_episodio, opening, director);
                    personajeLeido.add(p1);
                }

                for (int i = 0; i < jsonEspeciesLeidas.length(); i++) {
                    JSONObject jsonEspecies = jsonEspeciesLeidas.getJSONObject(i);
                    String nombre = jsonEspecies.getString("name");
                    String clasificacion = jsonEspecies.getString("classification");
                    String designacion = jsonEspecies.getString("designation");
                    String altura_media = jsonEspecies.getString("average_height");

                    Especies e1 = new Especies(nombre, clasificacion, designacion, altura_media);
                    personajeLeido.add(e1);
                }
                arrayPersonaje.add(personajeLeido);

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        
        while (!salir) {

            System.out.println("1 para insertar nuevos registros");
            System.out.println("2 para actualizar");
            System.out.println("3 para borrar");
            System.out.println("0 para salir");
          

            int eleccion = teclado.nextInt();

            if (eleccion == 0) {
                JSONArray jsonPersonajes = new JSONArray();
                for (Personaje p : arrayPersonaje) {
                    JSONObject jsonPersonaje = new JSONObject();
                    jsonPersonaje.put("name", p.getNombre());
                    jsonPersonaje.put("height", p.getAltura());

                    JSONArray jsonPeliculas = new JSONArray();
                    for (Peliculas peli : p.getPeliculas()) {
                        JSONObject jsonPelicula = new JSONObject();
                        jsonPelicula.put("title", peli.getTitulo());
                        jsonPelicula.put("episode_id", peli.getId_episodio());
                        jsonPelicula.put("opening_crawl", peli.getOpening());
                        jsonPelicula.put("director", peli.getDirector());
                        jsonPeliculas.put(jsonPelicula);
                    }
                    jsonPersonaje.put("films", jsonPeliculas);

                    JSONArray jsonEspecies = new JSONArray();
                    for (Especies esp : p.getEspecies()) {
                        JSONObject jsonEspecie = new JSONObject();
                        jsonEspecie.put("name", esp.getNombre());
                        jsonEspecie.put("classification", esp.getClasificacion());
                        jsonEspecie.put("designation", esp.getDesignacion());
                        jsonEspecie.put("average_height", esp.getMediaAltura());
                        jsonEspecies.put(jsonEspecie);
                    }
                    jsonPersonaje.put("species", jsonEspecies);

                    jsonPersonajes.put(jsonPersonaje);

                    try {
                        java.nio.file.Files.write(java.nio.file.Paths.get("starwars2.json"), jsonPersonajes.toString().getBytes());
                    } catch (java.io.IOException e) {
                        e.printStackTrace();
                    }

                    salir = true;
                }

            }

            boolean salirEleccion = false;


        while (!salir) {

            System.out.println("INTRODUCE UN NÚMERO STAR WARS");
            System.out.println("0: guardar");
            System.out.println("1: inseratar registros");
            System.out.println("2: borrar registros");
            System.out.println("3: modificar registros");

            int eleccion = teclado.nextInt();
            boolean subSalir = false;

            if (eleccion == 0) {

                salir = true;
            }
            if (eleccion == 1) {
                while (!subSalir) {

                }
            }
            if (eleccion == 2) {
                while (!subSalir) {

                }
            }
            if (eleccion == 3) {
                while (!subSalir) {

                }
            }

        }
    }
}
