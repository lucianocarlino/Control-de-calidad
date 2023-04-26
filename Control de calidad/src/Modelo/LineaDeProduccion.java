/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author User
 */
public class LineaDeProduccion {
    
    private int numero;
    private String descripcion;
    
    private OrdenDeProduccion orden;

    public OrdenDeProduccion getOrden() {
        return orden;
    }

    public void setOrden(OrdenDeProduccion orden) {
        this.orden = orden;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
 
}
