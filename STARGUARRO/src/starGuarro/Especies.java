/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package starGuarro;

/**
 *
 * @author usuario
 */
public class Especies {
    
    private String nombre;
    private String clasificacion;
    private String designacion;
    private String mediaAltura;

    public Especies(String nombre, String clasificacion, String designacion, String mediaAltura) {
        this.nombre = nombre;
        this.clasificacion = clasificacion;
        this.designacion = designacion;
        this.mediaAltura = mediaAltura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getDesignacion() {
        return designacion;
    }

    public void setDesignacion(String designacion) {
        this.designacion = designacion;
    }

    public String getMediaAltura() {
        return mediaAltura;
    }

    public void setMediaAltura(String mediaAltura) {
        this.mediaAltura = mediaAltura;
    }
    
    
}
