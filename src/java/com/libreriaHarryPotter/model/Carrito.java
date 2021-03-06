package com.libreriaHarryPotter.model;

/**
 *
 * @author cardo
 */
public class Carrito {
    int item;
    int idlibro;
    String nombres; // Titulo del libro
    double precioCompra; // precio
    int cantidad;
    double subTotal;
    
    public Carrito(){
    
    }

    public Carrito(int item, int idlibro, String nombres, double precioCompra, int cantidad, double subTotal) {
        this.item = item;
        this.idlibro = idlibro;
        this.nombres = nombres;
        this.precioCompra = precioCompra;
        this.cantidad = cantidad;
        this.subTotal = subTotal;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public int getIdlibro() {
        return idlibro;
    }

    public void setIdlibro(int idlibro) {
        this.idlibro = idlibro;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }
    
        
}
