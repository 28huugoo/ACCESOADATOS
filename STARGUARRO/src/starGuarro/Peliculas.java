/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package starGuarro;

/**
 *
 * @author usuario
 */
public class Peliculas {
    
    private String titulo;
    private int id_episodio;
    private String opening;
    private String director;

    public Peliculas(String titulo, int id_episodio, String opening, String director) {
        this.titulo = titulo;
        this.id_episodio = id_episodio;
        this.opening = opening;
        this.director = director;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getId_episodio() {
        return id_episodio;
    }

    public void setId_episodio(int id_episodio) {
        this.id_episodio = id_episodio;
    }

    public String getOpening() {
        return opening;
    }

    public void setOpening(String opening) {
        this.opening = opening;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
    
    
}
