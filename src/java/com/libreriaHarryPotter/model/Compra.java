package com.libreriaHarryPotter.model;

import java.util.List;

/**
 *
 * @author RogerCardona
 */
public class Compra {
    private int id;  // id compra
    private Cliente cliente;
    private int idpago;
    private String FechaCompra;
    private int cantidad;
    private Double valorTotal;
    
    private List<Carrito> detallecompras;
    
    public Compra(){
        
    }

    public Compra(Cliente cliente, int idpago, String FechaCompra, int cantidad, Double valorTotal, List<Carrito> detallecompras) {
        this.cliente = cliente;
        this.idpago = idpago;
        this.FechaCompra = FechaCompra;
        this.cantidad = cantidad;
        this.valorTotal = valorTotal;
        this.detallecompras = detallecompras;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getIdpago() {
        return idpago;
    }

    public void setIdpago(int idpago) {
        this.idpago = idpago;
    }


    public String getFechaCompra() {
        return FechaCompra;
    }

    public void setFechaCompra(String FechaCompra) {
        this.FechaCompra = FechaCompra;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public List<Carrito> getDetallecompras() {
        return detallecompras;
    }

    public void setDetallecompras(List<Carrito> detallecompras) {
        this.detallecompras = detallecompras;
    }

    
    
}
