package org.model;

import java.time.LocalDate;

public class Disco extends Catalogo
{
    private String titulo;
    private float precio;
    private int existencia;
    private float descuento;
    private LocalDate fecha;
    private String imagen;

    private Disquera disquera;
    private Artista artista;
    private Genero genero;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    public float getDescuento() {
        return descuento;
    }

    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Disquera getDisquera() {
        return disquera;
    }

    public void setDisquera(Disquera disquera) {
        this.disquera = disquera;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return  "titulo='" + titulo + '\'' +
                ", precio=$" + precio +
                ", unidades en existencia=" + existencia +
                ", descuento=" + descuento*100+"%"+
                ", fecha=" + fecha +
                ", imagen='" + imagen + '\'' +
                ", Id artista=" + artista.getId() + " artista: " + artista.getNombre()+
                ", Id disquera=" + disquera.getId() +" disquera: "+disquera.getNombre()+
                ", Id genero=" + genero.getId()+" genero: "+genero.getDescripcion()
                +", id Disco="+id;
    }
}
