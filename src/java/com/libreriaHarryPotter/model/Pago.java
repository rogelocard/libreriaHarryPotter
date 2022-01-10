package com.libreriaHarryPotter.model;

/**
 *
 * @author cardo
 */
public class Pago {
    private int id;
    private Double valorTotal;
    
    public Pago(){
        
    }

    public Pago(int id, Double valorTotal) {
        this.id = id;
        this.valorTotal = valorTotal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }
    
    
}
