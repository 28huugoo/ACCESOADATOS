/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package starGuarro;

import java.util.ArrayList;

/**
 *
 * @author usuario
 */
public class Personaje {
 
    private String nombre;
    private String altura;
    private ArrayList<Peliculas>peliculas;
    private ArrayList<Especies>especies;

    public Personaje(String nombre, String altura) {
        this.nombre = nombre;
        this.altura = altura;
        this.peliculas=new ArrayList<Peliculas>();
        this.especies=new ArrayList<Especies>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public ArrayList<Peliculas> getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(ArrayList<Peliculas> peliculas) {
        this.peliculas = peliculas;
    }

    public ArrayList<Especies> getEspecies() {
        return especies;
    }

    public void setEspecies(ArrayList<Especies> especies) {
        this.especies = especies;
    }

    public boolean add(Peliculas e) {
        return peliculas.add(e);
    }

    public boolean add(Especies e) {
        return especies.add(e);
    }
}
