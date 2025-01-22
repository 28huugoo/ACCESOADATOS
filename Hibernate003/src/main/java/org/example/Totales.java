package org.example;

public class Totales {
private Long cuenta;
private Byte numero;
private Double media;
private String nombre;

    public Totales() {
    }

    public Totales(Long cuenta, Byte numero, Double media, String nombre) {
        this.cuenta = cuenta;
        this.numero = numero;
        this.media = media;
        this.nombre = nombre;
    }

    public Long getCuenta() {
        return cuenta;
    }

    public void setCuenta(Long cuenta) {
        this.cuenta = cuenta;
    }

    public Byte getNumero() {
        return numero;
    }

    public void setNumero(Byte numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getMedia() {
        return media;
    }

    public void setMedia(Double media) {
        this.media = media;
    }

    @Override
    public String toString() {
        return "Totales{" +
                "cuenta=" + cuenta +
                ", numero=" + numero +
                ", media=" + media +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
