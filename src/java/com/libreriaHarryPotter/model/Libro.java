/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.libreriaHarryPotter.model;

import java.io.InputStream;

/**
 *
 * @author cardo
 */
public class Libro {
    private int idlibro;
    private String titulo;
    private int cantidadStock;
    private double precio;
    private InputStream foto;
    
    public Libro(){
        
    }

    public Libro(int idlibro, String titulo, InputStream foto, int cantidadStock, double precio) {
        this.idlibro = idlibro;
        this.titulo = titulo;
        this.foto = foto;
        this.cantidadStock = cantidadStock;
        this.precio = precio;
    }

    public int getIdlibro() {
        return idlibro;
    }

    public void setIdlibro(int idlibro) {
        this.idlibro = idlibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public InputStream getFoto() {
        return foto;
    }

    public void setFoto(InputStream foto) {
        this.foto = foto;
    }

    public int getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(int cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    
}
