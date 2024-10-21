/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package starGuarro;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author usuario
 */
public class Principal {

    public static void main(String[] args) {
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

            if (eleccion == 1) {
                while (!salirEleccion) {
                    System.out.println("1 para insertar");
                    System.out.println("0 para salir");
                    int subEleccion = teclado.nextInt();
                    if (subEleccion == 1) {
                        System.out.println("Introduce el nombre del personaje");
                        String nombrePersonaje = teclado.next();
                        System.out.println("Introduce la altura del personaje");
                        String altura = teclado.next();

                        Personaje nuevoPersonaje = new Personaje(nombrePersonaje, altura);

                        //peliculas
                        System.out.println("Introduce la cantidad de peliculas");
                        int cantidad = teclado.nextInt();
                        for (int i = 0; i < cantidad; i++) {
                            System.out.println("Introduce el titulo");
                            String titulo = teclado.next();
                            System.out.println("Introduce el id del episodio");
                            int id = teclado.nextInt();
                            System.out.println("Introduce el opening");
                            String opening = teclado.next();
                            System.out.println("Introduce el director");
                            String director = teclado.next();

                            Peliculas p1 = new Peliculas(titulo, id, opening, director);
                            nuevoPersonaje.add(p1);
                        }

                        //especies
                        System.out.println("Introduce el nombre de la especie");
                        String nombreEspecie = teclado.next();
                        System.out.println("Introduce la clasificacion");
                        String clasificacion = teclado.next();
                        System.out.println("Introduce la designacion");
                        String designacion = teclado.next();
                        System.out.println("Introduce la altura media");
                        String altura_media = teclado.next();
                        Especies e1 = new Especies(nombreEspecie, clasificacion, designacion, altura_media);
                        nuevoPersonaje.add(e1);
                        arrayPersonaje.add(nuevoPersonaje);
                        System.out.println("Personaje insertado");
                    }
                    if (subEleccion == 0) {
                        salirEleccion = true;
                    }
                }
            }
            if (eleccion == 2) {

            }
            if (eleccion == 3) {

                while (!salirEleccion) {
                    System.out.println("1 para borrar registro");
                    System.out.println("0 para salir");
                    int subeleccion = teclado.nextInt();
                    teclado.nextLine();
                    if (subeleccion == 1) {
                        System.out.println("Introduce el nombre del personaje a borrar");
                        String nombre = teclado.nextLine();
                        for (int i = 0; i < arrayPersonaje.size(); i++) {
                            if (arrayPersonaje.get(i).getNombre().contains(nombre)) {
                                arrayPersonaje.remove(i);
                            }else{
                                System.out.println("Personaje no encontrado");
                            }
                        }
                    }
                    if (subeleccion == 0) {
                        salirEleccion = true;
                    }
                }

            }

        }

    }
}
